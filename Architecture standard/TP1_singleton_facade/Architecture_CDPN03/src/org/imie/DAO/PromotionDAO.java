/**
 * 
 */
package org.imie.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.imie.DTO.PersonneDTO;
import org.imie.DTO.PromotionDTO;
import org.imie.exception.ImieException;

/**
 * @author imie
 *
 */
public class PromotionDAO extends AJDBC implements IPromotionDAO {

	private static PromotionDAO promotionDAO;

	private PromotionDAO() {

	}

	public static PromotionDAO getInstance() {
		if (promotionDAO == null) {
			promotionDAO = new PromotionDAO();
		}
		return promotionDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IDAO#insert(java.lang.Object)
	 */
	@Override
	public PromotionDTO insert(PromotionDTO dtoToInsert) throws ImieException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IDAO#update(java.lang.Object)
	 */
	@Override
	public PromotionDTO update(PromotionDTO dtoToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(PromotionDTO dtoToDelete, Connection connection)
			throws ImieException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Integer retour = null;
		Boolean slave = false;

		try {
			if (connection != null) {
				slave = true;
			} else {
				connection = openConnection();
				connection.setAutoCommit(false);
			}

			String query = "DELETE from promotion WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, dtoToDelete.getId());

			retour = statement.executeUpdate();
			if (!slave) {
				connection.commit();
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new ImieException(e);
			}
			throw new RuntimeException(e);
		} finally {
			closeJDBC(slave ? null : connection, statement, resultSet);
		}
		return retour;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IDAO#delete(java.lang.Object)
	 */
	@Override
	public Integer delete(PromotionDTO dtoToDelete) throws ImieException {
		return delete(dtoToDelete, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IDAO#findAll()
	 */
	@Override
	public List<PromotionDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IDAO#findByDTO(java.lang.Object)
	 */
	@Override
	public List<PromotionDTO> findByDTO(PromotionDTO dtoSearched) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<PromotionDTO> retour = new ArrayList<PromotionDTO>();
		try {
			connection = openConnection();

			List<ParamJDBC> paramsList = new ArrayList<ParamJDBC>();
			if (dtoSearched.getId() != null) {
				paramsList.add(new ParamJDBC("id", dtoSearched.getId()));
			}
			if (dtoSearched.getLibelle() != null) {
				paramsList.add(new ParamJDBC("libelle", dtoSearched
						.getLibelle()));
			}

			String whereQuery = "";
			Boolean firstField = true;
			for (ParamJDBC paramJDBC : paramsList) {

				whereQuery = whereQuery.concat(firstField ? "WHERE " : "AND")
						.concat(paramJDBC.getNom()).concat(" = ? ");
				firstField = false;
			}

			Boolean firstRestriction = true;
			String query = "SELECT id,libelle FROM promotion "
					.concat(whereQuery);

			statement = connection.prepareStatement(query);

			Integer paraNumber = 1;
			for (ParamJDBC paramJDBC : paramsList) {
				statement.setObject(paraNumber++, paramJDBC.getValue());
			}

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				PromotionDTO personneDTO = buildDTOFromResultset(resultSet);
				retour.add(personneDTO);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeJDBC(connection, statement, resultSet);
		}
		return retour;
	}

	private PromotionDTO buildDTOFromResultset(ResultSet resultSet)
			throws SQLException {
		PromotionDTO retour = new PromotionDTO();
		retour.setId(resultSet.getInt("id"));
		retour.setLibelle(resultSet.getString("libelle"));
		return retour;
	}

}
