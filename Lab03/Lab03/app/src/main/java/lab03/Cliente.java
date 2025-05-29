/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab03;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lab03.eventos.Evento;
import lab03.exceptions.CancelamentoNaoPermitidoException;
import lab03.exceptions.IngressoNaoEncontradoException;
import lab03.notificavel.Email;

public class Cliente implements Comparable<Cliente> {

    private String nome;
    private String email;
    private List<Ingresso> ingressos;
    private List<Email> emails;
    private double saldo;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     */
    public Cliente(String nome, String email, double saldo) {
        this.nome = nome;
        this.email = email;
        this.ingressos = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.saldo = saldo;
    }

    /**
     * Adiciona um ingressos à lista de ingressos do cliente
     * @param ingresso o ingresso a ser adicionado
     */
    public void adicionarIngresso(Ingresso ingresso) {
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
        if (ingressos.isEmpty()) { throw new IngressoNaoEncontradoException("Nenhum ingresso encontrado"); }

        List<Ingresso> ingressosEncontrados = ingressos.stream().filter(ing -> ing.getEvento().equals(evento)).collect(Collectors.toList());
        if(ingressosEncontrados.isEmpty()) { throw new IngressoNaoEncontradoException("Ingresso não encontrado"); }
        
        Ingresso ingresso_a_cancelar = ingressosEncontrados.get(0);
        if(this.removerIngresso(ingresso_a_cancelar) == false) {
            throw new CancelamentoNaoPermitidoException("Cancelamento não permitido"); // Pensar em caso de teste para essa condicao
        }
        return this.removerIngresso(ingresso_a_cancelar);
    }

    /**
     * Adiciona um email à lista de emails do cliente
     * @param email o email a ser adicionado
     */
    private void adicionarEmail(Email email){
        this.emails.add(email);
        email.notificar();
    }

    /**
     * Compara se o cliente fornecido possui ingressos para os mesmos eventos que este cliente. Não é necessário
     * que os clientes possuam os mesmos ingressos, apenas que os ingressos do cliente fornecido contenham os eventos
     * deste cliente.
     * @param cliente o cliente a ser comparado
     * @return true se os clientes possuem ingressos para os mesmos eventos, false caso um dos clientes possua um ingresso
     * para um evento que o outro não possui
     */
    @Override
    public boolean compareTo(Cliente cliente) {
        HashSet<String> ingressosCliente1 = new HashSet<>();
        HashSet<String> ingressosCliente2 = new HashSet<>();

        for (Ingresso ingresso : this.ingressos) {
            ingressosCliente1.add(ingresso.getEvento().getNome());
        }
        for (Ingresso ingresso : cliente.getIngressos()) {
            ingressosCliente2.add(ingresso.getEvento().getNome());
        }

        // Se os tamanhos dos conjuntos forem diferentes, os clientes não possuem ingressos para os mesmos eventos
        if (ingressosCliente1.size() != ingressosCliente2.size()) {
            return false;
        }

        // Verificação bijetiva da contenção dos conjuntos
        for (String evento : ingressosCliente1) {
            if (!ingressosCliente2.contains(evento)) {
                return false;
            }
        }
        for (String evento : ingressosCliente2) {
            if (!ingressosCliente1.contains(evento)) {
                return false;
            }
        }
        return true;
    }   

    public void listarIngressos() {
        System.out.println("Ingressos do cliente " + this.nome + ":");
        for (Ingresso ingresso : this.ingressos) {
            System.out.println("> " + ingresso.getEvento().getNome() + " - " + ingresso.getEvento().getLocal().getNome() + " - " + ingresso.getEvento().getData());
        }
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

    /**
     * Retorna a lista de emails do cliente
     * @return a lista de emails do cliente
     */
    public List<Email> getEmails(){
        return this.emails; 
    }

}