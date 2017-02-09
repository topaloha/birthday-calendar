package app.models;

import app.domain.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public User findByUserName(String userName) {
		List<User> users = new ArrayList<>();

		users = entityManager.createQuery("from User where username=?")
				.setParameter(0, userName)
				.getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public void insertNewUser(User user) {
		entityManager.persist(user);
	}

}
