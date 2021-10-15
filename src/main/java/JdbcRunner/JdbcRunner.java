package JdbcRunner;

import JdbcRunner.utill.ConnectionManager;
import lombok.var;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class JdbcRunner {
	public static void main(String[] args) throws SQLException {
		Class<Driver> driverClass = Driver.class;
		try(var connection = ConnectionManager.open()) {
			System.out.println(connection.getTransactionIsolation());
		}

	}
}
