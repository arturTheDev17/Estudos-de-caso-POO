public abstract class Forma {

    private static int geradorCodigo = 1;
    private int codigo;

    public Forma() {
        this.codigo = geradorCodigo;
        geradorCodigo++;
    }

    public abstract double area();

    public abstract double perimetro();

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "\nÁrea: " + area() +
                "\nPerímetro: " + perimetro() +
                "\nCódigo: " + this.codigo;
    }
}
