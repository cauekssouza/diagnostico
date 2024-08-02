public class Main {
    public static void main(String[] args) {
        Carro meucarro = new Carro("Honda", "Civic", 2020, 2021, "Preto");

        // Lavagens
        Lavar Simples = new Simples();
        Lavar Completa = new Completa();
        Lavar Premium = new Premium();

        // Tipos
        Simples.lavar(meucarro);
        System.out.println();

        Completa.lavar(meucarro);
        System.out.println();

        Premium.lavar(meucarro);
        System.out.println();
    }
}
