public class Main {
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
