/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entidades.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cecilia
 */
@Stateless
public class ProveedorFacade implements ProveedorFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Proveedor proveedor) {
        em.persist(proveedor);
    }

    public void edit(Proveedor proveedor) {
        em.merge(proveedor);
    }

    public void remove(Proveedor proveedor) {
        em.remove(em.merge(proveedor));
    }

    public Proveedor find(Object id) {
        return em.find(Proveedor.class, id);
    }

    public List<Proveedor> findAll() {
        return em.createNamedQuery("Proveedor.findAll").getResultList();
    }

    public List<Proveedor> getListaProveedores(String condicion) {
        return em.createQuery("select p from Proveedor p " + condicion + " order by p.codigo").getResultList();
    }
}
