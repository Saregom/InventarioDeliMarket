// package Gestor;

import java.util.ArrayList;

/* 
 * Cambiar todos los metodos para los proveedores
 * 
 * 
 */

public class ControlProveedores extends Control{
    private ArrayList<Proveedor> listaProveedores;

    public ControlProveedores(){
        this.listaProveedores = bdd.getProveedores();
    }

    public ArrayList<Proveedor> obtenerProveedores(){
        return this.listaProveedores;
    }

    // public void agregarProdcuto(Producto producto){
    //     producto.setCodigo(this.listaProveedores.size()+1);
    //     this.listaProveedores.add(producto);
    // }

    // public void actualizarProdcuto(Producto producto){
    //     for(Producto prod : this.listaProveedores){
    //         if(prod.getCodigo() == producto.getCodigo()){
    //             prod.setNombre(producto.getNombre());
    //             prod.setPrecio(producto.getPrecio());
    //             prod.setCantidad(producto.getCantidad());
    //         }
    //     }
    // }

    // public void eliminarProdcuto(int codigo){
    //     for(Producto prod : this.listaProveedores){
    //         if(prod.getCodigo() == codigo){
    //             this.listaProveedores.remove(prod);
    //             break;
    //         }
    //     }
    // }

    // public boolean existeProdcuto(int codigo, String nombre){
    //     for(Producto prod : this.listaProveedores){
    //         if(!nombre.equals("")){
    //             if(prod.getNombre().equals(nombre)){
    //                 return true;
    //             }
    //         }else if(prod.getCodigo() == codigo){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
