/**
 * 
 */
package org.imie.DAO;

import java.util.List;

import org.imie.DTO.PersonneDTO;
import org.imie.exception.ImieException;

/**
 * @author imie
 *
 */
public interface IDAO<T> {

	/**
	 * insérer un DTO
	 * 
	 * @param dtoToInsert
	 * @return
	 * @throws ImieException
	 */
	public abstract T insert(T dtoToInsert) throws ImieException;

	/**
	 * mettre à jour un DTO
	 * 
	 * @param dtoToUpdate
	 * @return
	 */
	public abstract T update(T dtoToUpdate);

	/***
	 * supprimer un DTO
	 * 
	 * @param dtoToDelete
	 * @return
	 */
	public abstract Integer delete(T dtoToDelete);

	/**
	 * rechercher tous les DTO
	 * 
	 * @return
	 */
	public abstract List<T> findAll();

	/**
	 * rechercher des DTO à partir d'un DTO exemple (les attributs null ne
	 * seront pas filtré)
	 * 
	 * @param dtoSearched
	 * @return
	 */
	public abstract List<T> findByDTO(T dtoSearched);

}
