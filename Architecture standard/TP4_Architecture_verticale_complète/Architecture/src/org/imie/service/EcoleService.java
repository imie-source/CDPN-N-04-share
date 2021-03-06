/**
 * 
 */
package org.imie.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.imie.DAO.IPersonneDAO;
import org.imie.DAO.IPromotionDAO;
import org.imie.DAO.PersonneDAO;
import org.imie.DAO.PromotionDAO;
import org.imie.DTO.PersonneDTO;
import org.imie.DTO.PromotionDTO;
import org.imie.Transaction.AJDBC;
import org.imie.exception.ImieException;
import org.imie.factory.AbstractFactory;

/**
 * @author imie
 *
 */
public class EcoleService extends AJDBC implements IEcoleService {

	private IPersonneDAO personneDAO;
	private IPromotionDAO promotionDAO;
	
	AbstractFactory factory;

	public EcoleService() {
		super();
	}

	
	public EcoleService(AbstractFactory factory) {
		super();
		this.factory= factory;
		personneDAO=factory.createPersonneDAO();
		promotionDAO = factory.createPromotionDAO();
	}

	/* (non-Javadoc)
	 * @see org.imie.service.IEcoleService#insertPersonne(org.imie.DTO.PersonneDTO)
	 */
	@Override
	public PersonneDTO insertPersonne(PersonneDTO dtoToInsert)
			throws ImieException {
		return personneDAO.insert(dtoToInsert);
	}

	/* (non-Javadoc)
	 * @see org.imie.service.IEcoleService#updatePersonne(org.imie.DTO.PersonneDTO)
	 */
	@Override
	public PersonneDTO updatePersonne(PersonneDTO dtoToUpdate) throws ImieException{
		return personneDAO.update(dtoToUpdate);
	}

	/* (non-Javadoc)
	 * @see org.imie.service.IEcoleService#deletePersonne(org.imie.DTO.PersonneDTO)
	 */
	@Override
	public Integer deletePersonne(PersonneDTO dtoToDelete) throws ImieException {
		return personneDAO.delete(dtoToDelete);
	}

	/* (non-Javadoc)
	 * @see org.imie.service.IEcoleService#findAllPersonne()
	 */
	@Override
	public List<PersonneDTO> findAllPersonne() {
		return personneDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see org.imie.service.IEcoleService#findByDTOPersonne(org.imie.DTO.PersonneDTO)
	 */
	@Override
	public List<PersonneDTO> findByDTOPersonne(PersonneDTO dtoSearched) {
		return personneDAO.findByDTO(dtoSearched);
	}

	/* (non-Javadoc)
	 * @see org.imie.service.IEcoleService#deletePromotion(org.imie.DTO.PromotionDTO)
	 */
	@Override
	public Integer deletePromotion(PromotionDTO dtoToDelete)
			throws ImieException {
//		Connection connection = null;
		Integer retour = null;
//		try {
//			connection = openConnection();
//			connection.setAutoCommit(false);
			
			PersonneDTO personneDTO = new PersonneDTO();
			personneDTO.setPromotionDTO(dtoToDelete);
			
			List<PersonneDTO> personnes = personneDAO.findByDTO(personneDTO);
			for (PersonneDTO personneToUpdate : personnes) {
				personneToUpdate.setPromotionDTO(null);
				personneDAO.beginTransaction(getConnection());
				personneDAO.update(personneToUpdate);
				personneDAO.endTransaction();
			}
			promotionDAO.beginTransaction(getConnection());
			promotionDAO.delete(dtoToDelete);
			promotionDAO.endTransaction();
			
//		} catch (SQLException e) {
////			try {
////				connection.rollback();
////			} catch (SQLException e1) {
////				throw new ImieException(e);
////			}
//			throw new ImieException(e);
//		}
		return retour;
	}

	@Override
	public List<PromotionDTO> findByDTOPromotion(PromotionDTO dtoSearched) {
		return promotionDAO.findByDTO(dtoSearched);
	}
	
	

}
