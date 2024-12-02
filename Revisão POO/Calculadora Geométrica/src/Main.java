import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Usuario professor = new Usuario("professor", "admin123");
    private static final ArrayList<Forma> FORMAS = new ArrayList<Forma>();

    public static void main(String[] args) {

        addForma(new Circulo(Math.PI));
        addForma(new Quadrado(4));
        addForma(new Retangulo(5, 6));
        addForma(new Isosceles(3, 4, 4));
        addForma(new Equilatero(5, 5, 5));
        addForma(new Escaleno(6, 8, 10));

        Scanner sc = new Scanner(System.in);
        boolean logado = false , inicializacao = true;
        byte erros = 0;
        String senha;

        while ( true ) {
            if (!logado  ) {
                if ( !inicializacao ) {
                    System.out.println("Deseja fechar a aplicação? Digite 's' para sim");
                    if (sc.next().charAt(0) == 's') {
                        System.exit(0);
                    }
                    sc.nextLine();
                }
                inicializacao = false;

                while (!logado) {
                    System.out.println("Nome de usuário: " + professor.getLogin());
                    System.out.print("Insira sua senha: ");
                    senha = sc.nextLine();

                    if (professor.checkSenha(senha)) {
                        logado = true;
                    } else {
                        System.out.println("ERRO. SENHA INVÁLIDA.");
                        erros++;
                    }
                    if (erros == 3) {
                        System.out.println("Tentativas de login excedidas. Fechando a aplicação...");
                        System.exit(0);
                    }
                }
            } else {
                byte escolha;
                while (logado) {
                    System.out.println("\n -------------- CALCULADORA GEOMÉTRICA -------------- ");
                    System.out.println(" 1. Cadastrar uma forma     2. Ver formas cadastradas ");
                    System.out.println(" 3. Remover uma forma       4. Trocar nome de usuário ");
                    System.out.println(" 0. Fazer Logout");
                    System.out.println(" ---------------------------------------------------- ");
                    System.out.print("Escolha uma opção: ");
                    while (true) {
                        try {
                            escolha = sc.nextByte();
                            break;
                        } catch (InputMismatchException i) {
                            System.out.println("ERRO. VALOR INVÁLIDO. DIGITE NOVAMENTE");
                            sc.next();
                        }
                    }
                    switch (escolha) {
                        case 1: {
                            byte escolhaCadastro = 1;
                            while ( escolhaCadastro != 0 ) {
                                System.out.println(" ------------------ CADASTRAR FORMA ----------------- ");
                                System.out.println(" 1. Cadastrar Círculo     2. Cadastrar Quadrado ");
                                System.out.println(" 3. Cadastrar Retângulo   4. Cadastrar Triângulo ");
                                System.out.println(" 0. Voltar");
                                System.out.println(" ---------------------------------------------------- ");
                                System.out.print("Escolha uma opção: ");
                                while (true) {
                                    try {
                                        escolhaCadastro = sc.nextByte();
                                        break;
                                    } catch (InputMismatchException i) {
                                        System.out.println("ERRO. VALOR INVÁLIDO. DIGITE NOVAMENTE");
                                        sc.next();
                                    }
                                }
                                sc.nextLine();
                                switch (escolhaCadastro) {
                                    case 1: {
                                        System.out.println("Insira o valor do raio do círculo: ");
                                        double raio;
                                        while (true) {
                                            try {
                                                raio = sc.nextDouble();
                                                break;
                                            } catch (InputMismatchException i) {
                                                System.out.println("ERRO. VALOR INVÁLIDO. DIGITE NOVAMENTE");
                                                sc.next();
                                            }
                                        }
                                        if (raio > 0) {
                                            addForma(new Circulo(raio));
                                        } else {
                                            System.out.println("ERRO. VALOR INVÁLIDO");
                                        }
                                    }
                                    break;

                                    case 2: {
                                        double lado;
                                        System.out.println("Insira o valor do lado do quadrado: ");
                                        while (true) {
                                            try {
                                                lado = sc.nextDouble();
                                                break;
                                            } catch (InputMismatchException i) {
                                                System.out.println("ERRO. VALOR INVÁLIDO. DIGITE NOVAMENTE");
                                                sc.next();
                                            }
                                        }

                                        if (lado > 0) {
                                            addForma(new Quadrado(lado));
                                        } else {
                                            System.out.println("ERRO. VALOR INVÁLIDO");
                                        }
                                    }
                                    break;

                                    case 3: {
                                        double base, altura;
                                        while (true) {
                                            try {
                                                System.out.print("Insira o valor da base do retângulo: ");
                                                base = sc.nextDouble();
                                                System.out.print("Insira o valor da altura do retângulo: ");
                                                altura = sc.nextDouble();
                                                break;
                                            } catch (InputMismatchException i) {
                                                System.out.println("ERRO. VALOR(ES) INVÁLIDO(S)");
                                                sc.next();
                                            }
                                        }

                                        if (base > 0 && altura > 0 && base != altura) {
                                            addForma(new Retangulo(base, altura));
                                        } else {
                                            System.out.println("ERRO. VALOR(ES) IGUAIS OU INVÁLIDO(S)");
                                        }
                                    }
                                    break;

                                    case 4: {
                                        double lado1, lado2, lado3;

                                        while (true) {
                                            try {
                                                System.out.print("Insira o valor de um lado do triângulo: ");
                                                lado1 = sc.nextDouble();
                                                System.out.print("Insira o valor de outro lado do triângulo: ");
                                                lado2 = sc.nextDouble();
                                                System.out.print("Insira o valor de mais um lado do triângulo: ");
                                                lado3 = sc.nextDouble();
                                                break;
                                            } catch (InputMismatchException i) {
                                                System.out.println("ERRO. VALOR(ES) INVÁLIDO(S)");
                                                sc.next();
                                            }
                                        }

                                        if ((lado1 > 0 && lado2 > 0 && lado3 > 0) && (lado1 + lado2 > lado3 && lado3 + lado2 > lado1 && lado1 + lado3 > lado2)) {
                                            Triangulo triangulo = descobrirTipo(lado1, lado2, lado3);
                                            if (triangulo != null) {
                                                addForma(triangulo);
                                            } else {
                                                System.out.println("ERRO. VALOR(ES) INVÁLIDO(S)");
                                            }

                                        } else {
                                            System.out.println("ERRO. VALOR(ES) INVÁLIDO(S)");
                                        }

                                    }
                                    break;

                                    default:
                                        System.out.println("Valor de escolha inválido");
                                }
                            }
                        }
                        break;

                        case 2: {
                            byte escolhaView = 1;
                            while ( escolhaView != 0 ) {
                                System.out.println(" ----------------- VISUALIZAR FORMAS ---------------- ");
                                System.out.println(" 1. Ver Círculos           2. Ver Quadrados ");
                                System.out.println(" 3. Ver Retângulos         4. Ver Triângulos ");
                                System.out.println(" 5. Ver Todas as formas    0. Voltar");
                                System.out.println(" ---------------------------------------------------- ");
                                System.out.print("Escolha uma opção: ");
                                while (true) {
                                    try {
                                        escolhaView = sc.nextByte();
                                        break;
                                    } catch (InputMismatchException i) {
                                        System.out.println("ERRO. VALOR INVÁLIDO. DIGITE NOVAMENTE");
                                        sc.next();
                                    }
                                }
                                switch (escolhaView) {
                                    case 1: {
                                        for (Forma forma : FORMAS) {
                                            if (forma instanceof Circulo) {
                                                System.out.println(forma);
                                            }
                                        }

                                    }
                                    break;

                                    case 2: {
                                        for (Forma forma : FORMAS) {
                                            if (forma instanceof Quadrado) {
                                                System.out.println(forma);
                                            }
                                        }

                                    }
                                    break;

                                    case 3: {
                                        for (Forma forma : FORMAS) {
                                            if (forma instanceof Retangulo) {
                                                System.out.println(forma);
                                            }
                                        }
                                    }
                                    break;

                                    case 4: {
                                        for (Forma forma : FORMAS) {
                                            if (forma instanceof Triangulo) {
                                                System.out.println(forma);
                                            }
                                        }
                                    }
                                    break;

                                    case 5: {
                                        for (Forma forma : FORMAS) {
                                            System.out.println(forma);
                                        }
                                    }
                                    break;

                                    case 0 : {
                                        escolha = 0;
                                    } break;

                                    default:
                                        System.out.println("Valor de escolha inválido");
                                }

                            }

                        }
                        break;

                        case 3: {
                            System.out.print("Insira o código da forma que deseja remover: ");
                            int num;
                            while (true) {
                                try {
                                    num = sc.nextInt();
                                    break;
                                } catch (InputMismatchException i) {
                                    System.out.println("ERRO. VALOR INVÁLIDO. DIGITE NOVAMENTE");
                                    sc.next();
                                }
                            }
                            if (!removeForma( num )) {
                                System.out.println("ERRO. ESTE CÓDIGO NÃO EXISTE.");
                            }
                        }
                        break;

                        case 4: {
                            sc.nextLine();
                            System.out.print("Insira o seu novo login: ");
                            String novoLogin = sc.nextLine();
                            do {
                                System.out.print("Insira sua senha: ");
                                senha = sc.nextLine();

                                if (professor.checkSenha(senha)) {
                                    professor.setLogin(novoLogin, senha);
                                } else {
                                    System.out.println("ERRO. SENHA INVÁLIDA.");
                                    erros++;
                                }
                                if (erros == 3) {
                                    break;
                                }
                            } while (!professor.checkSenha(senha));
                        }
                        break;

                        case 0: {

                            sc.nextLine();
                            System.out.print("Para fazer logout, insira sua senha: ");
                            if (professor.checkSenha(sc.nextLine())) {
                                System.out.println("FAZENDO LOGOUT...");
                                logado = false;
                            } else {
                                System.out.println("ERRO. SENHA INVÁLIDA.");
                            }

                        }
                        break;

                        default:
                            System.out.println("Valor de escolha inválido");
                    }
                }
            }

        }
    }

    public static Forma getForma(int i) {
        return FORMAS.get(i);
    }

    public static void addForma(Forma forma) {
        FORMAS.add(forma);
    }

    public static boolean removeForma(int i) {

        for ( Forma forma : FORMAS ) {
            if ( forma.getCodigo() == i ) {
                FORMAS.remove( i - 1 );
                return true;
            }
        }
            return false;
    }

    public static Triangulo descobrirTipo(double lado1, double lado2, double lado3) {
        if (lado1 == lado2 && lado2 == lado3) {
            return new Equilatero(lado1, lado2, lado3);

        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {

            Isosceles iso = null;
            if (lado2 == lado3) {
                iso = new Isosceles(lado1, lado2, lado3);

            } else if (lado1 == lado3) {
                iso = new Isosceles(lado2, lado1, lado3);

            } else if (lado1 == lado2) {
                iso = new Isosceles(lado3, lado2, lado1);

            }
            return iso;

        } else {
            return new Escaleno(lado1, lado2, lado3);

        }
    }

}
