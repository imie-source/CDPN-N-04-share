//package org.imie.service;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.imie.DTO.PersonneDTO;
//import org.imie.DTO.PromotionDTO;
//import org.imie.Transaction.AJDBC;
//import org.imie.exception.ImieException;
//
//public class EcoleServiceProxy extends AJDBC implements IEcoleService {
//
//	private IEcoleService ecoleService;
//
//	public EcoleServiceProxy() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public EcoleServiceProxy(IEcoleService ecoleService) {
//		super();
//		this.ecoleService = ecoleService;
//	}
//
//	@Override
//	public PersonneDTO insertPersonne(PersonneDTO dtoToInsert)
//			throws ImieException {
//		PersonneDTO retour = null;
//		try {
//			connection = openConnection();
//			connection.setAutoCommit(false);
//			ecoleService.beginTransaction(connection);
//			retour = ecoleService.insertPersonne(dtoToInsert);
//			ecoleService.endTransaction();
//			connection.commit();
//
//		} catch (SQLException e) {
//
//			ImieException rollbackException = null;
//			// if (!slave) {
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				rollbackException = new ImieException(e1);
//			}
//			// }
//			throw new RuntimeException(
//					rollbackException != null ? rollbackException : e);
//
//		} finally {
//			closeJDBC(connection, null, null);
//		}
//		return retour;
//	}
//
//	@Override
//	public PersonneDTO updatePersonne(PersonneDTO dtoToUpdate)
//			throws ImieException {
//		PersonneDTO retour = null;
//		try {
//			connection = openConnection();
//			connection.setAutoCommit(false);
//			ecoleService.beginTransaction(connection);
//			retour = ecoleService.updatePersonne(dtoToUpdate);
//			ecoleService.endTransaction();
//			connection.commit();
//
//		} catch (SQLException e) {
//
//			ImieException rollbackException = null;
//			// if (!slave) {
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				rollbackException = new ImieException(e1);
//			}
//			// }
//			throw new RuntimeException(
//					rollbackException != null ? rollbackException : e);
//
//		} finally {
//			closeJDBC(connection, null, null);
//		}
//		return retour;
//	}
//
//	@Override
//	public Integer deletePersonne(PersonneDTO dtoToDelete) throws ImieException {
//		Integer retour = null;
//		try {
//			connection = openConnection();
//			connection.setAutoCommit(false);
//			ecoleService.beginTransaction(connection);
//			retour = ecoleService.deletePersonne(dtoToDelete);
//			ecoleService.endTransaction();
//			connection.commit();
//
//		} catch (SQLException e) {
//
//			ImieException rollbackException = null;
//			// if (!slave) {
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				rollbackException = new ImieException(e1);
//			}
//			// }
//			throw new RuntimeException(
//					rollbackException != null ? rollbackException : e);
//
//		} finally {
//			closeJDBC(connection, null, null);
//		}
//		return retour;
//	}
//
//	@Override
//	public List<PersonneDTO> findAllPersonne() {
//		List<PersonneDTO> retour = new ArrayList<PersonneDTO>();
//		try {
//			connection = openConnection();
//			connection.setAutoCommit(false);
//			ecoleService.beginTransaction(connection);
//			retour = ecoleService.findAllPersonne();
//			ecoleService.endTransaction();
//			connection.commit();
//
//		} catch (SQLException e) {
//
//			ImieException rollbackException = null;
//			// if (!slave) {
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				rollbackException = new ImieException(e1);
//			}
//			// }
//			throw new RuntimeException(
//					rollbackException != null ? rollbackException : e);
//
//		} finally {
//			closeJDBC(connection, null, null);
//			connection=null;
//		}
//		return retour;
//	}
//
//	@Override
//	public List<PersonneDTO> findByDTOPersonne(PersonneDTO dtoSearched) {
//		List<PersonneDTO> retour = new ArrayList<PersonneDTO>();
//		try {
//			connection = openConnection();
//			connection.setAutoCommit(false);
//			ecoleService.beginTransaction(connection);
//			retour = ecoleService.findByDTOPersonne(dtoSearched);
//			ecoleService.endTransaction();
//			connection.commit();
//
//		} catch (SQLException e) {
//
//			ImieException rollbackException = null;
//			// if (!slave) {
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				rollbackException = new ImieException(e1);
//			}
//			// }
//			throw new RuntimeException(
//					rollbackException != null ? rollbackException : e);
//
//		} finally {
//			closeJDBC(connection, null, null);
//			connection=null;
//		}
//		return retour;
//	}
//
//	@Override
//	public Integer deletePromotion(PromotionDTO dtoToDelete)
//			throws ImieException {
//		Integer retour;
//		Connection connectionLocale = null;
//		Boolean slave = false;
//		try {
//			if (connection != null) {
//				slave = true;
//				connectionLocale = connection;
//			} else {
//				connectionLocale = openConnection();
//				connectionLocale.setAutoCommit(false);
//			}
//
//			ecoleService.beginTransaction(connectionLocale);
//
//			retour = ecoleService.deletePromotion(dtoToDelete);
//
//			ecoleService.endTransaction();
//
//			if (!slave) {
//				connectionLocale.commit();
//			}
//
//		} catch (SQLException e) {
//
//			ImieException rollbackException = null;
//			if (!slave) {
//				try {
//					connection.rollback();
//				} catch (SQLException e1) {
//					rollbackException = new ImieException(e1);
//				}
//			}
//			throw new RuntimeException(
//					rollbackException != null ? rollbackException : e);
//		} finally {
//			if (!slave) {
//				closeJDBC(connection, null, null);
//				connection=null;
//			}
//		}
//		return retour;
//	}
//
//	@Override
//	public List<PromotionDTO> findByDTOPromotion(PromotionDTO dtoSearched) {
//		List<PromotionDTO> retour = new ArrayList<PromotionDTO>();
//		try {
//			connection = openConnection();
//			connection.setAutoCommit(false);
//			ecoleService.beginTransaction(connection);
//			retour = ecoleService.findByDTOPromotion(dtoSearched);
//			ecoleService.endTransaction();
//			connection.commit();
//
//		} catch (SQLException e) {
//
//			ImieException rollbackException = null;
//			// if (!slave) {
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				rollbackException = new ImieException(e1);
//			}
//			// }
//			throw new RuntimeException(
//					rollbackException != null ? rollbackException : e);
//
//		} finally {
//			closeJDBC(connection, null, null);
//			connection=null;
//		}
//		return retour;
//	}
//
//}
