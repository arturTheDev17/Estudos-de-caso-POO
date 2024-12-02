public class Pessoa {
      private String senha;
      private String nome;
      private long cpf;
      private Pet pet;

    public Pessoa(long cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
      }

    public long getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
    public void limparPet() {
        if ( pet != null && pet.getVivo() && pet.getAcordado() ) {
            pet.limpar();
        }
    }
    public void botaPetParaDormir() {
        if ( pet != null && pet.getVivo() ) {
            pet.dormir();
        }
    }
    public void acordarPet() {
        if ( pet != null && pet.getVivo() ) {
            pet.acordar();
        }
    }
    public void darAguaParaPet() {
        if ( pet != null && pet.getVivo() && pet.getAcordado() ) {
            pet.beberAgua();
        }
    }
    public void avaliarPet() {
        if ( pet != null ) {
            System.out.println( pet );
        } else {
            System.out.println( "Sem pet" );
        }
    }
    public void adotarPet(Pet pet) {
        this.pet = pet;
    }
    public void alimentarPet(Alimento alimento) {
        if ( pet != null && pet.getVivo() && pet.getAcordado() ) {
            pet.comer(alimento);
        }
    }
    public void levarPerParaFazerNecessidades() {
        if ( pet != null && pet.getVivo() && pet.getAcordado() ) {
            pet.fazerNecessidades();
        }
    }
    public void brincarComPet(Brincadeira brincadeira ) {
        if ( pet != null && pet.getVivo() && pet.getAcordado() ) {
            pet.brincar(brincadeira);
        }
    }

    @Override
    public String toString() {
        return  "CPF: " + cpf +
                "\nNome: " + nome +
                "\nPet: " + pet.getNome();
    }
}
