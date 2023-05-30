import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class InfoProveedor {
    private Proveedor producto;
    private String fecha; 
    private String operacion; 
    
    public InfoProveedor(Proveedor producto, String operacion){ 
        this.producto = producto;
        this.fecha = setFecha();
        this.operacion = operacion;
    }

    public Proveedor getProveedor(){
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
