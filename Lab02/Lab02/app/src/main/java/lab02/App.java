/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.Arrays;

import lab02.filters.EventoPorLocalFilter;
import lab02.filters.EventoPorNomeFilter;

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

        // DEMONSTRAÇÃO 3: Venda de ingressos com erro de ingressos esgotados
        System.out.println("********************************************");
        System.out.println("Demonstração 3: Venda de ingressos com erro de ingressos esgotados");

        // - buscando o evento desejado utilizando um filtro
        System.out.println("> Buscando evento: Evento Teste com 1 pessoa");
        Evento evento_esgotado = organizadora1.buscarEventos(new EventoPorNomeFilter("Evento Teste com 1 pessoa")).get(0);
        System.out.println("Ingressos disponíveis para o evento " + evento_esgotado.getNome() + ": " + evento_esgotado.getIngressosDisponiveis());

        // - comprando dois ingressos para o evento
        Ingresso ingresso_evento_esgotado = new Ingresso(evento_esgotado, evento_esgotado.getPrecoIngresso());
        cliente1.comprarPorEmail(ingresso_evento_esgotado, "baladaeventos@mail.com");
        cliente1.getEmails().get(0).visualizar();
        cliente1.getEmails().get(0).notificar();

        System.out.println("Ingressos disponíveis para o evento " + evento_esgotado.getNome() + ": " + evento_esgotado.getIngressosDisponiveis());
        cliente1.comprarPorEmail(ingresso_evento_esgotado, "baladaeventos@mail.com");
        System.out.println();

        cliente1.listarIngressos();
        
        // DEMONSTRAÇÃO 4: Cancelamento de ingresso com erro de ingresso não encontrado e cancelamento não permitido
        System.out.println("********************************************");
        System.out.println("Demonstração 4: Cancelamento de ingresso com erro de ingresso não encontrado e cancelamento não permitido");

        Evento mpb_ao_vivo = organizadora1.buscarEventos(new EventoPorNomeFilter("MPB Ao Vivo")).get(0);
        organizadora1.cancelarIngresso(cliente1, mpb_ao_vivo);
        organizadora1.cancelarIngresso(cliente1, evento_esgotado);

        // DEMONSTRAÇÃO 5: Busca por filtro de local
        System.out.println("********************************************");
        System.out.println("Busca por filtro de local");

        // - adicionando novos ingressos para o cliente 1
        Ingresso ingresso_mpb = new Ingresso(mpb_ao_vivo, mpb_ao_vivo.getPrecoIngresso());
        cliente1.comprarPorEmail(ingresso_mpb, "baladaeventos@mail.com");

        Evento festival_inverno = organizadora1.buscarEventos(new EventoPorNomeFilter("Festival de Inverno")).get(0);
        Ingresso ingresso_festival = new Ingresso(festival_inverno, festival_inverno.getPrecoIngresso());
        cliente1.comprarPorEmail(ingresso_festival, "baladaeventos@mail.com");

        System.out.println("> Buscando evento: Evento em Bar do Zé");
        Evento evento_bar_do_ze = organizadora1.buscarEventos(new EventoPorLocalFilter("Bar do Zé")).get(0);


        // DEMONSTRAÇÃO 4: 


    }
}
