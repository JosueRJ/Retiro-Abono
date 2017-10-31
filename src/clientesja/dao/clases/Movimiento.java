package clientesja.dao.clases;

public class Movimiento {
    private String nroMovimiento;
    private String tipoMovimiento;
    private String monto;
    private String nroCuenta;

    public Movimiento() {
        this.nroMovimiento = "";
        this.tipoMovimiento = "";
        this.monto = "";
        this.nroCuenta = "";

    }

    public Movimiento(String nroMovimiento) {
        this.nroMovimiento = nroMovimiento;
    }

    public Movimiento(String nroMovimiento, String tipoMovimiento, String monto, String nroCuenta) {
        this.nroMovimiento = nroMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.nroCuenta = nroCuenta;
    }

    public String getNroMovimiento() {
        return nroMovimiento;
    }

    public void setNroMovimiento(String nroMovimiento) {
        this.nroMovimiento = nroMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
    
}
