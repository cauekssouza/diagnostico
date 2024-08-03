// Bibliotecas para GUI (INterface)
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;




// Classe Carro com encapsulamento
class Carro {
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private String cor;

    public Carro(String marca, String modelo, int anoFabricacao, int anoModelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.cor = cor;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return String.format("Marca: %s, Modelo: %s, Ano de Fabricação: %d, Ano do Modelo: %d, Cor: %s",
                marca, modelo, anoFabricacao, anoModelo, cor);
    }
}

// Interface ou Classe Abstrata para Lavagem
abstract class Lavar {
    public abstract void lavar(Carro carro);
    public abstract double getPreco();
}

// Implementação das Lavagens
class Simples extends Lavar {
    @Override
    public void lavar(Carro carro) {
        JOptionPane.showMessageDialog(null, "Lavagem Simples realizada no carro " + carro.getMarca() + " " + carro.getModelo());
    }

    @Override
    public double getPreco() {
        return 20.0;
    }
}

class Completa extends Lavar {
    @Override
    public void lavar(Carro carro) {
        JOptionPane.showMessageDialog(null, "Lavagem Completa realizada no carro " + carro.getMarca() + " " + carro.getModelo());
    }

    @Override
    public double getPreco() {
        return 35.0;
    }
}

class Premium extends Lavar {
    @Override
    public void lavar(Carro carro) {
        JOptionPane.showMessageDialog(null, "Lavagem Premium realizada no carro " + carro.getMarca() + " " + carro.getModelo());
    }

    @Override
    public double getPreco() {
        return 50.0;
    }
}

// Classe principal com GUI
public class Gui {
    private static Carro meuCarro;
    private static List<String> historicoLavagens = new ArrayList<>();
    private static double totalGasto = 0.0;

    public static void main(String[] args) {
        // Criando a janela principal
        JFrame frame = new JFrame("Gestão de Lavagem de Carro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Painel para entrada de dados do carro
        JPanel painelCarro = new JPanel(new GridLayout(6, 2));
        painelCarro.add(new JLabel("Marca:"));
        JTextField txtMarca = new JTextField();
        painelCarro.add(txtMarca);

        painelCarro.add(new JLabel("Modelo:"));
        JTextField txtModelo = new JTextField();
        painelCarro.add(txtModelo);

        painelCarro.add(new JLabel("Ano de Fabricação:"));
        JTextField txtAnoFabricacao = new JTextField();
        painelCarro.add(txtAnoFabricacao);

        painelCarro.add(new JLabel("Ano do Modelo:"));
        JTextField txtAnoModelo = new JTextField();
        painelCarro.add(txtAnoModelo);

        painelCarro.add(new JLabel("Cor:"));
        JTextField txtCor = new JTextField();
        painelCarro.add(txtCor);

        JButton btnAtualizarCarro = new JButton("Atualizar Carro");
        painelCarro.add(btnAtualizarCarro);

        frame.add(painelCarro, BorderLayout.NORTH);

        
        // Painel para botões de lavagem
        JPanel painelBotoes = new JPanel(new GridLayout(4, 1));

        JButton btnSimples = new JButton("Lavagem Simples");
        JButton btnCompleta = new JButton("Lavagem Completa");
        JButton btnPremium = new JButton("Lavagem Premium");
        JButton btnHistorico = new JButton("Ver Histórico de Lavagens");

        painelBotoes.add(btnSimples);
        painelBotoes.add(btnCompleta);
        painelBotoes.add(btnPremium);
        painelBotoes.add(btnHistorico);

        frame.add(painelBotoes, BorderLayout.CENTER);

        // Adicionando ações aos botões de lavagem
        btnAtualizarCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String marca = txtMarca.getText();
                    String modelo = txtModelo.getText();
                    int anoFabricacao = Integer.parseInt(txtAnoFabricacao.getText());
                    int anoModelo = Integer.parseInt(txtAnoModelo.getText());
                    String cor = txtCor.getText();

                    meuCarro = new Carro(marca, modelo, anoFabricacao, anoModelo, cor);
                    JOptionPane.showMessageDialog(null, "Carro atualizado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos.");
                }
            }
        });

        btnSimples.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (meuCarro == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, atualize as informações do carro primeiro.");
                    return;
                }
                Lavar lavagemSimples = new Simples();
                realizarLavagem(meuCarro, lavagemSimples);
            }
        });

        btnCompleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (meuCarro == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, atualize as informações do carro primeiro.");
                    return;
                }
                Lavar lavagemCompleta = new Completa();
                realizarLavagem(meuCarro, lavagemCompleta);
            }
        });

        btnPremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (meuCarro == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, atualize as informações do carro primeiro.");
                    return;
                }
                Lavar lavagemPremium = new Premium();
                realizarLavagem(meuCarro, lavagemPremium);
            }
        });

        btnHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder historico = new StringBuilder("Histórico de Lavagens:\n");
                for (String registro : historicoLavagens) {
                    historico.append(registro).append("\n");
                }
                historico.append("\nTotal Gasto: R$ ").append(String.format("%.2f", totalGasto));
                JOptionPane.showMessageDialog(null, historico.toString());
            }
        });

        // Exibindo a janela
        frame.setVisible(true);
    }

    // Método para realizar a lavagem, demonstrando polimorfismo
    public static void realizarLavagem(Carro carro, Lavar tipoLavagem) {
        tipoLavagem.lavar(carro);
        historicoLavagens.add(tipoLavagem.getClass().getSimpleName() + " - R$ " + tipoLavagem.getPreco());
        totalGasto += tipoLavagem.getPreco();
    }
}
