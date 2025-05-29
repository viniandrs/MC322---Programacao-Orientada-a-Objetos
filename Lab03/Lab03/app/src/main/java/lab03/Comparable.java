package lab03;

public interface Comparable<T> {
    /**
     * Compara este objeto é igual ao objeto fornecido segundo o critério implementado.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    public boolean compareTo(T o);
}