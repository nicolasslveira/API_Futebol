package com.projetoav2.api_futebol.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
public class Jogador {

    @Id
    private Long idJogador;

    private String nome;
    private String apelido;
    private String posicao;
    private Integer idade;
    private String nacionalidade;
    private Integer numeroCamisa;
    
    @ManyToOne
    @JoinColumn(name = "id_time")
    private Time time;
}
