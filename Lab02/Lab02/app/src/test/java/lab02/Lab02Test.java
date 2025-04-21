/*
 * Lab01Test.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import lab02.caracteristicadeevento.EventoEmBar;
import lab02.caracteristicadeevento.EventoMusicaAoVivo;
import lab02.notificavel.Email;

/**
 * @author Vinicius Andreossi - 195125
 * Modificações realizadas:
 * 
 * - Os testes que usam a classe EventoShow foram alterados para usarem os atributos genero e artista. A única motivação por trás disso foi reaproveitar 
 * a implementação já existente.
 */

public class Lab02Test {
    private Cliente testCliente;
    private Local testLocal;
    private Organizadora testOrg;
    private EventoShow testEvento;
    private Ingresso testIng;
    

    private void reset(){
        this.testCliente = new Cliente("Joao", "joao@mail.com");
        this.testLocal = new Local("Teatro Castro Mendes", 2000);
        this.testOrg = new Organizadora("Virada Cultural", 1234, "Teatro Municipal");
        this.testEvento = new EventoShow("MPB em Campinas", testLocal, 150, testOrg, "15/04/2025", "Djavan");
        this.testIng = new Ingresso(this.testEvento, 150);
    }

    /**
     * Testa a compra por email
     */
    @Test
    public void comprarPorEmail() {   
        this.reset();   
        this.testCliente.comprarPorEmail(this.testIng, "vinicius@mail.com"); 
        assertEquals(this.testEvento, this.testCliente.getIngressos().get(0).getEvento());
    }

    /**
     * Testa uma compra por email para um evento sem capacidade
     */
    @Test
    public void compraEmailSemCapacidade() {   
        this.reset();   
        Local localSemCapacidade = new Local("Teatro Castro Mendes", 0);
        Evento eventoSemCapacidade = new EventoShow("MPB em Campinas", localSemCapacidade, 150, this.testOrg, "15/04/2025", "Djavan");
        Ingresso ingressoSemCapacidade = new Ingresso(eventoSemCapacidade, 150);
        assertFalse(this.testCliente.comprarPorEmail(ingressoSemCapacidade, "vinicius@mail.com"));
    }

    /**
     * Testa a visualizacao de um email
     */
    @Test
    public void visualizarEmail() {   
        this.reset();   
        this.testCliente.comprarPorEmail(this.testIng, "vinicius@mail.com"); 
        Email mail = this.testCliente.getEmails().get(0);
        mail.visualizar();
        assertEquals(true, mail.getStatus());
    }

    /**
     * Testa a comparacao entre dois clientes que vão aos mesmos eventos
     */

    @Test
    public void compararClientes() {
        this.reset();
        Cliente cliente2 = new Cliente("Joao", "joao@mail.com");

        this.testCliente.comprarPorEmail(this.testIng, "organizadora@gmail.com");
        cliente2.comprarPorEmail(this.testIng, "organizadora@gmail.com");
        assertTrue(this.testCliente.compareTo(cliente2));
    }

    /**
     * Testa a comparacao entre dois clientes que vão a eventos diferentes
     */

    @Test
    public void compararClientesDiferentes() {
        this.reset();
        Cliente cliente2 = new Cliente("Joao", "joao@mail.com");
        EventoJogo evento2 = new EventoJogo("Guarani vs Ponte Preta", testLocal, 200, testOrg, "15/04/2025", Arrays.asList("sup1", "sup2", "sup3"));
        Ingresso ingresso2 = new Ingresso(evento2, 150);

        this.testCliente.comprarPorEmail(this.testIng, "organizadora@gmail.com");
        cliente2.comprarPorEmail(ingresso2, "organizadora@gmail.com");
        assertFalse(this.testCliente.compareTo(cliente2));
    }

    /**
     * Testa as características de um evento
     */

    @Test
    public void testarComposicaoEvento() {
        this.reset();
        this.testEvento.adicionarCaracteristica(new EventoEmBar("Bar do Zé", "18h", "2h"));
        this.testEvento.adicionarCaracteristica(new EventoMusicaAoVivo("Djavan", "MPB"));
        this.testEvento.descricaoDoEvento();
        assertEquals(2, this.testEvento.getCaracteristicas().size());
    }
}