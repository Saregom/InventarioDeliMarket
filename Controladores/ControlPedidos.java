import java.util.ArrayList;

public class ControlPedidos extends Control{
    private ArrayList<Pedido> listaPedidos;

    public ControlPedidos(){
        this.listaPedidos = bdd.getPedidos();
    }

    public ArrayList<Pedido> obtenerPedidos(){
        return this.listaPedidos;
    }

    public void hacerPedido(Pedido pedido){
        pedido.setCodigo(this.listaPedidos.size()+1);
        this.listaPedidos.add(pedido);
    }

    public void cancelarPedido(int codigo){
        for(Pedido ped : this.listaPedidos){
            if(ped.getCodigo() == codigo){
                this.listaPedidos.remove(ped);
                break;
            }
        }
    }

    public boolean existePedido(int codigo){
        for(Pedido ped : this.listaPedidos){
            if(ped.getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }
}
