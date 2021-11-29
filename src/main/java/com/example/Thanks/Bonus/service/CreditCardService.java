package com.example.Thanks.Bonus.service;

import JdbcRunner.utill.SessionUtil;
import com.example.Thanks.Bonus.Controllers.parser.CreditCard;
import com.example.Thanks.Bonus.dao.CreditCardDAO;
import com.example.Thanks.Bonus.domain.products.creditCard.CreditCards;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CreditCardService extends SessionUtil implements CreditCardDAO {
	@Override
	public void addCreditCard(CreditCards creditCard) throws SQLException {
		openTransactionSession();

		Session session = getSession();
		session.save(creditCard);

		closeTransactionSession();
	}

	@Override
	public List<CreditCards> getAllCreditCard() throws SQLException {
		openTransactionSession();

		String sql = "SELECT * FROM CREDITCARD";

		Session session = getSession();
		Query query = session.createNativeQuery(sql).addEntity(CreditCards.class);
		List<CreditCards> creditCards = query.list();

		closeTransactionSession();
		return creditCards;
	}

	@Override
	public CreditCards getByIdCreditCard(int id) throws SQLException {
		openTransactionSession();

		String sql = "SELECT * FROM CREDITCARD WHERE ID=:id";

		Session session = getSession();
		Query query = session.createNativeQuery(sql).addEntity(CreditCards.class);
		query.setParameter("id", id);

		CreditCards creditCards = (CreditCards) query.getSingleResult();

		closeTransactionSession();

		return creditCards;
	}

	@Override
	public void updateCreditCard(CreditCards creditCard) throws SQLException {
		openTransactionSession();

		Session session = getSession();
		session.update(creditCard);

		closeTransactionSession();
	}

	@Override
	public void deleteCreditCard(CreditCards creditCard) throws SQLException {
    openTransactionSession();

    Session session = getSession();
    session.remove(creditCard);

    closeTransactionSession();
	}
}
