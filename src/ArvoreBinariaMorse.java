// Uma árvore binária para código morse.
// Galhos à esquerda para pontos e galhos à direita para traços.

public class ArvoreBinariaMorse {
    // Dois vetores para equiparar caracteres e código morse.
    private final char[] caracteres = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private final char[][] morse = {
            {'.', '-'},             // A
            {'-', '.', '.', '.'},   // B
            {'-', '.', '-', '.'},   // C
            {'-', '.', '.'},        // D
            {'.'},                  // E
            {'.', '.', '-', '.'},   // F
            {'-', '-', '.'},        // G
            {'.', '.', '.', '.'},   // H
            {'.', '.'},             // I
            {'.', '-', '-', '-'},   // J
            {'-', '.', '-'},        // K
            {'.', '-', '.', '.'},   // L
            {'-', '-'},             // M
            {'-', '.'},             // N
            {'-', '-', '-'},        // O
            {'.', '-', '-', '.'},   // P
            {'-', '-', '.', '-'},   // Q
            {'.', '-', '.'},        // R
            {'.', '.', '.'},        // S
            {'-'},                  // T
            {'.', '.', '-'},        // U
            {'.', '.', '.', '-'},   // V
            {'.', '-', '-'},        // W
            {'-', '.', '.', '-'},   // X
            {'-', '.', '-', '-'},   // Y
            {'-', '-', '.', '.'},   // Z
            {'-', '-', '-', '-', '-'},   // 0
            {'.', '-', '-', '-', '-'},   // 1
            {'.', '.', '-', '-', '-'},   // 2
            {'.', '.', '.', '-', '-'},   // 3
            {'.', '.', '.', '.', '-'},   // 4
            {'.', '.', '.', '.', '.'},   // 5
            {'-', '.', '.', '.', '.'},   // 6
            {'-', '-', '.', '.', '.'},   // 7
            {'-', '-', '-', '.', '.'},   // 8
            {'-', '-', '-', '-', '.'}    // 9
    };

    private Node raiz;

    class Node {
        private char valor;
        private Node esquerda, direita;Node(char valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    // Como a árvore do código morse tem um tamanho fixo, o construtor cria uma árvore vazia de altura 5.
    public ArvoreBinariaMorse() {
        raiz = construirArvore(1, 6);
    }

    // Método auxiliar que constrói a árvore recursivamente.
    // Deve ser usado somente no construtor.
    private Node construirArvore(int nivelAtual, int alturaMaxima) {
        if (nivelAtual > alturaMaxima) {
            return null;
        }

        Node no = new Node('\0'); // Caractere vazio para os elementos vazios.
        no.esquerda = construirArvore(nivelAtual + 1, alturaMaxima);
        no.direita = construirArvore(nivelAtual + 1, alturaMaxima);
        return no;
    }

    // "Traduz" um caractere para morse.
    // Irá retornar a String em morse equivalente ao mesmo.
    char[] tradutor_cm(char valor){
        // Se o caractere for uma letra minuscula, transforma em maiúscula.
        if ( (valor >= 97 && valor <= 122) ){
            valor -= 32;
        }

        // Os dois vetores tem 36 posições possíveis.
        // Achamos a posição do caractere dado e devolvemos o elemento equivalente do vetor de morse.
        int i = 0;
        while (valor != caracteres[i]){
            i++;
        }
        return morse[i];
    }

    // Irá inserir o novo caractere na árvore de acordo com o seu código morse.
    void inserir(char valor) {
        Node novoNo = raiz;
        char[] morse = tradutor_cm(valor); // Obtém o morse equivalente para o caractere

        // Traversa a árvore até chegar no último caractere do código morse.
        for (int i = 0; i < morse.length; i++) {
           if (morse[i] == '.') novoNo = novoNo.esquerda;
           else if (morse[i] == '-') novoNo = novoNo.direita;
        }

        novoNo.valor = valor;
    }

    // Busca os caracteres a partir de um código morse.
    char[] buscar(String morse_in){
        char[] morse = convString(morse_in);
        int espacos = 0;

        // Contando a quantidade de espaços para saber quantas letras existem no morse.
        for (int i = 0; i < morse.length; i++) {
            if (morse[i] == ' ') espacos++;
        }
        char[] caracteres = new char[espacos + 1];

        // Agora sim, a busca.
        Node noAtual = raiz;
        int cont = 0;

        // Repetir para cada caractere
        for (int i = 0; i < (espacos + 1); i++) {

            // Lê o código e percorre a árvore de acordo.
            while (morse[cont] != ' ') {
                if (morse[cont] == '.') noAtual = noAtual.esquerda;
                else if (morse[cont] == '-') noAtual = noAtual.direita;

                cont++;
                if (cont >= morse.length) break;
            }
            caracteres[i] = noAtual.valor;

            noAtual = raiz; cont++;
        }

        return caracteres;
    }

    // Método auxiliar que transforma String em vetor de char.
    char[] convString(String string){
        int cont = 0;
        for (int i = 0; i < string.length(); i++) cont++;
        char[] caracteres = new char[cont];

        for (int i = 0; i < string.length(); i++) {
            caracteres[i] = string.charAt(i);
        }

        return caracteres;
    }

    // Desenha a árvore.
    void desenhar(Node node, int nivel) {
        if (node == null) return;
        desenhar(node.direita, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print("    ");
        System.out.println(node.valor);
        desenhar(node.esquerda, nivel + 1);
    }

    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        System.out.println("Árvore a partir do construtor:\n\n");
        arvore.desenhar(arvore.raiz, 0);

        System.out.println("Inserindo os caracteres A-Z, 0-9...");
        // Inserindo caracteres A-Z
        for (char i = 65; i <= 90; i++) {
            arvore.inserir(i);
        }
        // Inserindo caracteres 0-9
        for (char i = 48; i <= 57; i++) {
            arvore.inserir(i);
        }

        System.out.println("Árvore Desenhada:\n\n");
        arvore.desenhar(arvore.raiz, 0);

        // As strings devem ter suas letras separadas por espaços.
        String teste = "... --- ...";
        String todo_morse= ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- " +
                "-. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. " +
                "----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";


        System.out.println(arvore.buscar(teste));
        System.out.println(arvore.buscar(todo_morse));
    }

}

