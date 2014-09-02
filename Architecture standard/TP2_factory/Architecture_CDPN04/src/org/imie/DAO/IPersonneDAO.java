package org.imie.DAO;

import java.sql.Connection;
import java.util.List;

import org.imie.DTO.PersonneDTO;
import org.imie.exception.ImieException;

public interface IPersonneDAO extends IDAO<PersonneDTO> {

	PersonneDTO update(PersonneDTO personneToUpdate, Connection connection) throws ImieException;

	/**
	 * @param dtoSearched
	 * @param connection
	 * @return
	 */
	public abstract List<PersonneDTO> findByDTO(PersonneDTO dtoSearched, Connection connection);


}