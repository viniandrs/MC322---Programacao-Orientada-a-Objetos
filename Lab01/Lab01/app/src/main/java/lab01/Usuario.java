/*
 * Usuario.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab01;


import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um Usuario.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class Usuario {

    private final String nome;
    private final String email;
    private final List<Ingresso> ingressos = new ArrayList<>();

    /**
     * Construtor da classe Usuario
     * @param nome o nome do usuário
     * @param email o email do usuário
     */
    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    /**
     * Adiciona um ingresso à lista de ingressos do usuário
     * @param ingresso o ingresso a ser adicionado
     */
    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    /**
     * Lista todos os ingresso adquiridos pelo usuário
     * @param ingresso o ingresso a ser adicionado
     */
    public void listarIngressos() {
        System.out.println("Ingressos adquiridos por " + this.getNome() + ":");
        for (Ingresso ingresso : ingressos) {
            System.out.println("- \"" + ingresso.getTipo() + "\" para o evento \"" + ingresso.getEvento().getNome() + "\"");
        }
    }

    /**
     * Retorna o último ingresso adicionado à lista de ingressos do usuário
     * @return o último ingresso adicionado
     */
    public Ingresso getIngresso() {
        return ingressos.get(ingressos.size() - 1);
    }

    /**
     * Retorna a lista de ingressos do usuário
     * @return a lista de ingressos do usuário
     */
    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    /**
     * Retorna o nome do usuário
     * @return o nome do usupario
     */
    public String getNome(){
        return nome;
    }

    /**
     * Retorna o email do usuário
     * @return o email do usuario
     */
    public String getEmail(){
        return email;
    }
}
