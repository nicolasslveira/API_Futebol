package com.projetoav2.api_futebol.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoav2.api_futebol.modelo.Time;
import com.projetoav2.api_futebol.repositorio.TimeRepositorio;




@RestController
@RequestMapping("/time")
public class TimeController {

@Autowired
private TimeRepositorio timeRepositorio;


    @GetMapping
    public List<Time> listar() {
        return timeRepositorio.findAll();
    }

    @PostMapping
        public void incluir(@RequestBody Time time){
     timeRepositorio.save(time);
    }

    @PutMapping
    public void alterar(@RequestBody Time time){
        timeRepositorio.save(time);
    }
    
@DeleteMapping("/{idTime}")
    public void deletar(@PathVariable Long idTime){
        timeRepositorio.deleteById(idTime);
    }

    @GetMapping("/{idTime}")
    public Optional<Time> buscaTime(@PathVariable Long idTime){
        return timeRepositorio.findById(idTime);
    }
    
}
