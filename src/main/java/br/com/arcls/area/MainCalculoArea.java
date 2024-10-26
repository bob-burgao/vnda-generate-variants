package br.com.arcls.area;

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

public class MainCalculoArea {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        exec();
    }

    public static void exec() throws IOException {
        final Questions questions = new Questions(scanner);
        final QuestionsData questionsData = questions.execQuestions();

        printFile(questionsData);
    }

    public static BigDecimal custoTotal(QuestionsData questionsData, Integer largura, Integer altura) {
        BigDecimal larguraBD = BigDecimal.valueOf(largura).divide(BigDecimal.valueOf(100), 3, RoundingMode.CEILING);
        BigDecimal alturaBD = BigDecimal.valueOf(altura).divide(BigDecimal.valueOf(100), 3, RoundingMode.CEILING);
        BigDecimal metroQuadrado = larguraBD.multiply(alturaBD);
        BigDecimal custoTotal = BigDecimal.ZERO;

        BigDecimal bando = BigDecimal.ZERO;
        BigDecimal guiaBase = BigDecimal.ZERO;
        BigDecimal guiaLateral = BigDecimal.ZERO;
        BigDecimal metroQuadradoMinimo = BigDecimal.valueOf(1.5);

        if(metroQuadrado.compareTo(metroQuadradoMinimo) < 0) {
            metroQuadrado = metroQuadradoMinimo;
        }

        // VALOR * Metro Quadrado
        BigDecimal materiaPrima =  custoTotal.add(questionsData.getMateriaPrima().multiply(metroQuadrado));

        // Valor * Largura
        if (questionsData.getBando().compareTo(BigDecimal.ZERO) > 0) {
            bando = custoTotal.add(questionsData.getBando().multiply(larguraBD));
        }

        // Valor * Altura
        if (questionsData.getGuiaBase().compareTo(BigDecimal.ZERO) > 0) {
            guiaBase = custoTotal.add(questionsData.getGuiaBase().multiply(alturaBD));
        }

        // Valor * Altura
        if (questionsData.getGuiaLateral().compareTo(BigDecimal.ZERO) > 0) {
            guiaLateral = custoTotal.add(questionsData.getGuiaLateral().multiply(alturaBD));
        }

        return custoTotal
                .add(materiaPrima)
                .add(bando)
                .add(guiaBase)
                .add(guiaLateral)
                .add(questionsData.getOutros())
                .add(questionsData.getCustosFixo());
    }

    public static void printFile(QuestionsData questionsData) throws IOException {
        String[] cabecalho = {
                "referência", "nome", "sku", "atributo 1", "atributo 2", "atributo 3",
                "quantidade", "preço", "variante", "peso", "largura", "comprimento",
                "altura", "tags", "código de barras"};

        final List<List<String[]>> paginas = getLinhas(questionsData);

        int sequence = 1;
        for (List<String[]> linhas : paginas) {
            String fileName = (questionsData.getNome() + "-" + questionsData.getSkuPrefixo() + "-" + questionsData.getCorNome()).replaceAll(" ", "_");
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
        int larguraBase = questionsData.getAreaMin();
        int altura = 100;

        final List<List<String[]>> paginas = new ArrayList<>();

        while (larguraBase <= questionsData.getAreaMax()) {
                linhas.add(new String[]{
                        questionsData.getSkuPrefixo(), //Referência
                        questionsData.getNome(), // Nome
                        questionsData.getSkuPrefixo() + larguraBase + altura, //SKU
                        larguraBase + "cm", //atributo 1 - Largura
                        altura + "cm", //atributo 2 - Altura
                        questionsData.getCorNome() + " | " + questionsData.getCorHexa(), //atributo 3 - Cor
                        String.valueOf(questionsData.getQuantidade()), //quantidade
                        getPreco(questionsData, larguraBase, 100), //preço
                        questionsData.getNome(), //variante
                        "1", //peso
                        String.valueOf(altura), //largura - 10 que será o tamanho maximo do pacote
                        String.valueOf(larguraBase), //comprimento - será a largura do produto
                        String.valueOf(altura), //altura - 10 que será o tamanho maximo do pacote
                        "personalizacao-cordinha, personalizacao_lado_corda, personalizacao-largura, personalizacao-altura, personalizacao", //tags
                        ""  //código de barras
                });

                if (linhas.size() == 800) {
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

    public static String getPreco(QuestionsData questionsData, int largura, int altura) {
        BigDecimal custoTotal = custoTotal(questionsData, largura, altura);

        float taxaSimples = questionsData.getTaxaSite().setScale(2, RoundingMode.CEILING).floatValue();
        float taxaSite = questionsData.getTaxaSite().setScale(2, RoundingMode.CEILING).floatValue();
        float taxaMargemContribuicao = questionsData.getMargemContribuicao().setScale(2, RoundingMode.CEILING).floatValue();

        float taxaFinal = (1 - (taxaSimples/100) - (taxaSite/100) - (taxaMargemContribuicao/100));

        return  String.valueOf(custoTotal.divide(BigDecimal.valueOf(taxaFinal),2, RoundingMode.UP));
    }

}