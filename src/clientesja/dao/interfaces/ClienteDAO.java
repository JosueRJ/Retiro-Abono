package clientesja.dao.interfaces;

import clientesja.dao.clases.Cliente;
import java.util.List;

public interface ClienteDAO {
    public List<Cliente> listar();
    public void guardar (Cliente cliente);
    public void modificar (Cliente cliente);
    public void borrar (Cliente cliente);
}
