package com.projetoav2.api_futebol.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoav2.api_futebol.modelo.Jogador;

public interface JogadorRepositorio extends JpaRepository<Jogador, Long>{
}
