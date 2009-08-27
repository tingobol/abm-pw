/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cecilia
 */
@Local
public interface ProductoFacadeLocal {

    void create(Producto producto);

    void edit(Producto producto);

    void remove(Producto producto);

    Producto find(Object id);

    List<Producto> findAll();

    

}
