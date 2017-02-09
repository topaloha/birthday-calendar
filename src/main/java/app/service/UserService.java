package app.service;

import app.domain.security.User;
import app.dto.UserDto;
import app.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	public void saveUser(UserDto user) {
		User newUser = new User(user.getLogin(), passwordEncoder.encode(user.getPassword()), true);
		userDao.insertNewUser(newUser);
	}
}
