package controller;

import entidades.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author liz
 */
@Stateless(mappedName="productoDao")
public class ProductoDAOBean implements ProductoDAOLocal{

    /**
     * Manejador de instancias de entidades para recuperar instancias desde
     * el Persistence Context
     */
    @PersistenceContext
    private EntityManager em;

     /**
     * Inserta una entidad de producto en la base de datos.
     *
     * @param producto Elemento a insertar
     * @return 
     * @throws java.lang.Exception
     */
    public boolean insert(Producto producto) throws Exception {
        boolean retorno = false;
        try {
            em.persist(producto);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }


    /**
     * Modifica una entidad de producto en la base de datos.
     *
     * @param insumo Elemento a editar
     * @return true 
     * @throws java.lang.Exception
     */
    public boolean update(Producto producto) throws Exception {
        boolean retorno = false;
        try {
            em.merge(producto);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }

    /**
     * Elimina una entidad de producto en la base de datos.
     *
     * @param insumo Elemento a eliminar
     * @return true 
     * @throws java.lang.Exception
     */
    public boolean delete(Producto producto) throws Exception {
        boolean retorno = false;
        try {
            Producto mgdProducto = em.merge(producto);
            em.remove(mgdProducto);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }

    /**
     *
     * @param codProducto
     * @return
     * @throws java.lang.Exception
     */
    public Producto find(Integer codProducto) throws Exception {
        Producto retorno = null;
        try {
            Query q = em.createNamedQuery("Producto.findByCodigo");
            q.setParameter("codigo", codProducto);
            retorno = (Producto)q.getSingleResult();
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }

    /**
     * 
     * @param condicion
     * @return
     * @throws java.lang.Exception
     */
    public List<Producto> getListaProductos(String condicion) throws Exception {
        List<Producto> retorno = null;
        Query q = null;
        try {
            if(condicion == null || condicion.length() == 0)
                q = em.createNamedQuery("Producto.findAll");
            else
                q = em.createQuery("select p from Producto p " + condicion + " order by p.codigo");
            // recuperamos la lista
            retorno = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            return retorno;
        }
    }


}
