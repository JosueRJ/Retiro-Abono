package clientesja.dao.implement;

import clientesja.dao.clases.Cuenta;
import clientesja.dao.interfaces.CuentaDAO;
import clientesja.jdbc.ConexionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CuentaImplement implements CuentaDAO{

    @Override
    public List<Cuenta> listar() {
        try {
            //Obtenemos la conexion de la base de datos
            Connection connection = ConexionSingleton.getConnection();
            //creando una consulta
            Statement statement = connection.createStatement();
            //ejecutamos la consulta y recbimos los datos de la base de datos
            ResultSet rs = statement.executeQuery("SELECT * FROM Cuenta");
            //Construimos la lista vacia de cuentas
            List<Cuenta> cuenta = new ArrayList<>();
            //Iteramos sobre los resultados
            while(rs.next()){
                Cuenta cuenta1 = new Cuenta();
                //construimos el objeto cuenta1 con los datos recibidos
                cuenta1.setNroCuenta(rs.getString("nroCuenta"));
                cuenta1.setTipo(rs.getString("Tipo"));
                cuenta1.setDni(rs.getString("dni"));
                //agregamos el objeto construido a la lista
                cuenta.add(cuenta1);    
            }
            return cuenta;
        } catch (SQLException ex) {
            Logger.getLogger(CuentaImplement.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void guardar(Cuenta cuenta) {
        try {
            Connection connection = ConexionSingleton.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Cuenta VALUES (?,?,?)");
            ps.setString(1, cuenta.getNroCuenta());
            ps.setString(2, cuenta.getDni());
            ps.setString(3, cuenta.getTipo());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CuentaImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Cuenta cuenta) {
        try {
            Connection connection = ConexionSingleton.getConnection();
            PreparedStatement ps = connection.prepareCall("UPDATE Cuenta SET dni=?, tipo=? WHERE NroCuenta=?");
            ps.setString(1, cuenta.getNroCuenta());
            ps.setString(2, cuenta.getDni());
            ps.setString(3, cuenta.getTipo());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CuentaImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrar(Cuenta cuenta) {
        PreparedStatement ps;
        try {
            Connection connection = ConexionSingleton.getConnection();
            ps = connection.prepareStatement("DELETE c,ca FROM Cuenta ca LEFT JOIN Cliente c ON ca.Dni=c.Dni WHERE ca.Dni=?");
            ps.setString(1, cuenta.getNroCuenta());

            ps.executeUpdate();
                        
        } catch (SQLException ex) {
            Logger.getLogger(CuentaImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
