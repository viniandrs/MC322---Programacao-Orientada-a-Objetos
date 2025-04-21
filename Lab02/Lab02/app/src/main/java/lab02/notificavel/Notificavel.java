package lab02.notificavel;

public interface Notificavel {
    /**
     * Método que imprime o conteúdo do objeto e o marca como visualizado
     */
    public void visualizar();

    /**
     * Método que imprime uma notificação se o objeto ainda não ter sido visualizado.
     * Caso contrário, não imprime nada.
     */
    public void notificar();
}