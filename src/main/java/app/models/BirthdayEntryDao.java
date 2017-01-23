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
}
