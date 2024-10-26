package br.com.arcls;

import br.com.arcls.area.MainCalculoArea;
import br.com.arcls.bando.MainCalculoBando;
import br.com.arcls.guialateral.MainCalculoGuiaLateral;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        printHeader();
        escolhaAcao();
    }

    public static void escolhaAcao() {
        final String opcaoProduto = "0";
        final String opcaoBando = "1";
        final String opcaoGuiaLateral = "2";

        System.out.println("Selecione uma dessas opções: ");
        System.out.println(opcaoProduto + " - Criar Persiana (Cortina, Persiana, Kitbox, ETC.)");
        System.out.println(opcaoBando + " - Criar Bandô");
        System.out.println(opcaoGuiaLateral + " - Criar Guia Lateral");

        final String escolhaAcao = scanner.nextLine();

        try {
            switch (escolhaAcao) {
                case opcaoProduto: {
                    MainCalculoArea.exec();
                    novaCriacao();
                    break;
                }
                case opcaoBando: {
                    MainCalculoBando.exec();
                    novaCriacao();
                    break;
                }
                case opcaoGuiaLateral: {
                    MainCalculoGuiaLateral.exec();
                    novaCriacao();
                    break;
                }
                default: {
                    System.out.println("********************************************************************");
                    System.out.println("*********************** ESCOLHA INVÁLIDA!!! ************************");
                    System.out.println("********************************************************************");
                    escolhaAcao();
                }
            }
        } catch (IOException exception) {
            System.out.println("Erro inesperado ao executar essa ação");
        }
    }

    private static void novaCriacao() {
        System.out.println("Criar novo Produto? S - SIM / N - NÃO: ");
        final String escolhaAcao = scanner.nextLine();

        switch (escolhaAcao.toUpperCase()) {
            case "S": {
                escolhaAcao();
                break;
            }
            default: {
                break;
            }
        }
    }

    private static void printHeader() {
        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
        System.out.println("******      ***         *  ********  ***********  *****    *********");
        System.out.println("******  ***  **  ********  ********  *  *****  *  ***  ****  *******");
        System.out.println("******  ****  *  ********  ********  ***  *  ***  **  ******  ******");
        System.out.println("******  ***  **  ********  ********  ****   ****  *  ********  *****");
        System.out.println("******        *         *  ********  ***********  *  ********  *****");
        System.out.println("******  ***  **  ********  ********  ***********  *            *****");
        System.out.println("******  ****  *  ********  ********  ***********  *  ********  *****");
        System.out.println("******  ***  **  ********  ********  ***********  *  ********  *****");
        System.out.println("******      ***         *         *  ***********  *  ********  *****");
        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
        System.out.println("* Exemplos:                                                        *");
        System.out.println("*  1 - Informar valor fracionado utilizando virgula: 10,99         *");
        System.out.println("*  2 - Informar 0(zero) quando o produto não utilizar esse campo   *");
        System.out.println("*  3 - Tamanhos: 1,1 metro = 110cm -> Informar valor: 110          *");
        System.out.println("*  4 - Intervalo: Usado para montar todas a variantes do produto   *");
        System.out.println("*      Exemplo: 5 -> L60 x A60 - L60 x A65 - L65 x A60 - L65 x A65 *");
        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
    }

}
