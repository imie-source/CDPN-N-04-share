package org.imie.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import org.imie.exception.ImieException;

public class TransactionalHandler extends AJDBC implements InvocationHandler,
		ITransactional {

	private ITransactional transactional;

	public TransactionalHandler(ITransactional transactional) {
		super();
		this.transactional = transactional;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.printf("proxy : %s : %s\n", transactional.getClass(),
				method.getName());
		Object retour = null;
		if (method.getName().contains("Transaction")) {
			retour = method.invoke(this, args);
		} else {

			//Connection connectionLocale = null;
			Boolean slave = false;
			try {
				if (getConnection() != null) {
					slave = true;
					//connectionLocale = connection;
					System.out.printf("proxy transaction esclave: %s : %s\n", transactional.getClass(),
							method.getName());
				} else {
					setConnection(openConnection());;
					getConnection().setAutoCommit(false);
					//connectionLocale = openConnection();
					//connectionLocale.setAutoCommit(false);
				}

				transactional.beginTransaction(getConnection());

				retour = method.invoke(transactional, args);

				

				if (!slave) {
					getConnection().commit();
				}

			} catch (Exception e) {

				ImieException rollbackException = null;
				if (!slave) {
					try {
						getConnection().rollback();
					} catch (SQLException e1) {
						rollbackException = new ImieException(e1);
					}
				}
				throw new ImieException(
						rollbackException != null ? rollbackException : e);
			} finally {
//				System.out.printf("proxy Finally: %s : %s\n", transactional.getClass(),
//						method.getName());
				transactional.endTransaction();
				if (!slave) {
					System.out.printf("proxy cloture connection: %s : %s\n", transactional.getClass(),
							method.getName());
					//closeJDBC(connectionLocale, null, null);
					closeJDBC(getConnection(), null, null);	
				}
				setConnection(null);
				
			}
		}
		if (getConnection() != null) {
			System.out.println("proxy : transaction resté ouverte");
		}
		return retour;

	}

}
