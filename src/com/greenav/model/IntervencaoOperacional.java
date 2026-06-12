package com.greenav.model;

public abstract class IntervencaoOperacional {
    
    // Método abstrato: não tem corpo. As filhas são obrigadas a implementar.
    public abstract void executarServico(TrechoRodovia trecho);
}