Você tem um sistema de gerenciamento de filmes, que contem uma classe Filme com atributos: nota, gênero e título do filme. Além dessa classe existe também a SistemaFilmes,
essa classe contém uma lista de filmes e um conjunto de títulos. Você vai precisar adicionais dois métodos para passar em testes unitários criados:

1. addTitutlo(Filme filme): Esse método deve adicionar um Filme novo a lista de filmes do SistemaFilme, retornando true se deu certo ou false se o título já constava no sistema.

2. medianaNotas(): Esse método deve retornar a mediana das notas dos filmes adicionados no sistema ou -1 se não exister nenhum filme adicionado.

Utilize ArrayList e HashSet para resolver esses problemas, lembre-se dos atributos mostrados nos slides. Como comparador fica a sugestão do Comparator.naturalOrder().