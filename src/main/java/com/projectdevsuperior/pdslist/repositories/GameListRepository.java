package com.projectdevsuperior.pdslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectdevsuperior.pdslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
