package lab03.notificavel;

public abstract class Mensagem implements Notificavel {
    private boolean isRead;

    public Mensagem() {
        this.isRead = false;
    }

    @Override
    public abstract void visualizar();

    @Override
    public abstract void notificar();

    public boolean getReadStatus() {
        return isRead;
    }

    public void setReadStatus(boolean status) {
        if(!status) {
            throw new IllegalArgumentException("Não é possível alterar o status para não visualizado se ele já estiver visualizado.");
        }
        this.isRead = status;
    }
}