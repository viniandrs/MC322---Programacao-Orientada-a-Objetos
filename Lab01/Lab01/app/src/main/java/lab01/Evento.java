/*
 * Evento.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um Evento.
 * 
 * @author Gabriel Leite - 216180
 * @author Caio Rhoden - 214129
 * @author Vinicius Andreossi - 195125s
 */
public abstract class Evento {
    private String nome;
    private Local local;
    private float precoIngresso;
    private String categoria;
    private List<Ingresso> ingressosVendido = new ArrayList<>();

    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     * @param precoIngresso o preço do ingresso inteiro do Evento
     */
    public Evento(String nome, Local local, float precoIngresso){
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso;
    }

    /**
     * Vende um ingresso para o Evento
     * @param ingresso o ingresso a ser vendido
     */
    public void adicionarIngresso(Ingresso ingresso, Usuario usuario){
        ingressosVendido.add(ingresso);
    }

    /**
     * Retorna o faturamento do Evento
     * @return o faturamento do Evento
     */
    public float calcularFaturamento(){
        float total = 0;
        for (int i = 0; i <= ingressosVendido.size(); i++){
            total += ingressosVendido.get(i).getPreco();
        }

        return total;
    }

    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Altera o nome do Evento para `nome` 
     * @param nome o novo nome do Evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public float getPrecoIngresso(){
        return this.precoIngresso;
    }

    /**
     * Altera o precoIngresso do Evento para `precoIngresso` 
     * @param precoIngresso o novo precoIngresso do Evento
     */
    public void setPrecoIngresso(float precoIngresso){
        this.precoIngresso = precoIngresso;
    }

    /**
     * Retorna o Local associado ao Evento
     * @return o Local associado ao Evento
     */
    public Local getLocal(){
        return this.local;
    }

    /**
     * Altera o Local associado ao Evento para `local` 
     * @param local o novo Local associado ao Evento
     */
    public void setLocal(Local local){
        this.local = local;
    }

    /**
     * Retorna a categoria do evento
     * @return a categoria do evento
     */
    public String getCategoria(){
        return this.categoria;
    }

    /**
     * Altera a categoria do evento para `categoria`
     * @param categoria a nova categoria do evento
     */
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
}
