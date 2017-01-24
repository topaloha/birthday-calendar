package app.models;

import app.domain.BirthdayEntry;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Transactional
@Repository
public class BirthdayEntryDao {

	private static Logger logger = LoggerFactory.getLogger(BirthdayEntryDao.class);
	private static String UPDATE_BIRTHDAY_ENTRY_QUERY = "update BirthdayEntry b set b.birthday= :birthday," +
			"                                                b.firstName=:firstName, b.lastName=:lastName";

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

	public void deleteEntryById(long id) {
		logger.info("About to delete birthday entry with id {}", id);

		Query deleteQuery = entityManager.createQuery("delete from BirthdayEntry b where b.id = :id");
		deleteQuery.setParameter("id", id);
		deleteQuery.executeUpdate();
	}

	public BirthdayEntry getEntryById(long id) {
		Query findByIdQuery = entityManager.createQuery("from BirthdayEntry b where b.id = :id");
		findByIdQuery.setParameter("id", id);
		return (BirthdayEntry) findByIdQuery.getSingleResult();
	}

	public void updateEntity(BirthdayEntry birthdayEntry) {
		Query updateQuery = entityManager.createQuery(UPDATE_BIRTHDAY_ENTRY_QUERY);
		updateQuery.setParameter("birthday", birthdayEntry.getBirthday());
		updateQuery.setParameter("firstName", birthdayEntry.getFirstName());
		updateQuery.setParameter("lastName", birthdayEntry.getLastName());
		updateQuery.executeUpdate();

	}
}
