/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entidades.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cecilia
 */
@Stateless
public class ProductoFacade implements ProductoFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Producto producto) {
        em.persist(producto);
    }

    public void edit(Producto producto) {
        em.merge(producto);
    }

    public void remove(Producto producto) {
        em.remove(em.merge(producto));
    }

    public Producto find(Object id) {
        return em.find(Producto.class, id);
    }

    public List<Producto> findAll() {
        return em.createQuery("select object(o) from Producto as o").getResultList();
    }

}
