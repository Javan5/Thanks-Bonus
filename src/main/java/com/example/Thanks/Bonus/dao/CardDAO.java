package com.example.Thanks.Bonus.dao;

import com.example.Thanks.Bonus.Controllers.parser.CreditCard;

import java.sql.SQLException;
import java.util.List;

public interface CardDAO {
	//void add(CreditCardDB creditCardDB) throws SQLException;
	void addCreditCard(CreditCard creditCard)throws SQLException;

	List<CreditCard> getAll() throws SQLException;

	CreditCard getById(Long id) throws SQLException;

	void update(CreditCard creditCard) throws SQLException;

	void delete(CreditCard creditCard) throws SQLException;



}
