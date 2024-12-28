package br.com.arcls.guiainferior;

import java.util.Scanner;


public class Questions {

    private final Scanner scanner;

    public Questions(Scanner sc) {
        this.scanner = sc;
    }

    public QuestionsData execQuestions() {
        System.out.println("******************** NOVA GUIA INFERIOR / BASE CHATA **********************");
        final QuestionsData questionsData = new QuestionsData();

        System.out.println();

        this.descricao(questionsData);

        System.out.println();

        this.custoProducao(questionsData);

        System.out.println();

        this.tamanhos(questionsData);

        System.out.println();

        this.tamanhosPacote(questionsData);

        return questionsData;
    }

    private void custoProducao(final QuestionsData questionsData) {
        System.out.println("************************ Custo de Produção *************************");

        System.out.print("Matérica Prima: ");
        questionsData.setMateriaPrima(scanner.nextBigDecimal());

        System.out.println("********************************************************************");
    }

    private void descricao(final QuestionsData questionsData) {
        System.out.println("*********************** Descrição da Guia *************************");

        System.out.print("Nome do Produto: ");
        questionsData.setNome(scanner.nextLine());

        System.out.print("Cor Nome: ");
        questionsData.setCorNome(scanner.nextLine());

        System.out.print("Cor Hexagonal: ");
        questionsData.setCorHexa(scanner.nextLine());

        System.out.print("SKU Pré-fixo: ");
        questionsData.setSkuPrefixo(scanner.nextLine());

        questionsData.setQuantidade(9999999);

        System.out.println("********************************************************************");
    }

    private void tamanhos(final QuestionsData questionsData) {
        System.out.println("*********************** Tamanhos em CM ***********************");

        System.out.print("Largura Mínima: ");
        questionsData.setLarguraMin(scanner.nextInt());

        System.out.print("Largura Máxima: ");
        questionsData.setLarguraMax(scanner.nextInt());

        System.out.print("Altura Fixa: ");
        questionsData.setAlturaFixa(scanner.nextInt());

        System.out.print("Intervalo: ");
        questionsData.setIntervalo(scanner.nextInt());

        System.out.println("********************************************************************");
    }

    private void tamanhosPacote(final QuestionsData questionsData) {
        System.out.println("********************* Tamanhos do Pacote em CM *********************");

        System.out.print("Altura do Pacote: ");
        questionsData.setAlturaPacote(scanner.nextInt());

        System.out.print("Largura do Pacote: ");
        questionsData.setLarguraPacote(scanner.nextInt());

        System.out.println("********************************************************************");
    }
}
