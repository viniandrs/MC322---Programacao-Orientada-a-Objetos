/*
 * Local.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab03;

/**
 * Contém a estrutura de implementação de um Local.
 * 
 * @author Gabriel Leite - 216180
 */
public class Local{
    private String nome;
    private int capacidadeMaxima;

    /**
     * Construtor da classe Local
     * @param nome o nome do local
     */
    public Local(String nome, int capacidadeMaxima){
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * Retorna o nome do evento
     * @return o nome do evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Retorna a capacidade do local
     * @return a capacidade do local
     */
    public int getCapacidade(){
        return this.capacidadeMaxima;
    }
    
    /**
     * Altera a capacidade máxima do local para `capacidadeMaxima` 
     * @param capacidadeMaxima a nova capacidade máxima do local
     */
    public void setCapacidade(int capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
    }
}
