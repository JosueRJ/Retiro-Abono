package clientesja.dao.clases;

public class Cuenta {
    private String nroCuenta;
    private String tipo;
    private String dni;

    public Cuenta() {
        this.nroCuenta = "";
        this.tipo = "";
        this.dni="";
    }

    public Cuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Cuenta(String nroCuenta, String tipo, String dni) {
        this.nroCuenta = nroCuenta;
        this.tipo = tipo;
        this.dni = dni;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
  
}
