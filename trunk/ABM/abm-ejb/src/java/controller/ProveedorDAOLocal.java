/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entidades.Proveedor;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author Cecilia
 */


@Local
public interface ProveedorDAOLocal {

    public boolean insert(Proveedor Proveedor) throws Exception;

    public boolean update(Proveedor Proveedor) throws Exception;

    public boolean delete(Proveedor Proveedor) throws Exception;

    public Proveedor find(Integer codProveedor) throws Exception;

    public List<Proveedor> getListaProveedor(String condicion) throws Exception;
}



