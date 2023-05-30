class Empleado {
    private String Identificacion; 
    private String usuario;
    private String password;
    
    public Empleado(String Identificacion, String usuario, String password){ 
        this.Identificacion = Identificacion;
        this.usuario = usuario;
        this.password = password;
    }

    public String getIdentificacion(){
        return this.Identificacion;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public String getPassword(){
        return this.password;
    }
}