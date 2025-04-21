package lab02.notificavel;

public abstract class Visualizavel implements Notificavel {
    private boolean status;

    public Visualizavel() {
        this.status = false;
    }

    @Override
    public abstract void visualizar();

    @Override
    public abstract void notificar();

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        if(!status) {
            throw new IllegalArgumentException("Não é possível alterar o status para não visualizado se ele já estiver visualizado.");
        }
        this.status = status;
    }
}