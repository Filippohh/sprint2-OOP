package com.greenav.model;

public class Pulverizacao extends IntervencaoOperacional {
    
    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("[SERVIÇO] Pulverização química aplicada no KM " + trecho.getQuilometroInicial());
        trecho.setNivelVegetacao(trecho.getNivelVegetacao() / 2); // Reduz pela metade
    }
}