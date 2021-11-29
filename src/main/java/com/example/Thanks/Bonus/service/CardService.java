package com.example.Thanks.Bonus.service;

import com.example.Thanks.Bonus.Controllers.parser.CreditCard;
import com.example.Thanks.Bonus.dao.CardDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static JdbcRunner.utill.ConnectionManager.open;


public class CardService implements CardDAO {


/*
	private final CardCredit cardCredit;

	@Autowired
	public ControllerForCreditCard(CardCredit cardCredit) {
		this.cardCredit = cardCredit;
	}

	@GetMapping("{id}")
	public CreditCardDB getOne(@PathVariable("id") CreditCardDB creditCardDB) {
		return creditCardDB;
	}

	@GetMapping
	public List<CreditCardDB> list(){
		return cardCredit.findAll();
	}

	@PostMapping
	public CreditCardDB create(@RequestBody CreditCardDB creditCardDB) {
		return cardCredit.save(creditCardDB);
	}

	@PutMapping("{id}")
	public CreditCardDB update(
			@PathVariable("id") CreditCardDB bankInfoFromDb,
			@RequestBody CreditCardDB creditCardDB
	) {
		BeanUtils.copyProperties(creditCardDB, bankInfoFromDb, "id");
		return creditCardDB.save(bankInfoFromDb);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") CreditCardDB bankInfo) {
		cardCredit.delete(bankInfo);
	}


*/







Connection connection = open();


/*	@Override
	public void add(CreditCardDB creditCardDB) throws SQLException {
		PreparedStatement preparedStatement = null;

		String sql = "INSERT INTO public.\"creditCardDB\" ( ID, namecard, \"grPeriod\", limits, cashback) VALUES(?, ?, ?, ?, ?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, creditCardDB.getId());
			preparedStatement.setString(2, creditCardDB.getName());
			preparedStatement.setInt(3, creditCardDB.getGrPeriod());
			preparedStatement.setInt(4, creditCardDB.getLimit());
			preparedStatement.setDouble(5, creditCardDB.getCashback());
			preparedStatement.executeLargeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			 if (preparedStatement != null) {
			 	preparedStatement.close();
			 }
			 if (connection != null) {
			 	connection.close();
			 }
		}
	}*/

	public void addCreditCard(CreditCard creditCard) throws SQLException {
		PreparedStatement preparedStatement = null;

		String sql = "INSERT INTO public.\"creditCardDB\" ( ID, namecard, \"grPeriod\", limits, cashback) VALUES(?, ?, ?, ?, ?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, creditCard.getId());
			preparedStatement.setString(2, creditCard.getName());
			preparedStatement.setInt(3, creditCard.getGrPeriod());
			preparedStatement.setInt(4, creditCard.getLimit());
			preparedStatement.setDouble(5, creditCard.getCashback());
			preparedStatement.executeLargeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}


	@Override
	public List<CreditCard> getAll() throws SQLException {
		List<CreditCard> creditCardList = new ArrayList<>();
		String sql = "SELECT ( ID, namecard, \"grPeriod\", limits, cashback) FROM public.\"creditCardDB\"";

		Statement statement = null;
		try{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				CreditCard creditCard = new CreditCard();
				creditCard.setId(resultSet.getInt("ID"));
				creditCard.setName(resultSet.getString("namecard"));
				creditCard.setGrPeriod(resultSet.getInt("\"grPeriod\""));
				creditCard.setLimit(resultSet.getInt("limits"));
				creditCard.setCashback(resultSet.getDouble("cashback"));

				creditCardList.add(creditCard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return creditCardList;
	}

	@Override
	public CreditCard getById(Long id) throws SQLException {
		PreparedStatement preparedStatement = null;

		String sql = "SELECT ( ID, namecard, \"grPeriod\", limits, cashback) FROM public.\"creditCardDB\" WHERE ID=?";
		CreditCard creditCard = new CreditCard();
		try{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				creditCard.setId(resultSet.getInt("ID"));
				creditCard.setName(resultSet.getString("namecard"));
				creditCard.setGrPeriod(resultSet.getInt("\"grPeriod\""));
				creditCard.setLimit(resultSet.getInt("limits"));
				creditCard.setCashback(resultSet.getDouble("cashback"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return creditCard;

	}

	@Override
	public void update(CreditCard creditCard) throws SQLException {
		PreparedStatement preparedStatement = null;

		String sql = "UPDATE public.\"creditCardDB\" SET (cashback=?,limits=?,\"grPeriod\"=?, namecard=?) WHERE ID=?";
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, creditCard.getCashback());
			preparedStatement.setInt(2, creditCard.getLimit());
			preparedStatement.setInt(3, creditCard.getGrPeriod());
			preparedStatement.setString(4, creditCard.getName());
			preparedStatement.setInt(5, creditCard.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public void delete(CreditCard creditCard) throws SQLException {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM  public.\"creditCardDB\" WHERE ID=?";

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, creditCard.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}
