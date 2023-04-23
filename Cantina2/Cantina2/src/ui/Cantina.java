package ui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;
import dominio.Ingrediente;
import dominio.Massa;
import dominio.Pedido; 

public class Cantina {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog(null, "Informe o nome do cliente: ", "Nome do cliente", JOptionPane.PLAIN_MESSAGE);
        String massa = JOptionPane.showInputDialog(null, "Informe o nome da massa: ", "Nome da massa", JOptionPane.PLAIN_MESSAGE);
        Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor da massa: ", "Valor da massa", JOptionPane.PLAIN_MESSAGE));

        Cliente c = new Cliente();
        c.setNome(nome);

        Massa m = new Massa();
        m.setTipo(massa);
        m.setValor(valor);

        List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
        int opcao = 0;
        Ingrediente i;

        while(opcao != 5){
            String opcoes = JOptionPane.showInputDialog(null, "Informe os ingredientes escolhidos: \n1- Bacon \n2- Mussarela \n3- Tomate \n4- Queijo \n5- Sair", "Informe os ingredientes", JOptionPane.PLAIN_MESSAGE);
            opcao = Integer.parseInt(opcoes);

            switch(opcao){
                case 1:
                    i = new Ingrediente();
                    i.setNomeIngrediente("Bacon");
                    ingredientes.add(i);
                    break;
                case 2:
                    i = new Ingrediente();
                    i.setNomeIngrediente("Mussarela");
                    ingredientes.add(i);
                    break;
                case 3:
                    i = new Ingrediente();
                    i.setNomeIngrediente("Tomate");
                    ingredientes.add(i);
                    break;
                case 4:
                    i = new Ingrediente();
                    i.setNomeIngrediente("Queijo");
                    ingredientes.add(i);
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número inválido", "Valor do pedido", JOptionPane.ERROR_MESSAGE);
            }
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(c);
        pedido.setMassa(m);
        pedido.setIngredientes(ingredientes);

        String mensagem = "Pedido feito para " + pedido.getCliente().getNome() + "!\n" + pedido.getMassa().getTipo() + " com ";

        if(pedido.getIngredientes().size() > 0){
            for(int a = 0; a < pedido.getIngredientes().size(); a++){
                mensagem += pedido.getIngredientes().get(a).getNomeIngrediente();
                if(a < pedido.getIngredientes().size() - 2){
                    mensagem += ", ";
                } else{
                    mensagem += " e ";
                }
            }
        } else {
            mensagem += "nenhum acréscimo e";
        }

        mensagem += "\nValor: R$" + String.format("%.2f", pedido.calcValor());
        JOptionPane.showMessageDialog(null, mensagem, "Valor do pedido", JOptionPane.PLAIN_MESSAGE);
    }
}
