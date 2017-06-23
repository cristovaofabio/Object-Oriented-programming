package facade2;

public class Livro {
    private Autor a;
    private Editora e;
    public Livro(){
        this.a = new Autor();
        this.e = new Editora();
    }
    public void ShowInfo(String nome, String sobrenome, String nomeEditora, int ano){
        a.Nome(nome, sobrenome);
        e.Info(nomeEditora, ano);
    }
}
