/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entidades.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cecilia
 */
@Local
public interface ProveedorFacadeLocal {

    void create(Proveedor proveedor);

    void edit(Proveedor proveedor);

    void remove(Proveedor proveedor);

    Proveedor find(Object id);

    List<Proveedor> findAll();

    public List<Proveedor> getListaProveedores(String condicion);
}
