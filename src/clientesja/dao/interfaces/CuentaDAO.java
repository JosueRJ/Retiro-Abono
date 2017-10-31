package clientesja.dao.interfaces;

import clientesja.dao.clases.Cuenta;
import java.util.List;

public interface CuentaDAO {
    public List<Cuenta> listar();
    public void guardar (Cuenta cuenta);
    public void modificar (Cuenta cuenta);
    public void borrar (Cuenta cuenta);
}
