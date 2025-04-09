/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cliente {

    private String nome;
    private String email;
    private List<Ingresso> ingressos;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     */
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.ingressos = new ArrayList<>();
    }

    /**
     * Adiciona um ingresso à lista de ingressos do cliente
     * @param ingresso o ingresso a ser adicionado
     * @return true se o ingresso foi adicionado com sucesso, false caso contrário
     */

    public void adicionarIngresso(Ingresso ingresso){
        this.ingressos.add(ingresso);
    }

    /**
     * Adiciona uma lista de ingressos à lista de ingressos do cliente
     * @param novosIngressos a lista de ingressos a serem adicionados
     */
    public void adicionarIngresso(List<Ingresso> novosIngressos) {
        this.ingressos = Stream.concat(this.ingressos.stream(), novosIngressos.stream()).toList();
    }

    /**
     * Remove um ingresso da lista de ingressos do cliente
     * @param ingresso o ingresso a ser removido
     * @return true se o ingresso foi removido com sucesso, false caso contrário (e.g. ingresso não existe na lista)
     */
    public boolean removerIngresso(Ingresso ingresso){
        return this.ingressos.remove(ingresso);
    }

    /**
     * Retorna a lista de ingressos do cliente
     * @return a lista de ingressos do cliente
     */
    public List<Ingresso> getIngressos(){
        return this.ingressos;
    }

    /**
     * Retorna o nome do cliente
     * @return o nome do cliente
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do cliente
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o email do cliente
     * @return o email do cliente
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Altera o email do cliente para `email` 
     * @param email o novo email do cliente
     */
    public void setEmail(String email){
        this.email = email;
    }

}