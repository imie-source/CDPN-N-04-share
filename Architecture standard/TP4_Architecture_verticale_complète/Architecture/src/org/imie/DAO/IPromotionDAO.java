package org.imie.DAO;

import java.sql.Connection;

import org.imie.DTO.PromotionDTO;
import org.imie.exception.ImieException;

public interface IPromotionDAO extends IDAO<PromotionDTO> {

	Integer delete(PromotionDTO dtoToDelete, Connection connection) throws ImieException;

}
