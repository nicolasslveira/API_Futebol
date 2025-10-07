package DTO;



import com.projetoav2.api_futebol.modelo.Jogador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorDTO {

    private Long idJogador;
    private String nome;
    private String apelido;
    private String posicao;
    private Integer idade;
    private String nacionalidade;
    private Integer numeroCamisa;
    private String clubeAtual; // Só o nome do time

    // Converte de Jogador para DTO
    public static JogadorDTO fromJogador(Jogador jogador) {
        JogadorDTO dto = new JogadorDTO();
        dto.setIdJogador(jogador.getIdJogador());
        dto.setNome(jogador.getNome());
        dto.setApelido(jogador.getApelido());
        dto.setPosicao(jogador.getPosicao());
        dto.setIdade(jogador.getIdade());
        dto.setNacionalidade(jogador.getNacionalidade());
        dto.setNumeroCamisa(jogador.getNumeroCamisa());
        if (jogador.getTime() != null) {
            dto.setClubeAtual(jogador.getTime().getNome());
        }
        return dto;
    }
}