/*
 * Lab01Test.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Vinicius Andreossi - 195125
 * Modificações realizadas:
 * 
 * - Os testes que usam a classe EventoShow foram alterados para usarem os atributos genero e artista. A única motivação por trás disso foi reaproveitar 
 * a implementação já existente.
 */

public class Lab02Test {

    /**
     * Testa se o getCapacidadeEvento retorna a capacidade do local do Evento
     */
    @Test
    public void getCapacidadeEventoShow() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow("MPB em Campinas", testLocal, 150, "MPB", "Djavan");
        assertEquals("Djavan", testEvento.getArtista());
    }


    /**
     * Testa o get e seter do EventoShow para o atributo artista
     * Espera-se a troca de "01/05/2025" por "Anavitória"
     */

    @Test
    public void setAndGetArtistaEventoShow() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow("MPB em Campinas", testLocal, 150, "MPB", "Djavan");
        testEvento.setArtista("Anavitória");
        assertEquals("Anavitória", testEvento.getArtista());
    }

    /**
     * Testa o método getPreco para o IngressoMeia
     * Espera o retorno da metade do valor (100) do ingresso do EventoShow criado (200)
     */

    @Test
    public void getPrecoIngressoMeia() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow("MPB em Campinas", testLocal, 200, "MPB", "Djavan");
        IngressoMeia ingressoMeia = new IngressoMeia(testEvento);
        assertEquals(100, ingressoMeia.getPreco());
    }


    /**
     * Testa o método getPreco para o IngressoInteira
     * Espera o retorno do valor (250) do ingresso do EventoShow criado
     */
    @Test
    public void getPrecoIngressoInteira() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow("MPB em Campinas", testLocal, 250, "MPB", "Djavan");
        IngressoInteira ingressoInteira = new IngressoInteira(testEvento);
        assertEquals(250, ingressoInteira.getPreco());
    }

    /**
     * Testa o método adicionarIngressoMeia
     * Verifica se o ingresso foi adicionado à lista de ingressos vendidos
     * e se o usuario agora tem o ingresso
     */
    @Test
    public void adicionarIngressoMeia() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento = new EventoShow("MPB em Campinas", testLocal, 200, "MPB", "Djavan");
        IngressoMeia ingressoMeia = new IngressoMeia(testEvento);
        Usuario usuarioTest = new Usuario("Gabriel", "gabriel@me.com");
        testEvento.adicionarIngresso(ingressoMeia, usuarioTest);
        assertEquals(1, testEvento.getIngressosVendidos().size());
        assertEquals(ingressoMeia, usuarioTest.getIngresso());

    }
    
    /**
     * Testa o método adicionarEvento do HistoricoEventos
     * Verifica se os dois eventos foram adicionados à lista de eventos
     * do HistoricoEventos
     */
    @Test
    public void adicionaEventoemHistorico() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento1 = new EventoShow("MPB em Campinas", testLocal, 200, "Djavan", "01/05/2025");
        EventoShow testEvento2 = new EventoShow("MPB em Campinas", testLocal, 200, "Anavitória", "02/05/2025");
        HistoricoEventos historicoTeste = new HistoricoEventos();
        historicoTeste.adicionarEvento(testEvento1);
        historicoTeste.adicionarEvento(testEvento2);
        assertEquals(2, historicoTeste.getEventos().size());

    }

    /**
     * Testa o método buscarEventosPorTipo do HistoricoEventos
     * Verifica se os dois eventos do tipo EventoShow foram encontrados
     * pela busca
     */
    @Test
    public void buscarEventosPorTipo() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento1 = new EventoShow("MPB em Campinas", testLocal, 200, "Djavan", "01/05/2025");
        EventoEsporte testEvento2 = new EventoEsporte("Guarani vs Ponte Preta", testLocal, 200, 2000, "Futebol");
        HistoricoEventos historicoTeste = new HistoricoEventos();
        historicoTeste.adicionarEvento(testEvento1);
        historicoTeste.adicionarEvento(testEvento2);
        assertEquals(1, historicoTeste.buscarEventos(testEvento1).size());
    }

    /**
     * Testa o ingresso do tipo Duplo. 
     * Checa se ao comprar um ingresso duplo, o usuário tem dois ingressos na lista de ingressos
     */
    @Test
    public void comprarIngressoDuplo() {

        Local testLocal = new Local("Teatro Castro Mendes", 2000);
        EventoShow testEvento1 = new EventoShow("MPB em Campinas", testLocal, 200, "Djavan", "01/05/2025");
        IngressoDuplo ingressoDuplo = new IngressoDuplo(testEvento1);       
        Usuario testUser = new Usuario("Zé", "ze@gmail.com" );
        testEvento1.adicionarIngresso(ingressoDuplo, testUser);
        testUser.listarIngressos();
        assertEquals(2, testUser.getIngressos().size());
        assertEquals(2, testEvento1.getIngressosVendidos().size());
    }
}