## 🧠 Perguntas de Reflexão - Sprint 2 (Object-Oriented Programming)

### 1. Por que não faz sentido para a Motiva que uma equipe execute apenas uma "Intervenção Operacional" genérica sem especificar qual é?

> **Resposta:** Porque uma intervenção genérica não define custos, tempo ou ferramentas. Na vida real, a equipe precisa saber se deve levar um trator (Roçada Mecanizada) ou produtos químicos (Pulverização). A classe abstrata serve apenas para obrigar as classes filhas a terem um padrão de métodos, mas nunca para ser instanciada/executada sozinha.

---

### 2. Qual a diferença arquitetural entre fazer um Trecho herdar de uma classe abstrata vs. implementar uma Interface?

> **Resposta:** A herança (`extends`) define **"O QUE O OBJETO É"** dentro de uma família (ex: *TrechoUmido* **É UM** *TrechoRodovia*), e no Java só podemos herdar de uma única classe. 
> 
> Já a Interface (`implements`) define **"O QUE O OBJETO FAZ"**, atuando como um contrato de comportamento. Uma classe pode implementar várias interfaces, permitindo que objetos de famílias totalmente diferentes (como um *Trecho* e um *Caminhao*) compartilhem a mesma habilidade, como a de `transmitirDadosSensor`.