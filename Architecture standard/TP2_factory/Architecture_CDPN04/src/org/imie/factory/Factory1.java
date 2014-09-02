/**
 * 
 */
package org.imie.factory;

import org.imie.DAO.IPersonneDAO;
import org.imie.DAO.IPromotionDAO;
import org.imie.DAO.PersonneDAO;
import org.imie.DAO.PromotionDAO;
import org.imie.DTO.PersonneDTO;
import org.imie.service.EcoleService;
import org.imie.service.IEcoleService;

/**
 * @author imie
 *
 */
public class Factory1 implements AbstractFactory {

	EcoleService ecoleService;
	PersonneDAO personneDAO;
	PromotionDAO promotionDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.AbstractFactory#createEcoleService()
	 */
	@Override
	public synchronized IEcoleService createEcoleService() {
		if (ecoleService == null) {
			ecoleService = new EcoleService(this);
		}
		return ecoleService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.AbstractFactory#createPersonneDAO()
	 */
	@Override
	public synchronized IPersonneDAO createPersonneDAO() {
		if (personneDAO == null) {
			personneDAO = new PersonneDAO(this);
		}
		return personneDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.AbstractFactory#createPromotionDAO()
	 */
	@Override
	public synchronized IPromotionDAO createPromotionDAO() {
		if (promotionDAO == null) {
			promotionDAO = new PromotionDAO(this);
		}
		return promotionDAO;
	}

}
