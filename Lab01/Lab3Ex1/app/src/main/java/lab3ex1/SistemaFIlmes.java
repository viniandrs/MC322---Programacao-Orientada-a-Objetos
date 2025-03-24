package lab3ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SistemaFilmes {
    private final List<Filme> filmes;
    private final Set<String> titulos;

    public SistemaFilmes() {
        this.filmes = new ArrayList<>();
        this.titulos = new HashSet<>();
    }

    /**
     * Adiciona um filme ao sistema, desde que o seu titulo nao esteja
     * ja cadastrado.
     *
     * @param filme o filme a ser adicionado
     * @return true se o filme foi adicionado, false caso o filme ja constasse no sistema
     */
    public boolean addTitulo(Filme filme) {
        if (this.titulos.contains(filme.getTitulo())) {
            return false;
        }
        this.filmes.add(filme);
        this.titulos.add(filme.getTitulo());
        return true;
    }

    /**
     * Retorna a mediana das notas dos filmes do sistema, ordenadas em
     * ordem crescente. Se o sistema estiver vazio, retorna -1.
     *
     * @return a mediana das notas dos filmes
     */
    public double medianaNotas() {
        if (this.filmes.isEmpty()) {
            return -1;
        }

        // ordenando as notas
        List<Double> notas = new ArrayList<>();
        for (Filme filme : this.filmes) {
            String str = "Filme: %s \nNota: %f\n";
            System.out.println(
                String.format(str, filme.getTitulo(), filme.getNota())
            );
            notas.add(filme.getNota());
        }
        notas.sort(Comparator.naturalOrder());

        System.out.println("Sorted list:");
        System.out.println(Arrays.toString(notas.toArray()));

        // obtendo o elemento do meio caso a lista tenha um número ímpar de elementos
        // ou a média dos elementos do meio caso a lista tenha um número par de elementos
        int n = notas.size();
        System.out.println(String.format("n = %d", n));
        double mediana;

        if ((n & 1) == 0) {
            n--;
            // numero par de elementos na lista
            System.out.println("numero par de elementos na lista");
            mediana = (notas.get(n / 2) + notas.get((n / 2) + 1)) / 2;
        } else {
            n--;
            // numero impar de elementos na lista
            System.out.println("numero impar de elementos na lista");
            mediana = notas.get((n + 1) / 2);
        }

        System.out.println(String.format("mediana: %f\n----------------------", mediana));
        return mediana;
    }
}