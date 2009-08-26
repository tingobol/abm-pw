/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entidades.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author liz
 */
@Local
public interface ProductoDAOLocal {

    public boolean insert(Producto producto) throws Exception;

    public boolean update(Producto producto) throws Exception;

    public boolean delete(Producto producto) throws Exception;

    public Producto find(Integer codProducto) throws Exception;

    public List<Producto> getListaProductos(String condicion) throws Exception;
}

