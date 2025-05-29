/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03;

import java.util.ArrayList;
import java.util.List;

public class ImobiliariaDeEventos {
    private List<Local> locais;


    /**
     * Construtor da classe ImobiliariaDeEventos
     */
    public ImobiliariaDeEventos(String nome) {
        this.locais = new ArrayList<>();
    }

    /**
     * Adiciona um local à lista de locais disponíveis
     * @param local o local a ser adicionado
     */
    public void adicionarLocal(Local local) {
        this.locais.add(local);
    }

    /**
     * Busca um local na lista de locais disponíveis pelo nome
     * @param nome o nome do local a ser buscado
     * @return uma lista de locais encontrados com o nome especificado
     */
    public List<Local> buscarLocal(String nome) {
        List<Local> locaisEncontrados = new ArrayList<>();
        for (Local local : this.locais) {
            if (local.getNome().equals(nome)) {
                locaisEncontrados.add(local);
            }
        }
        return locaisEncontrados;
    }

    /**
     * Busca um local na lista de locais disponíveis pela capacidade máxima
     * @param capacidadeMaxima a capacidade máxima do local a ser buscado
     * @return uma lista de locais encontrados com a capacidade máxima especificada
     * @throws IllegalArgumentException se a capacidade máxima for menor ou igual a zero
     */
    public List<Local> buscarLocal(int capacidadeMaxima) {
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("Capacidade máxima deve ser maior que zero.");
        }

        List<Local> locaisEncontrados = new ArrayList<>();
        for (Local local : this.locais) {
            if (local.getCapacidade() == capacidadeMaxima) {
                locaisEncontrados.add(local);
            }
        }
        return locaisEncontrados;   
    }
    
}
