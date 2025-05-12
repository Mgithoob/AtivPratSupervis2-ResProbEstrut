
# ATIVIDADE PRÁTICA SUPERVISIONADA 2: Implementação de Árvore Binária com Código Morse
# Resolução de Problemas Estruturados em Computação

## Arquivos:

- *ArvoreBinariaMorse.java*
- *Main.java*

### Descrição dos arquivos:


#### *ArvoreBinariaMorse.java*

Árvore binária que representa o código morse para os elementos A-Z, 0-9. Filhos esquerdos são pontos e filhos direitos são traços. De acordo com essa regra, os caracteres são armazenados de tal forma que a sua posição na árvore reflete o código morse que as forma.

Seu construtor inicializa uma árvore com valores nulos ('\0') de altura 5, já que a árvore morse tem um tamanho fixo.

Ela contém uma classe interna _No_. Essa tem os atributos:
- valor (_Tipo Elemento. Contém o valor do nó._)
- esquerda (_Tipo No. Aponta para o filho esquerdo deste nó._)
- direita (_Tipo No. Aponta para o filho direito deste nó._)

Contém os atributos:
- caracteres (_Tipo vetor de caracteres. Auxiliar para o método _tradutor_cm()_, usado par abter posições equivalentes entre os atributos caracteres e morse._) 
- morse (_Tipo vetor de vetor de caracteres. Auxiliar para o método _tradutor_cm()_, usado par abter posições equivalentes entre os atributos caracteres e morse._)
- raiz (_Tipo Node. A raiz da nossa árvore._)

Contém os métodos:
- construirArvore (int nivelAtual, int alturaMaxima) (_Retorna um Node. Constrói a árvore recursivamente. Auxiliar para o construtor da classe._)
- tradutor_cm(char valor) (_Retorna um vetor de caracteres. Recebe um caractere. Será procurado o código morse equivalente ao caractere, utilizando os dois vetores atributos de ArvoreBinariaMorse. Método auxiliar para inseir()_)
- inserir(char valor) (_Sem retorno. Recebe um caracte que será inserido na árvore de acordo com as regras de árvore morse._)
- buscar(String morse_in) (_Retorna char[]. Recebe uma String que deve obrigatoriamente ser um código morse. (traços e pontos, separados por espaços.)_)
- convString(String string) (_Retorna char[]. Recebe uma string que será transformada em um vetor de caracteres. Método auxiliar para buscar()._)
- void desenhar(Node node, int nivel) (_Sem retorno. Recebe um nó e um int nivel. Desenha a árvore no terminal._)

#### *Main.java*

Contém o main e os testes da árvore binária.

## Instruções:

Dentro do arquivo *Main.java*, há todos os testes necessários para conferir se o projeto funciona de acordo com as especificações. Observar a output no terminal.
