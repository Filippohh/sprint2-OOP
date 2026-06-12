package com.greenav.model;

public class TrechoSeco extends TrechoRodovia {

    public TrechoSeco(int quilometroInicial, int quilometroFinal, double nivelVegetacao) {
        super(quilometroInicial, quilometroFinal, nivelVegetacao);
    }

    @Override
    public void registrarCrescimento(double taxa) {
        super.registrarCrescimento(taxa * 0.5); // Cresce metade da taxa normal
    }
}