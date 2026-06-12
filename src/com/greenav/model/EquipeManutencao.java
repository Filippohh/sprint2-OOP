package com.greenav.model;

public class EquipeManutencao {
    private String nomeEquipe;

    public EquipeManutencao(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public void alocarParaTrecho(TrechoRodovia trecho) {
        System.out.println("A equipe '" + nomeEquipe + "' foi alocada para o trecho do KM " 
            + trecho.getQuilometroInicial() + " ao " + trecho.getQuilometroFinal() + ".");
    }
}