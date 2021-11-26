package com.example.Thanks.Bonus.dao;

import com.example.Thanks.Bonus.Controllers.parser.creditCard;
import com.example.Thanks.Bonus.domain.products.creditCard.CreditCardDB;

import java.sql.SQLException;
import java.util.List;

public interface CardDAO {
	void add(CreditCardDB creditCardDB) throws SQLException;
	void addCreditCard(creditCard creditCard)throws SQLException;

	List<creditCard> getAll() throws SQLException;

	creditCard getById(Long id) throws SQLException;

	void update(creditCard creditCard) throws SQLException;

	void delete(creditCard creditCard) throws SQLException;



}
