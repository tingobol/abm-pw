/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entidades.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cecilia
 */
@Local
public interface ClienteDAOLocal {

    public boolean insert(Cliente cliente) throws Exception;

    public boolean update(Cliente cliente) throws Exception;

    public boolean delete(Cliente cliente) throws Exception;

    public Cliente find(Integer codProducto) throws Exception;

    public List<Cliente> getListaCliente(String condicion) throws Exception;
}
