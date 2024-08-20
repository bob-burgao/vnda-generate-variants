package br.com.arcls;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TesteMain {
    public static void main(String[] args) {
        float taxaSimples = BigDecimal.valueOf(4).setScale(2, RoundingMode.CEILING).floatValue();
        float taxaSite = BigDecimal.valueOf(11).setScale(2, RoundingMode.CEILING).floatValue();
        float taxaMargemContribuicao = BigDecimal.valueOf(24).setScale(2, RoundingMode.CEILING).floatValue();

        float taxaFinal = (1 - (taxaSimples/100) - (taxaSite/100) - (taxaMargemContribuicao/100));

        System.out.println(taxaFinal);
    }
}
