package app.domain.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String userName;
	@Column(name = "password", nullable = false, length = 60)
	private String password;
	@Column(name="enabled", nullable = false)
	private boolean enabled;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRoles = new HashSet<>();

	public User() {}

	public User(String userName, String password, boolean enabled) {
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String userName, String password, boolean enabled, Set<UserRole> userRoles) {
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
