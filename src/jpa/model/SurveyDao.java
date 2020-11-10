package jpa.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import jpa.model.Survey;
import utils.HibernateUtil;

public class SurveyDao {

	public void saveSurvey(Survey survey) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction

			transaction = session.beginTransaction();

			// save the student object

			session.save(survey);

			// commit transaction

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();

			}

			e.printStackTrace();

		}
	}

	public List<Survey> getSurveys() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			return session.createQuery("from Survey", Survey.class).list();

		}

	}

}
