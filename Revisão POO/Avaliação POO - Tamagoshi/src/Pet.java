public class Pet {
    private static int geradorCodigo = 0;
    private int codigo;
    private String nome;
    private boolean vivo = true;
    private boolean acordado = true;
    private int sede = 50;
    private int fome = 50;
    private int energia = 50;
    private int diversao = 50;
    private int higiene = 50;
    private int vontadeBanheiro = 50;

    Pet( String nome ) {
        codigo = geradorCodigo;
        geradorCodigo++;
        this.nome = nome;
    }

    public boolean getVivo () {
        return vivo;
    }

    public boolean getAcordado () {
        return acordado;
    }

   public void beberAgua() {
        if (this.sede + 50 < 100 ) {
            this.sede += 50;
        } else {
            this.sede = 100;
        }
        if ( this.vontadeBanheiro - 25 > 0 ) {
            this.vontadeBanheiro -= 25;
        } else {
            this.higiene = 0;
            this.vontadeBanheiro = 100;
        }
   }

   public void comer(Alimento alimento) {
       if ( this.fome + alimento.getNutricao() < 100 ) {
           this.fome += alimento.getNutricao();
       } else {
           this.fome = 100;
       }

       if ( this.vontadeBanheiro - ( alimento.getNutricao() / 2 ) > 0 ) {
           this.vontadeBanheiro -= ( alimento.getNutricao() / 2 );
       } else {
           this.higiene = 0;
           this.vontadeBanheiro = 100;
       }
   }

   public void dormir () {
        if ( this.energia + 25 < 100 ) {
            this.energia += 25;
        } else {
            this.energia = 100;
        }
        this.acordado = false;
   }

    public void acordar () {
        if ( this.energia + 25 < 100 ) {
            this.energia += 25;
        } else {
            this.energia = 100;
        }
        this.acordado = true;
    }

    public void brincar ( Brincadeira brincadeira ) {
       if ( this.diversao + brincadeira.getDivertimento() < 100 ) {
            this.diversao += brincadeira.getDivertimento();
        } else {
            this.diversao = 100;
        }

        if ( this.energia - brincadeira.getCansaco() > 0 ) {
            this.energia -= brincadeira.getCansaco();
        } else {
            this.energia = 0;
        }

        if ( this.fome - brincadeira.getFome() > 0 ) {
            this.fome -= brincadeira.getFome();
        } else {
            this.fome = 0;
        }

        if ( this.sede - brincadeira.getSede() > 0 ) {
            this.sede -= brincadeira.getSede();
        } else {
            this.sede = 0;
        }

        if ( this.higiene - brincadeira.getSujeira() > 0 ) {
            this.higiene -= brincadeira.getSujeira();
        } else {
            this.higiene = 0;
        }

        morrer();

    }

    public void limpar() {
        this.higiene = 100;
    }

    public void fazerNecessidades() {
        this.vontadeBanheiro = 100;
        if ( this.higiene - 25 > 0 ) {
            this.higiene -= 25;
        } else {
            this.higiene = 0;
        }
    }

    public void morrer() {
        if ( this.energia == 0 && this.fome == 0 && this.sede == 0 ) {
            this.vivo = false;
        }
    }

    private String confereEstado ( boolean estado ) {
        if ( estado ) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }


    @Override
    public String toString() {
        return  "Nome: " + nome +
                "\nVivo: " + confereEstado( vivo ) +
                "\nAcordado: " + confereEstado( acordado ) +
                "\nSede: " + sede +
                "\nFome: " + fome +
                "\nEnergia: " + energia +
                "\nDiversão: " + diversao +
                "\nHigiene: " + higiene +
                "\nVontade de ir ao Banheiro: " + vontadeBanheiro;
    }
}
