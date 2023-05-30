import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Pedido {
    private int codigo; 
    private Proveedor proveedor;
    private Producto producto;
    private int cantidad; 
    private String fecha; 
    private String estado; 

    public Pedido(int codigo, Proveedor proveedor, Producto producto, int cantidad, String estado){ 
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = setFecha();
        this.estado = estado;
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
    public String getEstado(){
        return this.estado;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }
    public void setProducto(Producto producto){
        this.producto = producto;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public String setFecha(){
        LocalDateTime tiempo = LocalDateTime.now();
        return tiempo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

