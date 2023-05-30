import java.util.ArrayList;

public class ControlPedidos extends Control{
    private ArrayList<Pedido> listaPedidos;

    public ControlPedidos(){
        this.listaPedidos = bdd.getPedidos();
    }

    public ArrayList<Pedido> obtenerPedidos(){
        return this.listaPedidos;
    }
}
