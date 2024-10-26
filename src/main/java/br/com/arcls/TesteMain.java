package br.com.arcls;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class TesteMain {
    public static void main(String[] args) {
        ArrayList<Integer> itens = new ArrayList<>();
        for (int i = 60; i < 500; i++) {
            itens.add(i);
        }
        System.out.println(itens.toString());
    }
}
