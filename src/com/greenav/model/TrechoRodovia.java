package com.greenav.model;

public class TrechoRodovia {
    
    private int quilometroInicial;
    private int quilometroFinal;
    private double nivelVegetacao; 

    public TrechoRodovia(int quilometroInicial, int quilometroFinal, double nivelVegetacao) {
        this.quilometroInicial = quilometroInicial;
        this.quilometroFinal = quilometroFinal;
        setNivelVegetacao(nivelVegetacao); 
    }

    public void registrarCrescimento(double taxa) {
        if (taxa > 0) {
            this.nivelVegetacao += taxa;
        }
    }

    public void setNivelVegetacao(double nivelVegetacao) {
        if (nivelVegetacao >= 0) {
            this.nivelVegetacao = nivelVegetacao;
        } else {
            System.out.println("Erro: O nível da vegetação não pode ser negativo.");
        }
    }

    public double getNivelVegetacao() { 
        return nivelVegetacao; 
    }
    
    public int getQuilometroInicial() { 
        return quilometroInicial; 
    }
    
    public int getQuilometroFinal() { 
        return quilometroFinal; 
    }
}