/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entidades.Compra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cecilia
 */
@Stateless
public class CompraFacade implements CompraFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Compra compra) {
        em.persist(compra);
    }

    public void edit(Compra compra) {
        em.merge(compra);
    }

    public void remove(Compra compra) {
        em.remove(em.merge(compra));
    }

    public Compra find(Object id) {
        return em.find(Compra.class, id);
    }

    public List<Compra> findAll() {
        return em.createQuery("select object(o) from Compra as o").getResultList();
    }

}
