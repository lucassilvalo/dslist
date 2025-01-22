package com.projectdevsuperior.pdslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectdevsuperior.pdslist.dto.GameDTO;
import com.projectdevsuperior.pdslist.dto.GameMinDTO;
import com.projectdevsuperior.pdslist.entities.Game;
import com.projectdevsuperior.pdslist.projections.GameMinProjection;
import com.projectdevsuperior.pdslist.repositories.GameRepository;


@Service
public class GameService {

	@Autowired 
private GameRepository gameRepository;
	 
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get(); 
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll()	{
		List<Game> result = gameRepository.findAll(); 
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)   
	public List<GameMinDTO> findByList(Long listId)	{
		List<GameMinProjection> result = gameRepository.searchByList(listId); 
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	
}
