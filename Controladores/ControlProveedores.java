import java.util.ArrayList;

public class ControlProveedores extends Control{
    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<InfoProveedor> listaInfoProveedores;

    public ControlProveedores(){
        this.listaProveedores = bdd.getProveedores();
        this.listaInfoProveedores = bdd.getInfoProveedores();
    }

    public ArrayList<Proveedor> obtenerProveedores(){
        return this.listaProveedores;
    }

    public Proveedor obtenerProveedor(String nombre){
        for(Proveedor prod : this.listaProveedores){
            if(prod.getNombre().equals(nombre)){
                return prod;
            }
        }
        return new Proveedor(0, "", "", 0);
    }

     public void agregarProveedor(Proveedor proveedor){
         proveedor.setCodigo(this.listaProveedores.size()+1);
         this.listaProveedores.add(proveedor);
     }

     public void actualizarProveedor(Proveedor producto){
         for(Proveedor prod : this.listaProveedores){
             if(prod.getCodigo() == producto.getCodigo()){
                 prod.setNombre(producto.getNombre());
                 prod.setCategoria(producto.getCategoria());
                 prod.setContacto(producto.getContacto());
             }
         }
     }

     public void eliminarProveedor(int codigo){
         for(Proveedor prod : this.listaProveedores){
             if(prod.getCodigo() == codigo){
                 this.listaProveedores.remove(prod);
                 break;
             }
         }
     }

     public boolean existeProveedor(int codigo, String categoria){
         for(Proveedor prod : this.listaProveedores){
             if(!categoria.equals("")){
                 if(prod.getCategoria().equals(categoria)){
                     return true;
                 }
             }else if(prod.getCodigo() == codigo){
                 return true;
             }
         }
         return false;
     }

     public boolean existeNombreProveedor(String nombre){
        for(Proveedor prod : this.listaProveedores){
            if(prod.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }

      public ArrayList<InfoProveedor> obtenerInfoProveedor(){
          return this.listaInfoProveedores;
      }
  
      public void agregarInfoProveedor(InfoProveedor infoProducto){
          this.listaInfoProveedores.add(infoProducto);
      }
}