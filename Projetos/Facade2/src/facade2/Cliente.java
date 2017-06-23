package facade2;

import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nomeAutor,sobrenome,nomeEditora;
        int ano;
        System.out.println("Nome do autor: ");
        nomeAutor = sc.next();
        System.out.println("sobrenome do autor: ");
        sobrenome = sc.next();
        System.out.println("Nome da editora: ");
        nomeEditora = sc.next();
        System.out.println("Ano de criação da editora: ");
        ano = sc.nextInt();
        Livro l = new Livro();
        l.ShowInfo(nomeAutor, sobrenome, nomeEditora, ano);
    }
    
}
