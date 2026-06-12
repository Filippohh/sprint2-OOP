package com.greenav.main;

import com.greenav.model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- MOTOR DE REGRAS GREENAV: SPRINT 2 ---\n");

        // 1. Criando o Array de Trechos com Polimorfismo
        TrechoRodovia[] rodovia = new TrechoRodovia[3];
        rodovia[0] = new TrechoUmido(10, 15, 25.0); // Crítico, com IoT
        rodovia[1] = new TrechoSeco(20, 25, 8.0);   // Normal
        rodovia[2] = new TrechoUmido(50, 55, 12.0); // Atenção, com IoT

        // Instanciando as intervenções
        IntervencaoOperacional rocada = new RocadaMecanizada();
        IntervencaoOperacional pulverizacao = new Pulverizacao();

        System.out.println("=== RELATÓRIO DE PRIORIDADE AUTOMÁTICO ===");
        
        // 2. Varrendo o array (Motor de Regras)
        for (TrechoRodovia trecho : rodovia) {
            System.out.println("\nAnalisando KM " + trecho.getQuilometroInicial() + " ao " + trecho.getQuilometroFinal() + "...");

            // 3. Teste Unitário Sugerido: Captura de dados via IoT (Interface)
            if (trecho instanceof MonitoravelViaIoT) {
                MonitoravelViaIoT trechoIoT = (MonitoravelViaIoT) trecho;
                double leitura = trechoIoT.transmitirDadosSensor();
                System.out.println("   Leitura atualizada via sensor: " + leitura + "cm");
            } else {
                System.out.println("   Leitura manual de inspeção visual: " + trecho.getNivelVegetacao() + "cm");
            }

            // 4. Lógica de Intervenção
            if (trecho.getNivelVegetacao() >= 20.0) {
                System.out.println("   -> PRIORIDADE ALTA: Necessário Roçada Mecanizada!");
                rocada.executarServico(trecho);
            } else if (trecho.getNivelVegetacao() >= 10.0) {
                System.out.println("   -> PRIORIDADE MÉDIA: Necessário Pulverização ou Roçada Manual.");
                pulverizacao.executarServico(trecho);
            } else {
                System.out.println("   -> STATUS VERDE: Nenhuma intervenção necessária.");
            }
        }

        // 5. Teste Unitário Sugerido (Comentado para não quebrar o código)
        // IntervencaoOperacional generica = new IntervencaoOperacional(); // ERRO: Não pode ser instanciada
    }
}

/* ================================================================================
RESPOSTAS DAS PERGUNTAS DE REFLEXÃO (Sprint 2):
================================================================================

1. Por que não faz sentido para a Motiva que uma equipe execute apenas uma 
   "Intervenção Operacional" genérica sem especificar qual é?
   R: Porque uma intervenção genérica não define custos, tempo ou ferramentas. Na 
   vida real, a equipe precisa saber se deve levar um trator (Roçada Mecanizada) ou 
   produtos químicos (Pulverização). A classe abstrata serve apenas para obrigar 
   as classes filhas a terem um padrão, mas nunca para ser executada sozinha.

2. Qual a diferença arquitetural entre fazer um Trecho herdar de uma classe 
   abstrata vs. implementar uma Interface?
   R: A herança (extends) define "O QUE O OBJETO É" dentro de uma família (TrechoUmido 
   É UM TrechoRodovia). Só podemos herdar de uma classe. A Interface (implements) 
   define "O QUE O OBJETO FAZ" (Contrato de comportamento). Uma classe pode implementar 
   várias interfaces, permitindo que objetos de famílias diferentes (como um Trecho 
   e um Caminhao) compartilhem a habilidade de "transmitirDadosSensor".
================================================================================
*/