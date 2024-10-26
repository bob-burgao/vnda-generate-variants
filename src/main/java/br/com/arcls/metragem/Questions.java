package br.com.arcls.metragem;

import java.util.Scanner;


public class Questions {

    private final Scanner scanner;

    public Questions(Scanner sc) {
        this.scanner = sc;
    }

    public QuestionsData execQuestions() {
        final QuestionsData questionsData = new QuestionsData();
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

        System.out.println();

        this.descricao(questionsData);

        System.out.println();

        this.custoProducao(questionsData);

        System.out.println();

        this.taxas(questionsData);

        System.out.println();

        this.tamanhos(questionsData);

        return questionsData;
    }

    private void custoProducao(final QuestionsData questionsData) {
        System.out.println("************************ Custo de Produção *************************");

        System.out.print("Matérica Prima: ");
        questionsData.setMateriaPrima(scanner.nextBigDecimal());

        System.out.print("Guia Lateral: ");
        questionsData.setGuiaLateral(scanner.nextBigDecimal());

        System.out.print("Guia Base: ");
        questionsData.setGuiaBase(scanner.nextBigDecimal());

        System.out.print("Bandô: ");
        questionsData.setBando(scanner.nextBigDecimal());

        System.out.print("Outros: ");
        questionsData.setOutros(scanner.nextBigDecimal());

        System.out.print("Custo Fixo: ");
        questionsData.setCustosFixo(scanner.nextBigDecimal());

        System.out.println("********************************************************************");
    }

    private void taxas(final QuestionsData questionsData) {
        System.out.println("***************************** Taxas % ******************************");

        System.out.print("Margem de Contribuição: ");
        questionsData.setMargemContribuicao(scanner.nextBigDecimal());

        System.out.print("Taxa do Site: ");
        questionsData.setTaxaSite(scanner.nextBigDecimal());

        System.out.print("Simples: ");
        questionsData.setSimples(scanner.nextBigDecimal());

        System.out.println("********************************************************************");
    }

    private void descricao(final QuestionsData questionsData) {
        System.out.println("*********************** Descrição do Produto ***********************");

        System.out.print("Nome do Produto: ");
        questionsData.setNome(scanner.nextLine());

        System.out.print("Cor Nome: ");
        questionsData.setCorNome(scanner.nextLine());

        System.out.print("Cor Hexagonal: ");
        questionsData.setCorHexa(scanner.nextLine());

        System.out.print("SKU Pré-fixo: ");
        questionsData.setSkuPrefixo(scanner.nextLine());

        System.out.print("Quantidade de itens no estoque: ");
        questionsData.setQuantidade(scanner.nextInt());

        System.out.println("********************************************************************");
    }

    private void tamanhos(final QuestionsData questionsData) {
        System.out.println("*********************** Tamanos em CM ***********************");

        System.out.print("Largura Mínima: ");
        questionsData.setLarguraMin(scanner.nextInt());

        System.out.print("Largura Máxima: ");
        questionsData.setLarguraMax(scanner.nextInt());

        System.out.print("Altura Mínima: ");
        questionsData.setAlturaMin(scanner.nextInt());

        System.out.print("Altura Máxima: ");
        questionsData.setAlturaMax(scanner.nextInt());

        System.out.print("Intervalo: ");
        questionsData.setIntervalo(scanner.nextInt());

        System.out.println("********************************************************************");
    }
}
