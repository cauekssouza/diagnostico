public class Premium implements Lavar{
    @Override
    public void lavar(Carro carro){
        System.out.println("\nLavagem premium \niniciada para o carro: " + carro.getModelo());
        System.out.println("nCarro lavado com sucesso, obrigado pela compressão");
    }
}
