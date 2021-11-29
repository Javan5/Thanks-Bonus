package com.example.Thanks.Bonus.dao;

import com.example.Thanks.Bonus.Controllers.parser.CreditCard;
import com.example.Thanks.Bonus.domain.products.creditCard.CreditCards;

import java.sql.SQLException;
import java.util.List;

public interface CreditCardDAO {

	void addCreditCard(CreditCards creditCard)throws SQLException;

	List<CreditCards> getAllCreditCard() throws SQLException;

	CreditCards getByIdCreditCard(int id) throws SQLException;

	void updateCreditCard(CreditCards creditCard) throws SQLException;

	void deleteCreditCard(CreditCards creditCard) throws SQLException;

}
