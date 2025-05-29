/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.Arrays;

import lab02.filters.AndFilter;
import lab02.filters.EventoPorLocalFilter;
import lab02.filters.EventoPorNomeFilter;

/**
 * Contém a estrutura de implementação da aplicação.
 * 
 * @author Vinicius Ventura Andreossi - RA 195125
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

        Local localTeste = new Local("LocalTeste_lotacao1", 1);

        organizadora1.criarEvento("EventoTeste_1pessoa", localTeste, 30, organizadora1, "22/04/2025", "Sem artista");
        organizadora1.criarEvento("MPB Ao Vivo", bar_do_ze, 30, organizadora1, "21/04/2025", "Djavan");
        organizadora1.criarEvento("Festival de Inverno", parque_maeda, 200, organizadora1, "21/06/2025", Arrays.asList("Alok", "Djavan", "Jorge & Mateus"), 3);
        organizadora1.criarEvento("Corinthians vs Palmeiras", neo_quimica_arena, 100, organizadora1, "14/05/2025", Arrays.asList("Corinthians", "Palmeiras"));
        organizadora1.listEventos();

        // DEMONSTRAÇÃO 2: Alocação de local com erros
        System.out.println("********************************************");
        System.out.println("Demonstração 2: Alocação de local com erros");

        System.out.println("1 - Tentando alocar o local " + bar_do_ze.getNome() + " para o evento " + organizadora1.getEventos().get(2).getNome());
        System.out.print("> ");
        try {
            bar_do_ze.alocarParaEvento(organizadora1.getEventos().get(2));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("2 - Tentando alocar o local " + bar_do_ze.getNome() + " para o evento " + organizadora1.getEventos().get(1).getNome());
        System.out.print("> ");
        try {
            bar_do_ze.alocarParaEvento(organizadora1.getEventos().get(1));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("3 - Tentando alocar o local " + bar_do_ze.getNome() + " para o evento " + organizadora1.getEventos().get(0).getNome());
        System.out.print("> ");
        try {
            bar_do_ze.alocarParaEvento(organizadora1.getEventos().get(0));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // DEMONSTRAÇÃO 3: Venda de ingressos com erro de ingressos esgotados e notificação por email
        System.out.println("********************************************");
        System.out.println("Demonstração 3: Venda de ingressos com erro de ingressos esgotados e notificação por email");

        // - buscando o evento desejado utilizando um filtro
        System.out.println("> Buscando evento: EventoTeste_1pessoa");
        Evento evento_esgotado = null;
        try {
            evento_esgotado = organizadora1.buscarEventos(new EventoPorNomeFilter("EventoTeste_1pessoa")).get(0);
        } catch (Exception e) {
            System.out.println("ERROR: evento nao encontrado" + e.getMessage());
            return;
        }
        
        System.out.println("Ingressos disponíveis para o evento " + evento_esgotado.getNome() + ": " + evento_esgotado.getIngressosDisponiveis());

        // - comprando dois ingressos para o evento
        Ingresso ingresso_evento_esgotado = new Ingresso(evento_esgotado, evento_esgotado.getPrecoIngresso());
        cliente1.comprarPorEmail(ingresso_evento_esgotado, "baladaeventos@mail.com");
        cliente1.getEmails().get(0).visualizar();
        cliente1.getEmails().get(0).notificar();

        System.out.println("Ingressos disponíveis para o evento " + evento_esgotado.getNome() + ": " + evento_esgotado.getIngressosDisponiveis());
        cliente1.comprarPorEmail(ingresso_evento_esgotado, "baladaeventos@mail.com");
        System.out.println();
        
        // DEMONSTRAÇÃO 4: Cancelamento de ingresso com erro de ingresso não encontrado e cancelamento não permitido
        System.out.println("********************************************");
        System.out.println("Demonstração 4: Cancelamento de ingresso com erro de ingresso não encontrado e cancelamento não permitido");

        cliente1.listarIngressos();

        System.out.println("Buscando evento no catálogo da organizadora: MPB Ao Vivo...");
        Evento mpb_ao_vivo = organizadora1.buscarEventos(new EventoPorNomeFilter("MPB Ao Vivo")).get(0);
        System.out.println("> Tentando cancelar o evento MPB Ao Vivo");
        organizadora1.cancelarIngresso(cliente1, mpb_ao_vivo); // Ingresso nao encontrado
        // organizadora1.cancelarIngresso(cliente1, evento_esgotado); // Cancelamento nao permitido

        // DEMONSTRAÇÃO 5: Sobrecarga de métodos de busca e busca com AndFilter
        System.out.println("********************************************");
        System.out.println("Demonstração 5: Sobrecarga de métodos de busca e busca com AndFilter");
        System.out.println("1 - O código desenvolvido nas demonstrações anteriores já fez uso do método de busca por nome:");
        System.out.println("organizadora1.buscarEventos(new EventoPorNomeFilter(\"MPB Ao Vivo\"))");

        System.out.println();
        System.out.println("2 - Agora, vamos buscar eventos por local:");
        System.out.println("Buscando eventos no local Parque Maeda...");
        Evento eventoPorLocal = null;
        try {
            eventoPorLocal = organizadora1.buscarEventos(new EventoPorLocalFilter("Parque Maeda")).get(0);
            System.out.println("Evento encontrado: " + eventoPorLocal.getNome());
        } catch (Exception e) {
            System.out.println("ERROR: evento nao encontrado. " + e.getMessage());
        }  

        System.out.println("3 - Buscando o evento no local Parque Maeda chamado Festival de Inverno...");
        try {
            eventoPorLocal = organizadora1.buscarEventos(new AndFilter(new EventoPorLocalFilter("Parque Maeda"), new EventoPorNomeFilter("Festival de Inverno"))).get(0);
            System.out.println("Evento encontrado: " + eventoPorLocal.getNome());
        } catch (Exception e) {
            System.out.println("ERROR: evento nao encontrado. " + e.getMessage());
        }

        System.out.println("4 - Buscando Festival de Inverno no Bar do Zé...");
        try {
            eventoPorLocal = organizadora1.buscarEventos(new AndFilter(new EventoPorLocalFilter("Bar do Zé"), new EventoPorNomeFilter("Festival de Inverno"))).get(0);
            System.out.println("Evento encontrado: " + eventoPorLocal.getNome());
        } catch (Exception e) {
            System.out.println("ERROR: evento nao encontrado. " + e.getMessage());
        }

        // DEMONSTRAÇÃO 6: Comparação de clientes
        System.out.println("********************************************");
        System.out.println("Demonstração 6: Comparação de clientes");

        // criando novos clientes
        Ingresso ingresso_mpb = new Ingresso(mpb_ao_vivo, mpb_ao_vivo.getPrecoIngresso());

        Cliente cliente_a = new Cliente("Maria", "maria@mail.com");
        cliente_a.comprarPorEmail(ingresso_mpb, "organizadora@mail.com");
        // cliente_a.getEmails().get(0).visualizar();
        cliente_a.listarIngressos();

        Cliente cliente_b = new Cliente("Zé", "ze@mail.com");
        cliente_b.comprarPorEmail(ingresso_mpb, "organizadora@mail.com");
        // cliente_b.getEmails().get(0).visualizar();
        cliente_b.listarIngressos();

        // comparando os dois clientes com ingressos para os mesmos eventos 
        System.out.println("1 - Clientes com ingressos para o mesmo conjunto de eventos:");
        System.out.print(" - Comparando clientes " + cliente_a.getNome() + " e " + cliente_b.getNome() + ": ");
        if (cliente_a.compareTo(cliente_b)) {
            System.out.println("Os clientes possuem ingressos para os mesmos eventos.");
        } else {
            System.out.println("Os clientes não possuem ingressos para os mesmos eventos.");
        }

        // comparando os dois clientes
        System.out.println("2 - Clientes com ingressos para diferentes conjuntos de eventos:");
        Evento festival_inverno = organizadora1.buscarEventos(new EventoPorNomeFilter("Festival de Inverno")).get(0);
        Ingresso ingresso_festival_inverno = new Ingresso(festival_inverno, festival_inverno.getPrecoIngresso());
        cliente_a.comprarPorEmail(ingresso_festival_inverno, "organizador@mail.com");
        cliente_a.listarIngressos();
        cliente_b.listarIngressos();
        System.out.print(" - Comparando clientes " + cliente_a.getNome() + " e " + cliente_b.getNome() + ": ");
        if (cliente_a.compareTo(cliente_b)) {
            System.out.println("Os clientes possuem ingressos para os mesmos eventos.");
        } else {
            System.out.println("Os clientes não possuem ingressos para os mesmos eventos.");
        }
    }
}
