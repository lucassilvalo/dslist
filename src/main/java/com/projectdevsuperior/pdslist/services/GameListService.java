package com.projectdevsuperior.pdslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectdevsuperior.pdslist.dto.GameListDTO;
import com.projectdevsuperior.pdslist.entities.GameList;
import com.projectdevsuperior.pdslist.projections.GameMinProjection;
import com.projectdevsuperior.pdslist.repositories.GameListRepository;
import com.projectdevsuperior.pdslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
		
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll()	{
		List<GameList> result = gameListRepository.findAll(); 
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);		}
		
	}		
	
}
