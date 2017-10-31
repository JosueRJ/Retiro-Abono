package clientesja.dao.clases;

import clientesja.jdbc.ConexionSingleton;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

public class Cliente {
    private String dni;
    private String nombres;
    private String apPaterno;
    private String apMaterno;

    public Cliente() {
        this.dni = "";
        this.nombres = "";
        this.apPaterno = "";
        this.apMaterno = "";
    }

    public Cliente(String dni) {
        this.dni = dni;
    }
    
    public Cliente(String dni, String nombres, String apPaterno, String apMaterno) {
        this.dni = dni;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }
    //Llenar comboBox de FrmPrincipal
    public void llenarClientes(JComboBox<Cliente> cbxClientes){
        String Sql = "SELECT * FROM Cliente";
        try {
            Connection connection = ConexionSingleton.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            while (rs.next()) {
                cbxClientes.addItem(
                        new Cliente (
                                rs.getString("dni"),
                                rs.getString("nombres"),
                                rs.getString("apPaterno"),
                                rs.getString("apMaterno")
                        )
                );
                
            }
        } catch (Exception e) {
        }
    }
    
    public String toString(){
        return nombres +' '+apPaterno;
    }
}
