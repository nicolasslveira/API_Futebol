package com.projetoav2.api_futebol.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoav2.api_futebol.modelo.Time;
import java.util.Optional;

public interface TimeRepositorio extends JpaRepository<Time, Long> {
    Optional<Time> findByNome(String nome);
}