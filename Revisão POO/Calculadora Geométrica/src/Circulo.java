public class Circulo extends Forma {

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * (raio * raio);
    }

    @Override
    public double perimetro() {
        return Math.PI * (2 * raio);
    }

    @Override
    public String toString() {
        return "\nCirculo: " +
                "\nRaio: " + raio +
                "\nDiâmetro: " + (raio * 2) +
                super.toString();
    }
}
