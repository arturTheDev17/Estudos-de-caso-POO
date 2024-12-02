public class Isosceles extends Triangulo {

    public Isosceles(double ladoDiferente, double lado2, double lado3) {
        super(ladoDiferente, lado2, lado3);
    }

    @Override
    public double area() {
        return super.getLado1() * (Math.sqrt((getLado2() * getLado3()) - ((getLado1() * getLado1()) / 4)));
    }

    @Override
    public String toString() {
        return "\nTriângulo Isósceles: " +
                "\nLado 1: " + getLado1() +
                "\nLado 2: " + getLado2() +
                "\nLado 3: " + getLado3() +
                super.toString();
    }

}
