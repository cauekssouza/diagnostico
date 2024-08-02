public class Completa implements Lavar{
    @Override
    public void lavar(Carro carro){
        System.out.println("\nA lavagem completa foi iniciada no " + carro.getModelo());
        System.out.println("\nEste Carro" + carro.getCor() + "\nfoi fabricado em" + carro.getAnoFabricacao());
        System.out.println("\nfoi comprado " + carro.getAnoCompra());
    }
}
