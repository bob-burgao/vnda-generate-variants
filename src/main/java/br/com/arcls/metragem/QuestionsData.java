package br.com.arcls.metragem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class QuestionsData {
    // Produção
    private BigDecimal outros; //FIXO
    private BigDecimal custosFixo; //FIXO
    private BigDecimal materiaPrima;
    private BigDecimal bando;
    private BigDecimal guiaLateral;
    private BigDecimal guiaBase;

    // Taxas
    private BigDecimal margemContribuicao;//FIXO
    private BigDecimal taxaSite;//FIXO
    private BigDecimal simples;//FIXO

    //Tamanho em CM
    private Integer larguraMin;
    private Integer larguraMax;
    private Integer alturaMin;
    private Integer alturaMax;
    private Integer intervalo;


    //Descrição do produto
    private String nome;
    private String corNome;
    private String corHexa;
    private String skuPrefixo;
    private Integer quantidade;





}
