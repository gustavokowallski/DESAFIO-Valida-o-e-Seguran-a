package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;
    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = false)
    public EventDTO insertCity(EventDTO dto){
        Event eventReceive = eventDtoToEntity(dto);
        eventReceive = repository.save(eventReceive);
        return new EventDTO(eventReceive);
    }

    @Transactional(readOnly = true)
    public Page<EventDTO> findAll(Pageable pageable){
        Page<Event> result = repository.findAll( pageable);
        return result.map(x -> new EventDTO(x));
    }

    private Event eventDtoToEntity(EventDTO dto){
        Event eventReceive = new Event();
        eventReceive.setName(dto.getName());
        eventReceive.setDate(dto.getDate());
        eventReceive.setUrl(dto.getUrl());

        City city = cityRepository.getReferenceById(dto.getCityId());
        eventReceive.setCity(city);
        return eventReceive;
    }

}
