package com.devsuperior.bds04.controller;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){
        List<CityDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);

    }
    @PostMapping
    public ResponseEntity<CityDTO> insert (@RequestBody CityDTO dto){
        CityDTO result = service.insertCity(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(result);
    }

}
