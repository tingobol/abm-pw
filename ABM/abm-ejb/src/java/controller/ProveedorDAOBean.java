package controller;

import entidades.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author liz
 */
@Stateless(mappedName="proveedorDao")
public class ProveedorDAOBean implements ProveedorDAOLocal{

    /**
     * Manejador de instancias de entidades para recuperar instancias desde
     * el Persistence Context
     */
    @PersistenceContext
    private EntityManager em;
    /**
     * 
     * @param proveedor
     * @return
     * @throws java.lang.Exception
     */
    public boolean insert(Proveedor proveedor) throws Exception {
         boolean retorno = false;
        try {
            em.persist(proveedor);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }
    /**
     *
     * @param proveedor
     * @return
     * @throws java.lang.Exception
     */
    public boolean update(Proveedor proveedor) throws Exception {
       boolean retorno = false;
        try {
            em.merge(proveedor);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }
    /**
     *
     * @param proveedor
     * @return
     * @throws java.lang.Exception
     */
    public boolean delete(Proveedor proveedor) throws Exception {
            boolean retorno = false;
        try {
            Proveedor mgdProveedor = em.merge(proveedor);
            em.remove(mgdProveedor);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }
    /**
     *
     * @param codProveedor
     * @return
     * @throws java.lang.Exception
     */
    public Proveedor find(Integer codProveedor) throws Exception {
         Proveedor retorno = null;
        try {
            Query q = em.createNamedQuery("Proveedor.findByCodigo");
            q.setParameter("codigo", codProveedor);
            retorno = (Proveedor)q.getSingleResult();
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
    public List<Proveedor> getListaProveedor(String condicion) throws Exception {
          List<Proveedor> retorno = null;
        Query q = null;
        try {
            if(condicion == null || condicion.length() == 0)
                q = em.createNamedQuery("Proveedor.findAll");
            else
                q = em.createQuery("select p from Proveedor p " + condicion + " order by p.codigo");
            // recuperamos la lista
            retorno = q.getResultList();
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }



}
