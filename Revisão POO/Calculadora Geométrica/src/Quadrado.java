public class Quadrado extends Forma {

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return 4 * lado;
    }

    @Override
    public String toString() {
        return "\nQuadrado: " +
                "\nLado: " + lado +
                super.toString();
    }
}
