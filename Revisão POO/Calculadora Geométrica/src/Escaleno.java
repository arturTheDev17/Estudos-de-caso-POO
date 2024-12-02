public class Escaleno extends Triangulo {
    public Escaleno(double lado1, double lado2, double lado3) {
        super(lado1, lado2, lado3);
    }

    @Override
    public double area() {
        double semiPerimetro = perimetro() / 2;
        return Math.sqrt(semiPerimetro * (semiPerimetro - getLado1()) * (semiPerimetro - getLado2()) * (semiPerimetro - getLado3()));
    }

    @Override
    public String toString() {
        return "\nTriângulo Escaleno: " +
                "\nLado 1: " + getLado1() +
                "\nLado 2: " + getLado2() +
                "\nLado 3: " + getLado3() +
                super.toString();
    }

}
