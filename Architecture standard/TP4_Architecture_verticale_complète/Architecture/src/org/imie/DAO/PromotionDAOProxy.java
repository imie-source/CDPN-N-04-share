package org.imie.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.imie.DTO.PersonneDTO;
import org.imie.DTO.PromotionDTO;
import org.imie.Transaction.AJDBC;
import org.imie.exception.ImieException;

public class PromotionDAOProxy extends AJDBC implements IPromotionDAO {

	IPromotionDAO promotionDAO;

	public PromotionDAOProxy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromotionDAOProxy(IPromotionDAO promotionDAO) {
		super();
		this.promotionDAO = promotionDAO;
	}

	@Override
	public PromotionDTO insert(PromotionDTO dtoToInsert) throws ImieException {
		Connection connection = null;
		PromotionDTO retour = null;
		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			promotionDAO.beginTransaction(connection);
			retour = promotionDAO.insert(dtoToInsert);
			promotionDAO.endTransaction();
			connection.commit();

		} catch (SQLException e) {

			ImieException rollbackException = null;
			// if (!slave) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				rollbackException = new ImieException(e1);
			}
			// }
			throw new RuntimeException(
					rollbackException != null ? rollbackException : e);

		} finally {
			closeJDBC(connection, null, null);
			connection=null;
		}
		return retour;
	}

	@Override
	public PromotionDTO update(PromotionDTO dtoToUpdate) throws ImieException {
		Connection connection = null;
		PromotionDTO retour = null;
		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			promotionDAO.beginTransaction(connection);
			retour = promotionDAO.update(dtoToUpdate);
			promotionDAO.endTransaction();
			connection.commit();

		} catch (SQLException e) {

			ImieException rollbackException = null;
			// if (!slave) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				rollbackException = new ImieException(e1);
			}
			// }
			throw new RuntimeException(
					rollbackException != null ? rollbackException : e);

		} finally {
			closeJDBC(connection, null, null);
			connection=null;
		}
		return retour;
	}

	@Override
	public Integer delete(PromotionDTO dtoToDelete) throws ImieException {
		Connection connectionLocale = null;
		Connection connection = null;
		Integer retour = null;
		Boolean slave = false;
		try {
			if (connection != null) {
				slave = true;
				connectionLocale = connection;
			} else {
				connectionLocale = openConnection();
				connectionLocale.setAutoCommit(false);
			}

			promotionDAO.beginTransaction(connectionLocale);

			retour = promotionDAO.delete(dtoToDelete);

			promotionDAO.endTransaction();

			if (!slave) {
				connectionLocale.commit();
			}
		} catch (SQLException e) {

			ImieException rollbackException = null;
			if (!slave) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					rollbackException = new ImieException(e1);
				}
			}
			throw new RuntimeException(
					rollbackException != null ? rollbackException : e);

		} finally {
			if (!slave) {
				closeJDBC(connection, null, null);
				connection=null;
			}
		}
		return retour;
	}

	@Override
	public List<PromotionDTO> findAll() {
		Connection connection = null;
		List<PromotionDTO> retour = new ArrayList<PromotionDTO>();
		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			promotionDAO.beginTransaction(connection);
			retour = promotionDAO.findAll();
			promotionDAO.endTransaction();
			connection.commit();

		} catch (SQLException e) {

			ImieException rollbackException = null;
			// if (!slave) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				rollbackException = new ImieException(e1);
			}
			// }
			throw new RuntimeException(
					rollbackException != null ? rollbackException : e);

		} finally {
			closeJDBC(connection, null, null);
			connection=null;
		}
		return retour;
	}

	@Override
	public List<PromotionDTO> findByDTO(PromotionDTO dtoSearched) {
		Connection connection = null;
		List<PromotionDTO> retour = new ArrayList<PromotionDTO>();
		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			promotionDAO.beginTransaction(connection);
			retour = promotionDAO.findByDTO(dtoSearched);
			promotionDAO.endTransaction();
			connection.commit();

		} catch (SQLException e) {

			ImieException rollbackException = null;
			// if (!slave) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				rollbackException = new ImieException(e1);
			}
			// }
			throw new RuntimeException(
					rollbackException != null ? rollbackException : e);

		} finally {
			closeJDBC(connection, null, null);
			connection=null;
		}
		return retour;
	}


}
