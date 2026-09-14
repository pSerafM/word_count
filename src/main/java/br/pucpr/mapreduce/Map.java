package br.pucpr.mapreduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Map {

    public List<java.util.Map.Entry<String, Integer>> map(String texto) {

        List<java.util.Map.Entry<String, Integer>> resultado = new ArrayList<>();

        if (texto == null || texto.isBlank()) {
            return resultado;
        }

        String[] palavras = texto
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^\\p{L}]+", " ")
                .trim()
                .split("\\s+");

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                resultado.add(java.util.Map.entry(palavra, 1));
            }
        }

        return resultado;
    }
}