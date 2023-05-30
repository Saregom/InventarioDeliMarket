// package Entidades;
class Pedido {
    private int codigo; 
    private Proveedor proveedor;
    private Producto producto;
    private int cantidad; 
    private String fecha; 
    
    public Pedido(int codigo, Proveedor proveedor, Producto producto, int cantidad){ 
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = "1/1/1";
    }

    public int getCodigo(){
        return this.codigo;
    }
    public Proveedor getProveedor(){
        return this.proveedor;
    }
    public Producto getProducto(){
        return this.producto;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public String getFecha(){
        return this.fecha;
    }
}

