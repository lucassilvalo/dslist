package com.projectdevsuperior.pdslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdevsuperior.pdslist.dto.GameMinDTO;
import com.projectdevsuperior.pdslist.services.GameService;


@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired 	
	private GameService gameService; 
		
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result =  gameService.findAll();
		return result;
	}

}
