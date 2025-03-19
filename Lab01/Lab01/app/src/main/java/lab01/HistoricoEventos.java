/*
 * HistoricoEventos.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um Historico de Eventos.
 *
 * @author Vinicius Andreossi - 195125
 */

public class HistoricoEventos {
    private List<Evento> eventos = new ArrayList<>();

    /**
     * Construtor da classe Historico de Eventos
     */

    public HistoricoEventos() {
        System.out.println("Historico de Eventos necessita de melhorias nos métodos de busca!");
    }

    /**
     * Adiciona um evento ao historico
     * @param evento o evento a ser adicionado
     */
    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    /** 
     * Procura um evento pelo nome no historico
     * @param nome o nome do evento a ser procurado
     */
    public Evento procurarEventoPorNome(String nome) {
        for (Evento evento : this.eventos) {
            if (evento.getNome().equals(nome)) {
                return evento;
            }
        }
        return null;
    }

    /** 
     * Procura um evento pela categoria no historico
     * @param categoria a categoria do evento a ser procurado
     */
    public Evento procurarEventoPorCategoria(String categoria) {
        for (Evento evento : this.eventos) {
            if (evento.getCategoria().equals(categoria)) {
                return evento;
            }
        }
        return null;
    }

    /** 
     * Procura um evento pelo nome do local no historico
     * @param local o nome do local do evento a ser procurado
     */
    public Evento procurarEventoPorLocal(String local) {
        for (Evento evento : this.eventos) {
            if (evento.getLocal().getNome().equals(local)) {
                return evento;
            }
        }
        return null;
    }

}
