import java.util.ArrayList;

public class Banco {
    private static final ArrayList<Alimento> alimentos = new ArrayList<Alimento>();

    private static final ArrayList<Brincadeira> brincadeiras  = new ArrayList<Brincadeira>();

    private static final ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    private static final ArrayList<Pet> pets = new ArrayList<Pet>();

    public void cadastrarPet( Pet pet ) {
        pets.add( pet );
    }
    public void removerPet( Pet pet ) {
        pets.remove( pet );
    }

    public void cadastrarPessoa(Pessoa pessoa ) {
        pessoas.add( pessoa );
    }
    public void removerPessoa(Pessoa pessoa ) {
        pessoas.remove( pessoa );
    }

    public void cadastrarBrincadeira (Brincadeira brincadeira ) {
        brincadeiras.add( brincadeira );
    }
    public void removerBrincadeira (Brincadeira brincadeira ) {
        brincadeiras.remove( brincadeira );
    }

    public void cadastrarAlimento (Alimento alimento ) {
        alimentos.add( alimento );
    }
    public void removerAlimento (Alimento alimento ) {
        alimentos.remove( alimento );
    }

    public Alimento procurarAlimento ( int codAlimento ) {
        for ( Alimento alimento : alimentos ) {
            if ( alimento.getCodigo() == codAlimento ) {
                return alimento;
            }
        }
        return null;
    }

    public Brincadeira procurarBrincadeira ( int codBrincadeira ) {
        for ( Brincadeira brincadeira : brincadeiras ) {
            if ( brincadeira.getCodigo() == codBrincadeira ) {
                return brincadeira;
            }
        }
        return null;
    }

    public Pet procurarPet ( int codPet ) {
        for ( Pet pet : pets ) {
            if ( pet.getCodigo() == codPet ) {
                return pet;
            }
        }
        return null;
    }

    public Pessoa procurarPessoa ( long cpf ) {
        for ( Pessoa pessoa : pessoas ) {
            if ( pessoa.getCpf() == cpf ) {
                return pessoa;
            }
        }
        return null;
    }

    public static ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public static ArrayList<Pet> getPets() {
        return pets;
    }

    public static ArrayList<Brincadeira> getBrincadeiras() {
        return brincadeiras;
    }

    public Pessoa login (long cpf, String senha) {
        Pessoa pessoa = procurarPessoa( cpf );
        if ( pessoa != null ) {
            if ( senha.equals( pessoa.getSenha() ) ){
                return pessoa;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
