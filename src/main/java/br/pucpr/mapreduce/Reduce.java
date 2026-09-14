package br.pucpr.mapreduce;

import java.util.HashMap;
import java.util.List;

public class Reduce {

    public java.util.Map<String, Integer> reduce(
            List<java.util.Map.Entry<String, Integer>> pares) {

        java.util.Map<String, Integer> resultado = new HashMap<>();

        for (java.util.Map.Entry<String, Integer> par : pares) {
            resultado.merge(par.getKey(), par.getValue(), Integer::sum);
        }

        return resultado;
    }
}

