package org.imie.factory;

import org.imie.DAO.IPersonneDAO;
import org.imie.DAO.IPromotionDAO;
import org.imie.service.IEcoleService;

public interface AbstractFactory {
	/**
	 * @return
	 */
	public IEcoleService createEcoleService();

	/**
	 * @return
	 */
	public IPersonneDAO createPersonneDAO();

	/**
	 * @return
	 */
	public IPromotionDAO createPromotionDAO();

}
