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

    public HistoricoEventos() {}

    /**
     * Adiciona um evento ao historico
     * @param evento o evento a ser adicionado
     */
    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    /**
     * Realiza a busca de eventos no historico de acordo com o filtro fornecido
     * e imprime os resultados
     * @param filtro o filtro a ser aplicado, deve implementar a interface FiltroEventos
     */
    public void printarBusca(FiltroEventos filtro) {
        List<Evento> eventosFiltrados = buscarEventos(filtro);
        if (eventosFiltrados.isEmpty()) {
            System.out.println("Nenhum evento encontrado com o filtro fornecido.");
        } else {
            System.out.println("Eventos encontrados:");
            for (Evento evento : eventosFiltrados) {
                System.out.println("- " + evento.getNome());
            }
        }
    }

    /**
     * Imprime os eventos no historico
     */
    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento encontrado.");
        } else {
            System.out.println("Eventos no historico:");
            for (Evento evento : eventos) {
                System.out.println("- " + evento.getNome());
            }
        }
    }

    /**
     * Retorna a lista de eventos filtrados de acordo com o filtro fornecido
     * @param filtro o filtro a ser aplicado, deve implementar a interface FiltroEventos
     * @return a lista de eventos filtrados
     * @see FiltroEventos
     */
    public List<Evento> buscarEventos(FiltroEventos filtro) {
        List<Evento> eventosFiltrados = new ArrayList<>();
        for (Evento evento : this.eventos) {
            if(filtro.filtrar(evento.getClass())) {
                eventosFiltrados.add(evento);
            }
        }
        return eventosFiltrados;
    }

    /**
     * Retorna a lista de eventos do historico
     * @return a lista de eventos do historico
     */
    public List<Evento> getEventos() {
        return eventos;
    }

}
