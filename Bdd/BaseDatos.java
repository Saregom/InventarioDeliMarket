import java.util.ArrayList;

public class BaseDatos{
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private ArrayList<Proveedor> listaProveedores = new ArrayList<>();
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private ArrayList<InfoProducto> listaInfoProductos = new ArrayList<>();
    private ArrayList<InfoProveedor> listaInfoProveedores = new ArrayList<>();
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    
    public BaseDatos(){
        setProductos();
        setProveedores();
        setPedidos();
        setEmpleados();
    }

    public void setProductos(){
        this.listaProductos.add(new Producto(1, "Manzanas", 1000, 55));
        this.listaProductos.add(new Producto(2, "Limones", 2300, 15));
        this.listaProductos.add(new Producto(3, "Peras", 2500, 38));
        this.listaProductos.add(new Producto(4, "Arandanos", 9300, 10));
        this.listaProductos.add(new Producto(5, "Tomates", 2100, 42));
        this.listaProductos.add(new Producto(6, "Queso", 4100, 30));
        this.listaProductos.add(new Producto(7, "Leche", 5000, 20));
        this.listaProductos.add(new Producto(8, "Galletas", 500, 100));
        this.listaProductos.add(new Producto(9, "Chocolates", 3500, 50));
        this.listaProductos.add(new Producto(10, "Mani", 1000, 20));
        
        this.listaInfoProductos.add(new InfoProducto(listaProductos.get(7), "Agregado"));
        this.listaInfoProductos.add(new InfoProducto(listaProductos.get(8), "Agregado"));
        this.listaInfoProductos.add(new InfoProducto(listaProductos.get(9), "Agregado"));
    }

    public void setProveedores(){
        this.listaProveedores.add(new Proveedor(1, "Pedro", "Frutas", 304107683));
        this.listaProveedores.add(new Proveedor(2, "Juan", "Lacteos", 317083596));
        this.listaProveedores.add(new Proveedor(2, "Andres", "Snacks", 320798568));
        
        this.listaInfoProveedores.add(new InfoProveedor(listaProveedores.get(2), "Agregado"));
    }

    public void setPedidos(){
        this.listaPedidos.add(new Pedido(1, listaProveedores.get(2), listaProductos.get(8), 50, "Entregado"));
        this.listaPedidos.add(new Pedido(1, listaProveedores.get(2), listaProductos.get(9), 20, "Entregado"));
    }

    public void setEmpleados(){
        this.listaEmpleados.add(new Empleado("34232554", "Daniel", "admin123454"));
        this.listaEmpleados.add(new Empleado("34265634", "Santiago", "admin12334"));
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
    public ArrayList<InfoProveedor> getInfoProveedores(){
        return this.listaInfoProveedores;
    }
  
    public ArrayList<Empleado> getEmpleados(){
        return this.listaEmpleados;
    }
}
