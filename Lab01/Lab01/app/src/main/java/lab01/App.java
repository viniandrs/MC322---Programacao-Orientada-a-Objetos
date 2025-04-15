/*
 * App.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação da aplicação.
 * 
 * @author Vinicius Andreossi - 195125
 * 
 * Uso de IA generativa: Copilot foi utilizado para fazer getters e setters, funções de output (e.g. user.listarIngressos() e historico.printarBusca) e comentários.
 * Funções de manipulação de estrutura de dados e implementação geral do programa foram feitas sem auxílio de IA.
 */
public class App {

    /**
     * Aplicação principal
     * @param args
     */
    public static void main(String[] args) {
        // DEMONSTRAÇÃO DAS FUNCIONALIDADES DO CÓDIGO
        System.out.println("--------------- Demonstração 1: ---------------");
        System.out.println("1. Criando um local, um usuário e um evento de show:");
        
        Local allianz = new Local("Allianz Parque", 300);
        Usuario gabriel = new Usuario("Gabriel", "gabriel@gmail.com");
        EventoShow showTheWeeknd = new EventoShow("Hurry Up Tomorrow Tour", allianz, 400, "Pop", "The Weeknd");

        System.out.println("Local criado: " + allianz.getNome());
        System.out.println("Usuário criado: " + gabriel.getNome());
        System.out.println("Evento criado: " + showTheWeeknd.getNome());

        // DEMONSTRAÇÃO PASSO 1: COMPRA DE INGRESSOS
        System.out.println("\n2. Comprando ingressos:");
        IngressoInteira ingressoInteiraTheWeeknd = new IngressoInteira(showTheWeeknd);
        showTheWeeknd.adicionarIngresso(ingressoInteiraTheWeeknd, gabriel);
        printIngresso(ingressoInteiraTheWeeknd);
        gabriel.listarIngressos();

        // DEMONSTRAÇÃO PASSO 2: CRIANDO NOVO USUÁRIO E NOVO EVENTO
        System.out.println("\n3. Adicionando novo usuario e novo evento:");
        Usuario lucas = new Usuario("Lucas", "lucas@gmail.com");
        EventoEsporte jogoFutebol = new EventoEsporte("Corinthians vs Palmeiras", allianz, 100, 50_000, "Futebol");

        System.out.println("Novo usuário: " + lucas.getNome());
        System.out.println("Novo evento: " + jogoFutebol.getNome());

        IngressoDuplo ingressoDuploFutebol = new IngressoDuplo(jogoFutebol);
        IngressoVIP ingressoVIPFutebol = new IngressoVIP(jogoFutebol);
        jogoFutebol.adicionarIngresso(ingressoDuploFutebol, lucas);
        jogoFutebol.adicionarIngresso(ingressoVIPFutebol, gabriel);

        printIngresso(ingressoDuploFutebol);
        printIngresso(ingressoVIPFutebol);

        gabriel.listarIngressos();
        lucas.listarIngressos();

        // DEMONSTRAÇÃO PASSO 3: CALCULAR FATURAMENTO
        System.out.println("\n4. Calculando o faturamento total dos eventos:");
        showTheWeeknd.calcularFaturamento();
        System.out.println();
        jogoFutebol.calcularFaturamento();

        // DEMONSTRAÇÃO PASSO 4: HISTORICO DE EVENTOS E BUSCA
        System.out.println("\n5. Utilizando os filtros:");
        HistoricoEventos historico = new HistoricoEventos();
        historico.adicionarEvento(showTheWeeknd);
        historico.adicionarEvento(jogoFutebol);
        historico.listarEventos();

        EventoEsporte filtro = new EventoEsporte("EventoEsporteDummy", allianz, 123, 456, "Filtro");
        System.out.println("Evento criado como filtro: \"" + filtro.getNome() + "\" com categoria \"" + filtro.getCategoria() + "\"");

        System.out.println("Realizando busca com o evento filtro como parâmetro...");
        historico.printarBusca(filtro);
    }

    private static void printIngresso(Ingresso ingresso) {
        System.out.println("Ingresso " + ingresso.getTipo() + " para o evento " + ingresso.getEvento().getNome() + " criado com preço " 
            + ingresso.getPreco());
    }
}
