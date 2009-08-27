package controller;

import entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ceci
 */
@Stateless(mappedName="ClienteDao")
public class ClienteDAOBean implements ClienteDAOLocal{

    /**
     * Manejador de instancias de entidades para recuperar instancias desde
     * el Persistence Context
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * 
     * @param cliente
     * @return
     * @throws java.lang.Exception
     */
    public boolean insert(Cliente cliente) throws Exception {
        boolean retorno = false;
        try {
            em.persist(cliente);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }


    /**
     *
     * @param cliente
     * @return
     * @throws java.lang.Exception
     */
    public boolean update(Cliente cliente) throws Exception {
        boolean retorno = false;
        try {
            em.merge(cliente);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }

    /**
     *
     * @param cliente
     * @return
     * @throws java.lang.Exception
     */
    public boolean delete(Cliente cliente) throws Exception {
        boolean retorno = false;
        try {
            Cliente mgdCliente = em.merge(cliente);
            em.remove(mgdCliente);
            retorno = true;
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }

    /**
     *
     * @param codCliente
     * @return
     * @throws java.lang.Exception
     */
    public Cliente find(Integer codCliente) throws Exception {
        Cliente retorno = null;
        try {
            Query q = em.createNamedQuery("Cliente.findByidcliente");
            q.setParameter("idcliente", codCliente);
            retorno = (Cliente)q.getSingleResult();
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
    public List<Cliente> getListaCliente(String condicion) throws Exception {
        List<Cliente> retorno = null;
        Query q = null;
        try {
            if(condicion == null || condicion.length() == 0)
                q = em.createNamedQuery("Cliente.findAll");
            else
                q = em.createQuery("select p from Cliente c " + condicion + " order by c.idcliente");
            // recuperamos la lista
            retorno = q.getResultList();
        } catch (Exception e) {
            throw e;
        }finally{
            return retorno;
        }
    }




}
