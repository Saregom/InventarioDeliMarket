// package BDD;

import java.util.ArrayList;
// import Entidades.Producto;

public class BaseDatos{
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private ArrayList<Proveedor> listaProveedores = new ArrayList<>();
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private ArrayList<InfoProducto> listaInfoProductos = new ArrayList<>();
    
    public BaseDatos(){
        setProductos();
        setProveedores();
        setPedidos();
    }

    public void setProductos(){
        this.listaProductos.add(new Producto(1, "Manzanas", 8000, 550));
        this.listaProductos.add(new Producto(2, "Limones", 2300, 15));
        this.listaProductos.add(new Producto(3, "Peras", 2500, 38));
        this.listaProductos.add(new Producto(4, "Arandanos", 9300, 55));
        this.listaProductos.add(new Producto(5, "Tomates", 2100, 42));
        this.listaProductos.add(new Producto(6, "Fresas", 4100, 33));
        this.listaProductos.add(new Producto(7, "Helado", 4500, 41));
        this.listaProductos.add(new Producto(8, "Galletas", 500, 833));
        this.listaProductos.add(new Producto(9, "Chocolates", 3500, 806));
        this.listaProductos.add(new Producto(10, "Jamon", 17000, 10));
        
        this.listaInfoProductos.add(new InfoProducto(listaProductos.get(9), "Agregado"));
    }

    public void setProveedores(){
        this.listaProveedores.add(new Proveedor(1, "Pedro", "Frutas", 1234567891));
        this.listaProveedores.add(new Proveedor(2, "Juan", "Lacteos", 1234567891));
    }

    public void setPedidos(){
        this.listaPedidos.add(new Pedido(1, listaProveedores.get(0), listaProductos.get(0), 550));
    }

    public ArrayList<Producto> getProductos(){
        return this.listaProductos;
    }

    public ArrayList<Proveedor> getProveedores(){
        return this.listaProveedores;
    }

    public ArrayList<Pedido> getPedidos(){
        return this.listaPedidos;
    }

    public ArrayList<InfoProducto> getInfoProductos(){
        return this.listaInfoProductos;
    }
}
