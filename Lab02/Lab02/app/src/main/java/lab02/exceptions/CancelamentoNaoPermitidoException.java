/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02.exceptions;

public class CancelamentoNaoPermitidoException extends Exception {
    public CancelamentoNaoPermitidoException(String message) {
        super(message);
    }
}