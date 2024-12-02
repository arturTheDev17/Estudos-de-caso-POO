public class Equilatero extends Triangulo {

    public Equilatero(double lado1, double lado2, double lado3) {
        super(lado1, lado2, lado3);
    }

    @Override
    public double area() {
        return (Math.sqrt(3) / 4) * (getLado1() * getLado1());
    }

    @Override
    public String toString() {
        return "\nTriângulo Equilátero: " +
                "\nLado 1: " + getLado1() +
                "\nLado 2: " + getLado2() +
                "\nLado 3: " + getLado3() +
                super.toString();
    }
}
