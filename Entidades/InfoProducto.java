// package Entidades;

class InfoProducto {
    private Producto producto;
    private String fecha; 
    private String operacion; 
    
    public InfoProducto(Producto producto, String operacion){ 
        this.producto = producto;
        this.fecha = "1/1/1";
        this.operacion = operacion;
    }

    public Producto getProducto(){
        return this.producto;
    }
    public String getFecha(){
        return this.fecha;
    }
    public String getOperacion(){
        return this.operacion;
    }
}
