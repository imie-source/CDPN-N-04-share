/**
 * 
 */
package org.imie.factory;

import java.lang.reflect.Proxy;

import org.imie.DAO.IPersonneDAO;
import org.imie.DAO.IPromotionDAO;
import org.imie.DAO.PersonneDAO;
import org.imie.DAO.PromotionDAO;
import org.imie.Transaction.TransactionalHandler;
import org.imie.service.EcoleService;
import org.imie.service.IEcoleService;

/**
 * @author imie
 *
 */
public class Factory1 implements AbstractFactory {

	IEcoleService ecoleService;
	IPersonneDAO personneDAO;
	IPromotionDAO promotionDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.AbstractFactory#createEcoleService()
	 */
	@Override
	public synchronized IEcoleService createEcoleService() {
		 if (ecoleService == null) {
		 IEcoleService service = new EcoleService(this);
		 TransactionalHandler invocationHandlerTransaction = new
		 TransactionalHandler(
		 service);
		 ecoleService = (IEcoleService) Proxy
		 .newProxyInstance(service.getClass().getClassLoader(),
		 service.getClass().getInterfaces(),
		 invocationHandlerTransaction);
		 }
		 return ecoleService;

//		IEcoleService service = new EcoleService(this);
//		TransactionalHandler invocationHandlerTransaction = new TransactionalHandler(
//				service);
//		return (IEcoleService) Proxy.newProxyInstance(service.getClass()
//				.getClassLoader(), service.getClass().getInterfaces(),
//				invocationHandlerTransaction);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.AbstractFactory#createPersonneDAO()
	 */
	@Override
	public synchronized IPersonneDAO createPersonneDAO() {
		 if (personneDAO == null) {
		 //personneDAO = new PersonneDAOProxy(new PersonneDAO(this));
		
		 IPersonneDAO dao = new PersonneDAO(this);
		 TransactionalHandler invocationHandlerTransaction = new
		 TransactionalHandler(
		 dao);
		 personneDAO = (IPersonneDAO) Proxy
		 .newProxyInstance(dao.getClass().getClassLoader(),
		 dao.getClass().getInterfaces(),
		 invocationHandlerTransaction);
		 }
		 return personneDAO;
//		IPersonneDAO dao = new PersonneDAO(this);
//		TransactionalHandler invocationHandlerTransaction = new TransactionalHandler(
//				dao);
//		return (IPersonneDAO) Proxy.newProxyInstance(dao.getClass()
//				.getClassLoader(), dao.getClass().getInterfaces(),
//				invocationHandlerTransaction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.factory.AbstractFactory#createPromotionDAO()
	 */
	@Override
	public synchronized IPromotionDAO createPromotionDAO() {
		 if (promotionDAO == null) {
		
		 IPromotionDAO dao = new PromotionDAO(this);
		 TransactionalHandler invocationHandlerTransaction = new
		 TransactionalHandler(
		 dao);
		 promotionDAO = (IPromotionDAO) Proxy
		 .newProxyInstance(dao.getClass().getClassLoader(),
		 dao.getClass().getInterfaces(),
		 invocationHandlerTransaction);
		 }
		 return promotionDAO;
//		IPromotionDAO dao = new PromotionDAO(this);
//		TransactionalHandler invocationHandlerTransaction = new TransactionalHandler(
//				dao);
//		return (IPromotionDAO) Proxy.newProxyInstance(dao.getClass()
//				.getClassLoader(), dao.getClass().getInterfaces(),
//				invocationHandlerTransaction);
	}

}
