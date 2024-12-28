package br.com.arcls.guiainferior;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCalculoGuiaInferior {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        exec();
    }

    public static void exec() throws IOException {
        final Questions questions = new Questions(scanner);
        final QuestionsData questionsData = questions.execQuestions();

        printFile(questionsData);
    }

    public static BigDecimal custoTotal(QuestionsData questionsData, Integer largura) {
        BigDecimal larguraGuia = BigDecimal.valueOf(largura).divide(BigDecimal.valueOf(100), 3, RoundingMode.CEILING);
        BigDecimal custoTotal = BigDecimal.ZERO;

        BigDecimal larguraMinima = BigDecimal.valueOf(1);

        if(larguraGuia.compareTo(larguraMinima) < 0) {
            larguraGuia = larguraMinima;
        }

        BigDecimal materiaPrima =  custoTotal.add(questionsData.getMateriaPrima().multiply(larguraGuia));

        return custoTotal.add(materiaPrima);
    }

    public static void printFile(QuestionsData questionsData) throws IOException {
        String[] cabecalho = {
                "referência", "nome", "sku", "atributo 1", "atributo 2", "atributo 3",
                "quantidade", "preço", "variante", "peso", "largura", "comprimento",
                "altura", "tags", "código de barras"};

        final List<List<String[]>> paginas = getLinhas(questionsData);

        int sequence = 1;
        for (List<String[]> linhas : paginas) {
            String fileName = (questionsData.getNome() + "-" + questionsData.getCorNome()).replaceAll(" ", "_");
            Writer writer = Files.newBufferedWriter(Paths.get("arquivos/" + fileName + "-" + sequence + ".csv"));
            CSVWriter csvWriter = new CSVWriter(writer);

            csvWriter.writeNext(cabecalho);
            csvWriter.writeAll(linhas);

            csvWriter.flush();
            writer.close();
            sequence++;
        }

    }

    public static List<List<String[]>> getLinhas(QuestionsData questionsData) {
        final List<String[]> linhas = new ArrayList<>();
        int larguraBase = questionsData.getLarguraMin();

        final List<List<String[]>> paginas = new ArrayList<>();

        while (larguraBase <= questionsData.getLarguraMax()) {
                        linhas.add(new String[]{
                    questionsData.getSkuPrefixo(), //Referência
                    questionsData.getNome() + " - " + questionsData.getCorNome(), // Nome
                    questionsData.getSkuPrefixo() + larguraBase, //SKU
                    larguraBase + "cm", //atributo 1 - Largura
                    questionsData.getAlturaFixa() + "cm", //atributo 2 - Altura
                    questionsData.getCorNome() + " | " + questionsData.getCorHexa(), //atributo 3 - Cor
                    String.valueOf(questionsData.getQuantidade()), //quantidade
                    getPreco(questionsData, larguraBase), //preço
                    "Cor: " + questionsData.getCorNome() + " - Largura: " + larguraBase + "cm - Altura: " + questionsData.getAlturaFixa() + "cm", //variante
                    "1", //peso
                    String.valueOf(questionsData.getLarguraPacote()), //largura - 10 que será o tamanho maximo do pacote
                    String.valueOf(larguraBase), //comprimento - será a largura do produto
                    String.valueOf(questionsData.getAlturaPacote()), //altura - 10 que será o tamanho maximo do pacote
                    " personalizacao-largura, personalizacao-altura, personalizacao, range-altura-guia-lateral, range-largura-guia-lateral", //tags
                    ""  //código de barras
            });

            if (linhas.size() == 1000) {
                ArrayList<String[]> pagina = new ArrayList<>(linhas);
                paginas.add(pagina);
                linhas.clear();
            }
            larguraBase = larguraBase + questionsData.getIntervalo();
        }

        if (!linhas.isEmpty()) {
            ArrayList<String[]> pagina = new ArrayList<>(linhas);
            paginas.add(pagina);
            linhas.clear();
        }

        return paginas;
    }

    public static String getPreco(QuestionsData questionsData, int largura) {
        BigDecimal custoTotal = custoTotal(questionsData, largura);

        return  String.valueOf(custoTotal.divide(BigDecimal.ONE,2, RoundingMode.UP));
    }

}