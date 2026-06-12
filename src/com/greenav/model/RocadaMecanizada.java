package com.greenav.model;

public class RocadaMecanizada extends IntervencaoOperacional {
    
    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("[SERVIÇO] Trator roçadeira enviado para o KM " + trecho.getQuilometroInicial());
        trecho.setNivelVegetacao(2.0); // Corta a grama deixando bem baixa
    }
}