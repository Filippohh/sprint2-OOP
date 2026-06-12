package com.greenav.model;

// Herda de TrechoRodovia e assina o contrato da interface IoT
public class TrechoUmido extends TrechoRodovia implements MonitoravelViaIoT {

    public TrechoUmido(int quilometroInicial, int quilometroFinal, double nivelVegetacao) {
        super(quilometroInicial, quilometroFinal, nivelVegetacao); // Chama o construtor da classe pai
    }

    // Polimorfismo: Sobrescrevemos a regra de crescimento (cresce o dobro)
    @Override
    public void registrarCrescimento(double taxa) {
        super.registrarCrescimento(taxa * 2.0); 
    }

    // Implementação obrigatória da interface
    @Override
    public double transmitirDadosSensor() {
        System.out.println("📡 [IoT Sensor] Transmitindo dados do KM " + getQuilometroInicial() + "...");
        return getNivelVegetacao();
    }
}