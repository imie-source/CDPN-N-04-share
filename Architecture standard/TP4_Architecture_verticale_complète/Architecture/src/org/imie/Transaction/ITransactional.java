package org.imie.Transaction;

import java.sql.Connection;

public interface ITransactional {
	void beginTransaction(Connection connection);

	void endTransaction();

}
