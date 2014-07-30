package org.imie.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.imie.DTO.PersonneDTO;
import org.imie.exception.ImieException;

public class PersonneDAO {

	public PersonneDTO insert(PersonneDTO personneToInsert) throws ImieException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PersonneDTO retour = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");

			List<ParamJDBC> paramsList= new ArrayList<ParamJDBC>();
			if (personneToInsert.getNom()!=null){
				paramsList.add(new ParamJDBC("nom",personneToInsert.getNom()));
			}
			if (personneToInsert.getPrenom()!=null){
			paramsList.add(new ParamJDBC("prenom",personneToInsert.getPrenom()));
			}
			if (personneToInsert.getDateNaiss()!=null){
				paramsList.add(new ParamJDBC("datenaiss",new Date(personneToInsert.getDateNaiss().getTime())));
			}
			
			String fields="";
			String params="";
			Boolean firstField=true;
			for (ParamJDBC paramJDBC : paramsList) {
				fields=fields.concat(firstField?"":",") .concat(paramJDBC.getNom());
				params=params.concat(firstField?"":",") .concat("?");
				firstField=false;
			}
			
			String query = "INSERT into personne (".concat(fields).concat(") values (").concat(params).concat(") returning id, nom, prenom, datenaiss");

			statement = connection.prepareStatement(query);
			
			Integer paraNumber=1;
			for (ParamJDBC paramJDBC : paramsList) {
				statement.setObject(paraNumber++, paramJDBC.getValue());
			}
			

			resultSet = statement.executeQuery();
			resultSet.next();
			retour = new PersonneDTO();
			retour.setId(resultSet.getInt("id"));
			retour.setNom(resultSet.getString("nom"));
			retour.setPrenom(resultSet.getString("prenom"));
			retour.setDateNaiss(resultSet.getDate("datenaiss"));

		} catch (SQLException e) {
			throw new ImieException("impossible d'insérer une personne",e);
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
		return retour;
	}

	public PersonneDTO update(PersonneDTO personneToUpdate) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PersonneDTO retour = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");

			String query = "UPDATE personne set nom=?, prenom=?, datenaiss=? WHERE id =? returning id,nom,prenom,datenaiss";

			statement = connection.prepareStatement(query);
			statement.setString(1, personneToUpdate.getNom());
			statement.setString(2, personneToUpdate.getPrenom());
			statement.setDate(3, new Date(personneToUpdate.getDateNaiss()
					.getTime()));
			statement.setInt(4, personneToUpdate.getId());

			resultSet = statement.executeQuery();
			resultSet.next();
			retour = new PersonneDTO();
			retour.setId(resultSet.getInt("id"));
			retour.setNom(resultSet.getString("nom"));
			retour.setPrenom(resultSet.getString("prenom"));
			retour.setDateNaiss(resultSet.getDate("datenaiss"));

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
		return retour;
	}

	public Integer delete(PersonneDTO personneToDelete) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Integer retour = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");
			String query = "DELETE from personne WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, personneToDelete.getId());

			retour = statement.executeUpdate();

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
		return retour;
	}

	public List<PersonneDTO> findAll() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<PersonneDTO> retour = new ArrayList<PersonneDTO>();
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT id,nom,prenom,datenaiss FROM personne");

			while (resultSet.next()) {
				PersonneDTO personneDTO = new PersonneDTO();
				personneDTO.setId(resultSet.getInt("id"));
				personneDTO.setNom(resultSet.getString("nom"));
				personneDTO.setPrenom(resultSet.getString("prenom"));
				personneDTO.setDateNaiss(resultSet.getDate("datenaiss"));
				retour.add(personneDTO);
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
		return retour;
	}

	public List<PersonneDTO> findByPersonne(PersonneDTO personneDTOSearched) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<PersonneDTO> retour = new ArrayList<PersonneDTO>();
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/imie", "postgres",
					"postgres");

			Boolean firstRestriction = true;
			String query = "SELECT id,nom,prenom,datenaiss FROM personne ";
			if (personneDTOSearched.getNom() != null) {
				query = query.concat(firstRestriction ? "WHERE " : "AND ")
						.concat("nom ilike ? ");
				firstRestriction = false;
			}
			if (personneDTOSearched.getPrenom() != null) {
				query = query.concat(firstRestriction ? "WHERE " : "AND ")
						.concat("prenom ilike ? ");
				firstRestriction = false;
			}
			if (personneDTOSearched.getDateNaiss() != null) {
				query = query.concat(firstRestriction ? "WHERE " : "AND ")
						.concat("datenaiss = ? ");
				firstRestriction = false;
			}

			statement = connection.prepareStatement(query);

			Integer paramNumber = 1;
			if (personneDTOSearched.getNom() != null) {
				statement.setString(paramNumber++,
						String.format("%%%s%%", personneDTOSearched.getNom()));
			}
			if (personneDTOSearched.getPrenom() != null) {
				statement.setString(paramNumber++, String.format("%%%s%%",
						personneDTOSearched.getPrenom()));
			}
			if (personneDTOSearched.getDateNaiss() != null) {
				statement.setDate(paramNumber++, new Date(personneDTOSearched
						.getDateNaiss().getTime()));
			}

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				PersonneDTO personneDTO = new PersonneDTO();
				personneDTO.setId(resultSet.getInt("id"));
				personneDTO.setNom(resultSet.getString("nom"));
				personneDTO.setPrenom(resultSet.getString("prenom"));
				personneDTO.setDateNaiss(resultSet.getDate("datenaiss"));
				retour.add(personneDTO);
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
		return retour;
	}

}
