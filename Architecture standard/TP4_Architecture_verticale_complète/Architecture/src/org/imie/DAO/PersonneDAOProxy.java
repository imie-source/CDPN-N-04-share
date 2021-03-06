package org.imie.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.imie.DTO.PersonneDTO;
import org.imie.Transaction.AJDBC;
import org.imie.exception.ImieException;

public class PersonneDAOProxy extends AJDBC implements IPersonneDAO {

	IPersonneDAO personneDAO;

	public PersonneDAOProxy() {
		super();
	}

	public PersonneDAOProxy(IPersonneDAO personneDAO) {
		super();
		this.personneDAO = personneDAO;
	}

	@Override
	public PersonneDTO insert(PersonneDTO dtoToInsert) throws ImieException {
		Connection connection = null;
		PersonneDTO retour = null;
		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			personneDAO.beginTransaction(connection);
			retour = personneDAO.insert(dtoToInsert);
			personneDAO.endTransaction();
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
	public PersonneDTO update(PersonneDTO dtoToUpdate) throws ImieException {
		PersonneDTO retour = null;
		Connection connectionLocale = null;
		Boolean slave = false;
		try {
			if (getConnection() != null) {
				slave = true;
				connectionLocale = getConnection();
			} else {
				connectionLocale = openConnection();
				connectionLocale.setAutoCommit(false);
			}

			personneDAO.beginTransaction(connectionLocale);

			retour = personneDAO.update(dtoToUpdate);

			personneDAO.endTransaction();

			if (!slave) {
				connectionLocale.commit();
			}

		} catch (SQLException e) {

			ImieException rollbackException = null;
			if (!slave) {
				try {
					getConnection().rollback();
				} catch (SQLException e1) {
					rollbackException = new ImieException(e1);
				}
			}
			throw new RuntimeException(
					rollbackException != null ? rollbackException : e);

		} finally {
			if (!slave) {
				closeJDBC(getConnection(), null, null);
				setConnection(null);;
			}
		}
		return retour;
	}

	@Override
	public Integer delete(PersonneDTO dtoToDelete) throws ImieException {
		Connection connection = null;
		Integer retour = null;

		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			personneDAO.beginTransaction(connection);
			retour = personneDAO.delete(dtoToDelete);
			personneDAO.endTransaction();
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
	public List<PersonneDTO> findAll() {

		List<PersonneDTO> retour = new ArrayList<PersonneDTO>();
		Connection connectionLocale = null;
		Boolean slave = false;
		try {
			if (getConnection() != null) {
				slave = true;
				connectionLocale = getConnection();
			} else {
				connectionLocale = openConnection();
				connectionLocale.setAutoCommit(false);
			}

			personneDAO.beginTransaction(connectionLocale);

			retour = personneDAO.findAll();

			personneDAO.endTransaction();

			if (!slave) {
				connectionLocale.commit();
				setConnection(null);
			}

		} catch (SQLException e) {

			ImieException rollbackException = null;
			if (!slave) {
				try {
					connectionLocale.rollback();
				} catch (SQLException e1) {
					rollbackException = new ImieException(e1);
				}
			}
			throw new RuntimeException(
					rollbackException != null ? rollbackException : e);

		} finally {
			if (!slave) {
				closeJDBC(getConnection(), null, null);
				setConnection(null);
			}
		}
		return retour;
	}

	@Override
	public List<PersonneDTO> findByDTO(PersonneDTO dtoSearched) {
		Connection connection = null;
		List<PersonneDTO> retour = new ArrayList<PersonneDTO>();
		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			personneDAO.beginTransaction(connection);
			retour = personneDAO.findByDTO(dtoSearched);
			personneDAO.endTransaction();
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
