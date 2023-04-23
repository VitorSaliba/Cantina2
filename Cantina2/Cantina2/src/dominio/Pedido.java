package dominio;

import java.util.List;

public class Pedido {
    Cliente cliente;
    Massa massa;
    private List<Ingrediente> ingredientes;

    public double calcValor(){
        double valorTotal = massa.getValor() + (2 * ingredientes.size());
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Massa getMassa() {
        return massa;
    }

    public void setMassa(Massa massa) {
        this.massa = massa;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
