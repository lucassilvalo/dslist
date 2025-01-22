package com.projectdevsuperior.pdslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectdevsuperior.pdslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
