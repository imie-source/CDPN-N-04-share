package org.imie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TPJDBC {

	public static void main(String[] args) {
		// String nom = args.length>=1?args[0]:null;
		// String prenom = args.length>=2?args[1]:null;
		// String[] arguments = {"chi","jo"};
		Date dateNaiss;
		try {
			dateNaiss = new SimpleDateFormat("dd/MM/yyyy").parse("01/06/1926");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	
		insert("Monroe", "Marilyn",dateNaiss );

	}

	private static void insert(String nom, String prenom, Date dateNaiss) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");
			statement = connection.createStatement();
			String query = String
					.format("INSERT into personne (nom,prenom,datenaiss) values ('%s','%s','%tF')",
							nom, prenom, dateNaiss);
			Integer nbLigneInserted = statement.executeUpdate(query);
			System.out.format("%d lignes insérée(s)", nbLigneInserted);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
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
	}

	private static void findByNomAndPrenom(String nom, String prenom) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");
			statement = connection.createStatement();
			String query = "SELECT id,nom,prenom,datenaiss FROM personne ";

			Boolean firstConstrainte = true;
			if (nom != null) {
				query = query.concat(firstConstrainte ? "WHERE " : "AND ")
						.concat("nom ilike'%").concat(nom).concat("%' ");
				firstConstrainte = false;
			}

			if (prenom != null) {
				query = query.concat(firstConstrainte ? "WHERE " : "AND ")
						.concat("prenom ilike'%").concat(prenom).concat("%' ");
				firstConstrainte = false;
			}

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.format(
						"nom :%s | prenom:%s | date de naissance : %tF \n",
						resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getDate("datenaiss"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
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
	}

	private static void findByMultipleCriteria(String[] criterias) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");
			statement = connection.createStatement();
			String query = "SELECT id,nom,prenom,datenaiss FROM personne ";

			Boolean firstConstrainte = true;

			for (String criteria : criterias) {
				query = query.concat(firstConstrainte ? "WHERE " : "AND ")
						.concat("(nom ilike'%").concat(criteria)
						.concat("%' OR ").concat("prenom ilike'%")
						.concat(criteria).concat("%') ");
				firstConstrainte = false;
			}

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.format(
						"nom :%s | prenom:%s | date de naissance : %tF \n",
						resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getDate("datenaiss"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
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
	}

	private static void findAll() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT id,nom,prenom,datenaiss FROM personne");

			while (resultSet.next()) {
				System.out.format(
						"nom :%s | prenom:%s | date de naissance : %tF \n",
						resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getDate("datenaiss"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
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
	}
}
