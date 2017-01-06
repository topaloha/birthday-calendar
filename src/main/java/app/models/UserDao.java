package app.models;

		import app.domain.Person;
		import org.springframework.stereotype.Repository;
		import org.springframework.transaction.annotation.Transactional;

		import javax.persistence.EntityManager;
		import javax.persistence.PersistenceContext;
		import java.util.List;

@Transactional
@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Person person) {
		entityManager.persist(person);
	}

	public List getAll() {
		return entityManager.createQuery("from Person").getResultList();
	}

}
