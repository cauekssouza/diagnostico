public class Carro {
    // Atributos
    private String marca;
    private String modelo;
    private int anoDeFabricaçao;
    private int anoCompra;
    private String cor;

    // Construtor
    public Carro(String marca, String modelo, int anoDeFabricaçao, int anoCompra, String cor){
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricaçao = anoDeFabricaçao;
        this.anoCompra = anoCompra;
        this.cor = cor;
    }

    /*Getters e Setters*/
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public int getAnoFabricacao(){
        return anoDeFabricaçao;
    }

    public void setAnoFabricacao(int anoDeFabricaçao){
        this.anoDeFabricaçao = anoDeFabricaçao;
    }

    public int getAnoCompra(){
        return anoCompra;
    }

    public void setAnoCompra(int anoCompra){
        this.anoCompra = anoCompra;
    }
    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
}
