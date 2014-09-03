package org.imie.service;

import java.util.List;

import org.imie.DTO.PersonneDTO;
import org.imie.DTO.PromotionDTO;
import org.imie.exception.ImieException;

public interface IEcoleService {
	

	public abstract PersonneDTO insertPersonne(PersonneDTO dtoToInsert) throws ImieException;
	public abstract PersonneDTO updatePersonne(PersonneDTO dtoToUpdate) throws ImieException;
	public abstract Integer deletePersonne(PersonneDTO dtoToDelete) throws ImieException;
	public abstract List<PersonneDTO> findAllPersonne();
	public abstract List<PersonneDTO> findByDTOPersonne(PersonneDTO dtoSearched);
	public abstract Integer deletePromotion(PromotionDTO dtoToDelete) throws ImieException;
	public abstract List<PromotionDTO> findByDTOPromotion(PromotionDTO dtoSearched);

}
