package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = false)
    public CityDTO insertCity(CityDTO dto){
        City cityReceive = new City();
        cityReceive.setName(dto.getName());
        cityReceive = repository.save(cityReceive);
        return new CityDTO(cityReceive);
    }

    @Transactional(readOnly = true)
    public List<CityDTO> findAll(){
        List<City> city = repository.findAll(Sort.by("name"));
        return city.stream().map(x -> new CityDTO(x)).toList();
    }
}
