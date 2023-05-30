class Proveedor {
    private int codigo; 
    private String nombre;
    private String categoria;
    private int contacto; 
    
    public Proveedor(int codigo, String nombre, String categoria, int contacto){ 
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.contacto = contacto;
    }

    public int getCodigo(){
        return this.codigo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public int getContacto(){
        return this.contacto;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public void setContacto(int contacto){
        this.contacto = contacto;
    }
}

/* 
 * codgigo 
 * nombre
 * categoria
 * contacto
 * 
 * getters
 * setters
 */