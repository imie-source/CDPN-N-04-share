/**
 * 
 */
package org.imie.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author imie
 *
 */
public class AJDBC implements ITransactional {
	
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
//		System.out.printf("SetConnexion  : %s :  %s\n",this.getClass(),connection);
		this.connection = connection;
	}

	protected Connection openConnection() throws SQLException {
		Connection connection;
		connection = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/imie",
						"postgres", "postgres");
		return connection;
	}

	protected void closeJDBC(Connection connection, Statement statement,
			ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void beginTransaction(Connection connection) {
		System.out.printf("Transactional BEGIN : %s\n",this.getClass());
		setConnection(connection);
	}

	@Override
	public void endTransaction() {
		System.out.printf("Transactional END   : %s\n",this.getClass());
		setConnection(null);
	}

}
