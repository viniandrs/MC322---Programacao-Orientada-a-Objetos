/*
 * Local.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab01;

/**
 * Contém a estrutura de implementação de um Local.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class Local {
    private final String nome;
    private final double capacidade;

    /**
     * Construtor da classe Local
     * @param nome o nome do local
     */
    public Local(String nome, double capacidade){
        this.nome = nome;
        this.capacidade = capacidade;
    }

    /**
     * Retorna o nome do local
     * @return o nome do local
     */
    public String getNome(){
        return nome;
    }

    /**
     * Retorna a capacidade do local
     * @return a capacidade do local
     */
    public double getCapacidade(){
        return capacidade;
    }
}
