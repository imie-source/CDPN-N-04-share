package org.imie.DAO;

import java.sql.Connection;

import org.imie.DTO.PromotionDTO;
import org.imie.Transaction.ITransactional;
import org.imie.exception.ImieException;

public interface IPromotionDAO extends IDAO<PromotionDTO>,ITransactional {


}
