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
 * @author Gabriel Leite - 216180
 * @author Caio Rhoden - 214129
 * @author Vinicius Andreossi - 195125
 */
public class Usuario {

    private String nome;
    private String email;
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
     * Retorna o último ingresso adicionado à lista de ingressos do usuário
     * @return o último ingresso adicionado
     */
    public Ingresso getIngresso() {
        return ingressos.get(ingressos.size() - 1);
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
