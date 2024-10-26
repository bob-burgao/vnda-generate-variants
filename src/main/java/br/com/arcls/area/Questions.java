package br.com.arcls.area;

import java.math.BigDecimal;
import java.util.Scanner;


public class Questions {

    private final Scanner scanner;

    public Questions(Scanner sc) {
        this.scanner = sc;
    }

    public QuestionsData execQuestions() {
        System.out.println("************************ NOVA PERSIANA ***************************");
        final QuestionsData questionsData = new QuestionsData();
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

//        System.out.print("Outros: ");
        questionsData.setOutros(BigDecimal.valueOf(15));

//        System.out.print("Custo Fixo: ");
        questionsData.setCustosFixo(BigDecimal.valueOf(75));

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
        System.out.println("*********************** Descrição da Persiana **********************");

        System.out.print("Nome do Produto: ");
        questionsData.setNome(scanner.nextLine());

        System.out.print("Cor Nome: ");
        questionsData.setCorNome(scanner.nextLine());

        System.out.print("Cor Hexagonal: ");
        questionsData.setCorHexa(scanner.nextLine());

        System.out.print("SKU Pré-fixo: ");
        questionsData.setSkuPrefixo(scanner.nextLine());

        System.out.print("Quantidade de itens no estoque: ");
        questionsData.setQuantidade(9999999);

        System.out.println("********************************************************************");
    }

    private void tamanhos(final QuestionsData questionsData) {
        System.out.println("*********************** Tamanos em CM ***********************");

        System.out.print("Área Mínima: ");
        questionsData.setAreaMin(scanner.nextInt());

        System.out.print("Área Máxima: ");
        questionsData.setAreaMax(scanner.nextInt());

        System.out.print("Intervalo: ");
        questionsData.setIntervalo(scanner.nextInt());

        System.out.println("********************************************************************");
    }
}
