public class Alimento {
    private static int geradorCodigo = 0;
    private int codigo;
    private String nome;
    private int nutricao;

    public Alimento( String nome , int nutricao ) {
        codigo = geradorCodigo;
        geradorCodigo++;
        this.nome = nome;
        this.nutricao = nutricao;
    }

    public String getNome() {
        return nome;
    }

    public int getNutricao() {
        return nutricao;
    }

    public int getCodigo() {
        return codigo;
    }
}
