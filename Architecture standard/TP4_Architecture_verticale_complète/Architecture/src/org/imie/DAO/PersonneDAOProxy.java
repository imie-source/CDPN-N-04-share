package org.imie.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.imie.DTO.PersonneDTO;
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
		}
		return retour;

	}

	@Override
	public PersonneDTO update(PersonneDTO dtoToUpdate) throws ImieException {
		Connection connection = null;
		PersonneDTO retour = null;
		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			personneDAO.beginTransaction(connection);
			retour = personneDAO.update(dtoToUpdate);
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
		}
		return retour;
	}

	@Override
	public List<PersonneDTO> findAll() {
		Connection connection = null;
		List<PersonneDTO> retour = new ArrayList<PersonneDTO>();
		try {
			connection = openConnection();
			connection.setAutoCommit(false);
			personneDAO.beginTransaction(connection);
			retour = personneDAO.findAll();
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
		}
		return retour;
	}

	@Override
	public void beginTransaction(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void endTransaction() {
		// TODO Auto-generated method stub

	}

}
