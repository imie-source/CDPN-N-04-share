package org.imie.DAO;

import java.sql.Connection;
import java.util.List;

import org.imie.DTO.PersonneDTO;
import org.imie.Transaction.ITransactional;
import org.imie.exception.ImieException;

public interface IPersonneDAO extends IDAO<PersonneDTO>,ITransactional {




}