package clientesja.dao.implement;

import clientesja.dao.clases.Cliente;
import clientesja.dao.interfaces.ClienteDAO;
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

public class ClienteImplement implements ClienteDAO{

    @Override
    public List<Cliente> listar() {
        try {
            //Obtenemos la conexion de la base de datos
            Connection connection = ConexionSingleton.getConnection();
            //creando una consulta
            Statement statement = connection.createStatement();
            //ejecutamos la consulta y recbimos los datos de la base de datos
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente");
            //Construimos la lista vacia de clientes
            List<Cliente> cliente = new ArrayList<>();
            //Iteramos sobre los resultados
            while(rs.next()){
                Cliente cliente1 = new Cliente();
                //construimos el objeto cliente1 con los datos recibidos                
                cliente1.setDni(rs.getString("DNI"));
                cliente1.setNombres(rs.getString("Nombres"));
                cliente1.setApPaterno(rs.getString("ApPaterno"));
                cliente1.setApMaterno(rs.getString("ApMaterno"));
                //agregamos el objeto construido a la lista
                cliente.add(cliente1);
                
            }
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImplement.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }

    @Override
    public void guardar(Cliente cliente) {
        try {
            Connection connection = ConexionSingleton.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?)");
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApPaterno());
            ps.setString(4, cliente.getApMaterno());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Cliente cliente) {
        PreparedStatement ps;
        try {
            Connection connection = ConexionSingleton.getConnection();
            ps = connection.prepareCall("UPDATE Cliente SET nombres=?, apPaterno=?, apMaterno=? WHERE dni=?");
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApPaterno());
            ps.setString(3, cliente.getApMaterno());
            ps.setString(4, cliente.getDni());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrar(Cliente cliente) {
        PreparedStatement ps;
        try {
            Connection connection = ConexionSingleton.getConnection();
            ps = connection.prepareStatement("DELETE c,ca FROM Cuenta ca LEFT JOIN Cliente c ON ca.Dni=c.Dni WHERE ca.Dni=?");
            ps.setString(1, cliente.getDni());

            ps.executeUpdate();
                        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
