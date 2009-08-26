/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entidades.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cecilia
 */
@Stateless
public class ClienteFacade implements ClienteFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Cliente cliente) {
        em.persist(cliente);
    }

    public void edit(Cliente cliente) {
        em.merge(cliente);
    }

    public void remove(Cliente cliente) {
        em.remove(em.merge(cliente));
    }

    public Cliente find(Object id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> findAll() {
        return em.createQuery("select object(o) from Cliente as o").getResultList();
    }

}
