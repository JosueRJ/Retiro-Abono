package clientesja.dao.implement;

import clientesja.dao.clases.Movimiento;
import clientesja.dao.interfaces.MovimientoDAO;
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

public class MovimientoImplement implements MovimientoDAO{

    @Override
    public List<Movimiento> listar() {
        try {
            //Obtenemos la conexion de la base de datos
            Connection connection = ConexionSingleton.getConnection();
            //creando una consulta
            Statement statement = connection.createStatement();
            //ejecutamos la consulta y recbimos los datos de la base de datos
            ResultSet rs = statement.executeQuery("SELECT * FROM Movimiento");
            //Construimos la lista vacia de Movimientos
            List<Movimiento> movimiento = new ArrayList<>();
            //Iteramos sobre los resultados
            while(rs.next()){
                Movimiento movimiento1 = new Movimiento();
                //construimos el objeto movimiento1 con los datos recibidos
                movimiento1.setNroMovimiento(rs.getString("nroMovimiento"));
                movimiento1.setTipoMovimiento(rs.getString("tipoMovimiento"));
                movimiento1.setMonto(rs.getString("monto"));
                movimiento1.setNroCuenta(rs.getString("nroCuenta"));
                //agregamos el objeto construido a la lista
                movimiento.add(movimiento1);                
            }
            return movimiento;
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoImplement.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void guardar(Movimiento movimiento) {
        try {
            Connection connection = ConexionSingleton.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Movimiento VALUES (?,?,?,?)");
            ps.setString(1, movimiento.getNroMovimiento());
            ps.setString(2, movimiento.getTipoMovimiento());
            ps.setString(3, movimiento.getMonto());
            ps.setString(4, movimiento.getNroCuenta());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Movimiento movimiento) {
        try {
            Connection connection = ConexionSingleton.getConnection();
            PreparedStatement ps = connection.prepareCall("UPDATE Movimiento SET TipoMovimiento=?, Monto=?, NroCuenta=? WHERE NroMovimiento=?");
            ps.setString(1, movimiento.getNroMovimiento());
            ps.setString(2, movimiento.getTipoMovimiento());
            ps.setString(3, movimiento.getMonto());
            ps.setString(4, movimiento.getNroCuenta());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrar(Movimiento movimiento) {
        PreparedStatement ps;
        try {
            Connection connection = ConexionSingleton.getConnection();
            ps = connection.prepareStatement("DELETE FROM Movimiento WHERE NroMovimiento=?");
            ps.setString(1, movimiento.getNroMovimiento());

            ps.executeUpdate();
                        
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
