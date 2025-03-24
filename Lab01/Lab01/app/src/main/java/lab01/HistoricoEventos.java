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
    private final List<Evento> eventos = new ArrayList<>();

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
     * @param evento a classe do evento a ser procurado
     */
    public List<Evento> buscarEventosPorTipo(Class eventoProcurado) {
        List<Evento> eventosEncontrados = new ArrayList<>();
        for (Evento evento : this.eventos) {
            if (eventoProcurado.isInstance(evento)) {
                eventosEncontrados.add(evento);
            }
        }
        
        if (eventosEncontrados.isEmpty()) {
            return null;
        }
        return eventosEncontrados;
    }

    /** 
     * Procura um evento pela categoria no historico
     * @param categoria a categoria do evento a ser procurado
     */
    public List<Evento> buscarEventosPorCategoria(String categoria) {
        List<Evento> eventosEncontrados = new ArrayList<>();
        for (Evento evento : this.eventos) {
            if (evento.getCategoria().equals(categoria)) {
                eventosEncontrados.add(evento);
            }
        }

        if (eventosEncontrados.isEmpty()) {
            return null;
        }
        return eventosEncontrados;
    }

    /** 
     * Procura um evento pelo nome do local no historico
     * @param local o nome do local do evento a ser procurado
     */
    public List<Evento> buscarEventosPorLocal(String local) {
        List<Evento> eventosEncontrados = new ArrayList<>();
        for (Evento evento : this.eventos) {
            if (evento.getLocal().getNome().equals(local)) {
                eventosEncontrados.add(evento);
            }
        }
        
        if (eventosEncontrados.isEmpty()) {
            return null;
        }
        return eventosEncontrados;
    }

    /**
     * Retorna a lista de eventos do historico
     * @return a lista de eventos do historico
     */
    public List<Evento> getEventos() {
        return eventos;
    }

}
