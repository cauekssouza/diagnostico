public class Simples implements  Lavar{
    @Override
    public void lavar(Carro carro){
        System.out.println("\nLavagem simples iniciada para o carro: " + carro.getModelo() + "\ne de\n" + carro.getCor());
        System.out.println("\nCarro lavado Com Sucesso.");
    }
}
