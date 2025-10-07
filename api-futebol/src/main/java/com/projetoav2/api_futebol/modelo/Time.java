package com.projetoav2.api_futebol.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
public class Time {

    @Id
    private Long idTime;

    private String nome;
    private String cidade;
    private String estado;
    private String pais;
    private Integer anoFundacao;
    private String estadio;
    private String patrocinador;
    private Integer capacidadeEstadio;
    private String treinador;

    @OneToMany(mappedBy = "time")
    @JsonIgnore // Evita loop infinito na serialização
    private List<Jogador> jogadores;
}
