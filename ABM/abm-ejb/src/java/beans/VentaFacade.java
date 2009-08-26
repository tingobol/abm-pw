/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entidades.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cecilia
 */
@Stateless
public class VentaFacade implements VentaFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Venta venta) {
        em.persist(venta);
    }

    public void edit(Venta venta) {
        em.merge(venta);
    }

    public void remove(Venta venta) {
        em.remove(em.merge(venta));
    }

    public Venta find(Object id) {
        return em.find(Venta.class, id);
    }

    public List<Venta> findAll() {
        return em.createQuery("select object(o) from Venta as o").getResultList();
    }

}
