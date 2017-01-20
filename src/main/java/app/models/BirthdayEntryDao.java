package app.models;

		import app.domain.BirthdayEntry;
		import org.springframework.stereotype.Repository;
		import org.springframework.transaction.annotation.Transactional;

		import javax.persistence.EntityManager;
		import javax.persistence.PersistenceContext;
		import java.util.List;

@Transactional
@Repository
public class BirthdayEntryDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(BirthdayEntry birthdayEntry) {
		entityManager.persist(birthdayEntry);
	}

	public List getAll() {
		return entityManager.createQuery("from BirthdayEntry").getResultList();
	}

	public void createEntry(BirthdayEntry birthdayEntry) {
		entityManager.persist(birthdayEntry);
	}

}
