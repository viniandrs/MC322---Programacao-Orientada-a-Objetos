/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.ArrayList;
import java.util.List;

public class ImobiliariaDeEventos {
    
    private List<Local> locais;
    private String nome;


    /**
     * Construtor da classe ImobiliariaDeEventos
     * @param nome o nome da imobiliária de eventos
     */
    public ImobiliariaDeEventos(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona um local à lista de locais disponíveis
     * @param local o local a ser adicionado
     */
    public void adicionarLocal(Local local) {
        this.locais.add(local);
    }

    public List<Local> buscarLocal(String nome) {
        List<Local> locaisEncontrados = new ArrayList<>();
        for (Local local : this.locais) {
            if (local.getNome().equals(nome)) {
                locaisEncontrados.add(local);
            }
        }
        return locaisEncontrados;
    }

    public List<Local> buscarLocal(int capacidadeMaxima) {
        List<Local> locaisEncontrados = new ArrayList<>();
        for (Local local : this.locais) {
            if (local.getCapacidade() == capacidadeMaxima) {
                locaisEncontrados.add(local);
            }
        }
        return locaisEncontrados;
    }
    
}
