package com.devsuperior.bds04.repositories;

import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
