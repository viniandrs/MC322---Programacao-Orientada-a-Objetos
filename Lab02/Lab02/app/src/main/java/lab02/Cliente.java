/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lab02.exceptions.CancelamentoNaoPermitidoException;
import lab02.exceptions.IngressoNaoEncontradoException;

public class Cliente {

    private String nome;
    private String email;
    private List<Ingresso> ingressos;
    private List<Email> emails;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     */
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.ingressos = new ArrayList<>();
        this.emails = new ArrayList<>();
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
     * Cancela um ingresso associado a um evento
     * @param evento o evento associado ao ingresso a ser cancelado
     * @return true se o ingresso foi cancelado com sucesso, false caso contrário
     * @throws IngressoNaoEncontradoException se o ingresso não for encontrado na lista de ingressos do cliente
     * @throws CancelamentoNaoPermitidoException se o cancelamento não for permitido
     */
    public boolean cancelarIngresso(Evento evento) throws IngressoNaoEncontradoException, CancelamentoNaoPermitidoException {
        Ingresso ingressoEncontrado = ingressos.stream()
            .filter(ing -> ing.getEvento().equals(evento)).collect(Collectors.toList()).get(0);
        if(ingressoEncontrado==null) {
            throw new IngressoNaoEncontradoException("Ingresso não encontrado");
        }
        if(this.removerIngresso(ingressoEncontrado) == false) {
            throw new CancelamentoNaoPermitidoException("Cancelamento não permitido"); // Pensar em caso de teste para essa condicao
        }
        return this.removerIngresso(ingressoEncontrado);
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