public class Brincadeira {
    private int geradorCodigo = 0;
    private int codigo;
    private String nome;
    private int cansaco;
    private int fome;
    private int sede;
    private int sujeira;
    private int divertimento;

    public Brincadeira(String nome, int divertimento, int cansaco, int fome, int sede, int sujeira) {
        codigo = geradorCodigo;
        geradorCodigo++;
        this.nome = nome;
        this.divertimento = divertimento;
        this.cansaco = cansaco;
        this.fome = fome;
        this.sede = sede;
        this.sujeira = sujeira;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCansaco() {
        return cansaco;
    }

    public int getFome() {
        return fome;
    }

    public int getSede() {
        return sede;
    }

    public int getSujeira() {
        return sujeira;
    }

    public int getDivertimento() {
        return divertimento;
    }
}
