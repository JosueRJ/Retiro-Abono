package clientesja.dao.interfaces;

import clientesja.dao.clases.Movimiento;
import java.util.List;

public interface MovimientoDAO {
    public List<Movimiento> listar();
    public void guardar (Movimiento movimiento);
    public void modificar (Movimiento movimiento);
    public void borrar (Movimiento movimiento);
}
