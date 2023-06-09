import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class InfoProducto {
    private Producto producto;
    private String fecha; 
    private String operacion; 
    
    public InfoProducto(Producto producto, String operacion){ 
        this.producto = producto;
        this.fecha = setFecha();
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
    public String setFecha(){
        LocalDateTime tiempo = LocalDateTime.now();
        return tiempo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
