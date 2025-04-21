/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.Arrays;
import java.util.List;

import lab02.filters.EventoPorLocalFilter;

/**
 * Contém a estrutura de implementação da aplicação.
 * 
 * @author NOME - RA
 */
public class App {

    /**
     * Aplicação principal
     * @param args
     */
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Joao", "joao@mail.com");
        Local bar_do_ze = new Local("Bar do Zé", 150);
        Local parque_maeda = new Local("Parque Maeda", 10000);
        Local neo_quimica_arena = new Local("Neo Química Arena", 50000);
        Organizadora organizadora1 = new Organizadora("Balada Eventos", 1234, "Avenida Albert Einstein, 14");

        // DEMONSTRAÇÃO 1: Criação de eventos com overload
        System.out.println("********************************************");
        System.out.println("Demonstração 1: Criação de eventos com overload");

        Local localTeste = new Local("Local para 1 pessoa", 1);

        organizadora1.criarEvento("Evento Teste com 1 pessoa", localTeste, 30, organizadora1, "22/04/2025", "Sem artista");
        organizadora1.criarEvento("MPB Ao Vivo", bar_do_ze, 30, organizadora1, "21/04/2025", "Djavan");
        organizadora1.criarEvento("Festival de Inverno", parque_maeda, 200, organizadora1, "21/06/2025", Arrays.asList("Alok", "Djavan", "Jorge & Mateus"), 3);
        organizadora1.criarEvento("Corinthians vs Palmeiras", neo_quimica_arena, 100, organizadora1, "14/05/2025", Arrays.asList("Corinthians", "Palmeiras"));
        organizadora1.listEventos();

        // DEMONSTRAÇÃO 2: Alocação de local com erros
        System.out.println("********************************************");
        System.out.println("Demonstração 2: Alocação de local com erros");

        System.out.println("Tentando alocar o local " + bar_do_ze.getNome() + " para o evento " + organizadora1.getEventos().get(2).getNome());
        try {
            bar_do_ze.alocarParaEvento(organizadora1.getEventos().get(2));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Tentando alocar o local " + bar_do_ze.getNome() + " para o evento " + organizadora1.getEventos().get(1).getNome());
        try {
            bar_do_ze.alocarParaEvento(organizadora1.getEventos().get(1));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Tentando alocar o local " + bar_do_ze.getNome() + " para o evento " + organizadora1.getEventos().get(0).getNome());
        try {
            bar_do_ze.alocarParaEvento(organizadora1.getEventos().get(0));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        // DEMONSTRAÇÃO 3: Busca por evento utilizando filtro
        System.out.println("********************************************");
        System.out.println("Demonstração 2: Busca por evento utilizando filtro");

        System.out.println("Buscando o evento criado pela " + organizadora1.getNome() + " no local " + bar_do_ze.getNome());

        EventoPorLocalFilter filtro_por_local = new EventoPorLocalFilter(bar_do_ze);
        List<Evento> shows_no_bar_do_ze = organizadora1.buscarEventos(filtro_por_local);

        System.out.println("Eventos encontrados:");
        for (Evento evento : shows_no_bar_do_ze) {
            System.out.println(evento.getNome() + " - " + evento.getLocal().getNome() + " - " + evento.getData());
        }

        // DEMONSTRAÇÃO 3: Compra de ingresso por email
        System.out.println("********************************************");
        System.out.println("Demonstração 3: Compra de ingresso por email");

        EventoShow show = (EventoShow) shows_no_bar_do_ze.get(0);
        Ingresso ingresso_show = new Ingresso(show, show.getPrecoIngresso());
        cliente1.comprarPorEmail(ingresso_show, "baladaeventos@mail.com");
        cliente1.getEmails().get(0).visualizar();
        cliente1.getEmails().get(0).notificar();

        // DEMONSTRAÇÃO 4: 


    }
}
