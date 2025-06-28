package com.devsuperior.bds04.repositories;

import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
