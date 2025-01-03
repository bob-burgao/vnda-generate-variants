package br.com.arcls.bando;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class QuestionsData {
    // Produção
    private BigDecimal materiaPrima;


    //Tamanho em CM
    private Integer larguraMin;
    private Integer larguraMax;
    private Integer alturaFixa;
    private Integer intervalo;


    //Descrição do produto
    private String nome;
    private String corNome;
    private String corHexa;
    private String skuPrefixo;
    private Integer quantidade;




    //Tamanho do Pacote em CM
    private Integer alturaPacote;
    private Integer larguraPacote;

}
