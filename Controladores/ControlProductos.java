// package Gestor;

import java.util.ArrayList;

public class ControlProductos extends Control{
    private ArrayList<Producto> listaProductos;
    private ArrayList<InfoProducto> listaInfoProductos;

    public ControlProductos(){
        this.listaProductos = bdd.getProductos();
        this.listaInfoProductos = bdd.getInfoProductos();
    }
    // --- productos
    public ArrayList<Producto> obtenerProductos(){
        return this.listaProductos;
    }
   
    public void agregarProdcuto(Producto producto){
        producto.setCodigo(this.listaProductos.size()+1);
        this.listaProductos.add(producto);
    }

    public void actualizarProdcuto(Producto producto){
        for(Producto prod : this.listaProductos){
            if(prod.getCodigo() == producto.getCodigo()){
                prod.setNombre(producto.getNombre());
                prod.setPrecio(producto.getPrecio());
                prod.setCantidad(producto.getCantidad());
            }
        }
    }

    public void eliminarProdcuto(int codigo){
        for(Producto prod : this.listaProductos){
            if(prod.getCodigo() == codigo){
                this.listaProductos.remove(prod);
                break;
            }
        }
    }

    public boolean existeProdcuto(int codigo, String nombre){
        for(Producto prod : this.listaProductos){
            if(!nombre.equals("")){
                if(prod.getNombre().equals(nombre)){
                    return true;
                }
            }else if(prod.getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }

    // ------ info prodcutos
    public ArrayList<InfoProducto> obtenerInfoProductos(){
        return this.listaInfoProductos;
    }

    public void agregarInfoProdcuto(InfoProducto infoProducto){
        this.listaInfoProductos.add(infoProducto);
    }
}

