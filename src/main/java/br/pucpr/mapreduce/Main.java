package br.pucpr.mapreduce;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Path arquivo = Path.of("bible.txt");

        try {
            String texto = Files.readString(arquivo, StandardCharsets.UTF_8);

            // MAP: palavra -> 1
            Map map = new Map();
            List<java.util.Map.Entry<String, Integer>> paresMap =
                    map.map(texto);

            // REDUCE: agrupa palavras e soma os valores
            Reduce reduce = new Reduce();
            java.util.Map<String, Integer> contagem =
                    reduce.reduce(paresMap);

            System.out.println();
            System.out.println("── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──");
            System.out.println("      MAPREDUCE - CONTAGEM DE PALAVRAS");
            System.out.println("── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──");
            System.out.println();
            System.out.println("Arquivo: " + arquivo.toAbsolutePath());
            System.out.println("Total de palavras: " + paresMap.size());
            System.out.println("Palavras diferentes: " + contagem.size());
            System.out.println();
            System.out.println("10 palavras mais frequentes:");
            System.out.println("── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──── ⋆⋅𖤓⋅⋆ ──");

            contagem.entrySet().stream()
                    .sorted(java.util.Map.Entry
                            .<String, Integer>comparingByValue()
                            .reversed()
                            .thenComparing(java.util.Map.Entry.comparingByKey()))
                    .limit(10)
                    .forEach(entry ->
                            System.out.printf("%-20s %d%n",
                                    entry.getKey(), entry.getValue()));

            Path saida = Path.of("resultado.txt");

            List<String> linhas = contagem.entrySet().stream()
                    .sorted(Comparator.comparing(java.util.Map.Entry::getKey))
                    .map(entry -> entry.getKey() + " " + entry.getValue())
                    .toList();

            Files.write(saida, linhas, StandardCharsets.UTF_8);

            System.out.println();
            System.out.println("Resultado completo salvo em: "
                    + saida.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro ao ler/escrever arquivo: " + e.getMessage());
            System.err.println("Verifique se o arquivo bible.txt está na raiz do projeto.");
        }
    }
}
