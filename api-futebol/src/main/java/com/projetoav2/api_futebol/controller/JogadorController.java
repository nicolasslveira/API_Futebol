package com.projetoav2.api_futebol.controller;

import com.projetoav2.api_futebol.modelo.Jogador;
import com.projetoav2.api_futebol.modelo.Time;
import com.projetoav2.api_futebol.repositorio.JogadorRepositorio;
import com.projetoav2.api_futebol.repositorio.TimeRepositorio;
import DTO.JogadorDTO; // Corrigido o import

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepositorio jogadorRepositorio;
    @Autowired
    private TimeRepositorio timeRepositorio;

    @GetMapping
    public List<JogadorDTO> listar() {
        List<Jogador> jogadores = jogadorRepositorio.findAll();
        return jogadores.stream()
            .map(JogadorDTO::fromJogador)
            .toList();
    }

    @GetMapping("/{idJogador}")
    public JogadorDTO buscaJogador(@PathVariable Long idJogador){
        Optional<Jogador> jogadorOpt = jogadorRepositorio.findById(idJogador);
        if (jogadorOpt.isPresent()) {
            return JogadorDTO.fromJogador(jogadorOpt.get());
        } else {
            throw new RuntimeException("Jogador não encontrado: " + idJogador);
        }
    }

    @PostMapping
    public void incluir(@RequestBody Jogador jogador){
        if (jogador.getTime() != null && jogador.getTime().getNome() != null) {
            Optional<Time> timeOpt = timeRepositorio.findByNome(jogador.getTime().getNome());
            if (timeOpt.isPresent()) {
                jogador.setTime(timeOpt.get());
                jogadorRepositorio.save(jogador);
            } else {
                throw new RuntimeException("Time não encontrado: " + jogador.getTime().getNome());
            }
        } else {
            throw new RuntimeException("Nome do time não informado.");
        }
    }

    @PutMapping
    public void alterar(@RequestBody Jogador jogador){
        if (jogador.getTime() != null && jogador.getTime().getNome() != null) {
            Optional<Time> timeOpt = timeRepositorio.findByNome(jogador.getTime().getNome());
            if (timeOpt.isPresent()) {
                jogador.setTime(timeOpt.get());
            } else {
                throw new RuntimeException("Time não encontrado: " + jogador.getTime().getNome());
            }
        }
        jogadorRepositorio.save(jogador);
    }

    @DeleteMapping("/{idJogador}")
    public void deletar(@PathVariable Long idJogador){
        jogadorRepositorio.deleteById(idJogador);
    }
}
