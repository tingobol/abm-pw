/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import controller.exceptions.RollbackFailureException;
import entidades.Producto;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import entidades.Proveedor;
import entidades.Compra;
import java.util.ArrayList;
import java.util.Collection;
import entidades.Venta;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Cecilia
 */
public class ProductoJpaController {
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "abm-ejbPU")
    private EntityManagerFactory emf = null;

    /**
     * Manejador de instancias de entidades para recuperar instancias desde
     * el Persistence Context
     */
    @PersistenceContext
    private EntityManager em;


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (producto.getCompraCollection() == null) {
            producto.setCompraCollection(new ArrayList<Compra>());
        }
        if (producto.getVentaCollection() == null) {
            producto.setVentaCollection(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Proveedor proveedor = producto.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getCodigo());
                producto.setProveedor(proveedor);
            }
            Collection<Compra> attachedCompraCollection = new ArrayList<Compra>();
            for (Compra compraCollectionCompraToAttach : producto.getCompraCollection()) {
                compraCollectionCompraToAttach = em.getReference(compraCollectionCompraToAttach.getClass(), compraCollectionCompraToAttach.getIdcompra());
                attachedCompraCollection.add(compraCollectionCompraToAttach);
            }
            producto.setCompraCollection(attachedCompraCollection);
            Collection<Venta> attachedVentaCollection = new ArrayList<Venta>();
            for (Venta ventaCollectionVentaToAttach : producto.getVentaCollection()) {
                ventaCollectionVentaToAttach = em.getReference(ventaCollectionVentaToAttach.getClass(), ventaCollectionVentaToAttach.getIdventa());
                attachedVentaCollection.add(ventaCollectionVentaToAttach);
            }
            producto.setVentaCollection(attachedVentaCollection);
            em.persist(producto);
            if (proveedor != null) {
                proveedor.getProductoCollection().add(producto);
                proveedor = em.merge(proveedor);
            }
            for (Compra compraCollectionCompra : producto.getCompraCollection()) {
                Producto oldIdproductoOfCompraCollectionCompra = compraCollectionCompra.getIdproducto();
                compraCollectionCompra.setIdproducto(producto);
                compraCollectionCompra = em.merge(compraCollectionCompra);
                if (oldIdproductoOfCompraCollectionCompra != null) {
                    oldIdproductoOfCompraCollectionCompra.getCompraCollection().remove(compraCollectionCompra);
                    oldIdproductoOfCompraCollectionCompra = em.merge(oldIdproductoOfCompraCollectionCompra);
                }
            }
            for (Venta ventaCollectionVenta : producto.getVentaCollection()) {
                Producto oldIdproductoOfVentaCollectionVenta = ventaCollectionVenta.getIdproducto();
                ventaCollectionVenta.setIdproducto(producto);
                ventaCollectionVenta = em.merge(ventaCollectionVenta);
                if (oldIdproductoOfVentaCollectionVenta != null) {
                    oldIdproductoOfVentaCollectionVenta.getVentaCollection().remove(ventaCollectionVenta);
                    oldIdproductoOfVentaCollectionVenta = em.merge(oldIdproductoOfVentaCollectionVenta);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProducto(producto.getCodigo()) != null) {
                throw new PreexistingEntityException("Producto " + producto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Producto persistentProducto = em.find(Producto.class, producto.getCodigo());
            Proveedor proveedorOld = persistentProducto.getProveedor();
            Proveedor proveedorNew = producto.getProveedor();
            Collection<Compra> compraCollectionOld = persistentProducto.getCompraCollection();
            Collection<Compra> compraCollectionNew = producto.getCompraCollection();
            Collection<Venta> ventaCollectionOld = persistentProducto.getVentaCollection();
            Collection<Venta> ventaCollectionNew = producto.getVentaCollection();
            List<String> illegalOrphanMessages = null;
            for (Compra compraCollectionOldCompra : compraCollectionOld) {
                if (!compraCollectionNew.contains(compraCollectionOldCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Compra " + compraCollectionOldCompra + " since its idproducto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getCodigo());
                producto.setProveedor(proveedorNew);
            }
            Collection<Compra> attachedCompraCollectionNew = new ArrayList<Compra>();
            for (Compra compraCollectionNewCompraToAttach : compraCollectionNew) {
                compraCollectionNewCompraToAttach = em.getReference(compraCollectionNewCompraToAttach.getClass(), compraCollectionNewCompraToAttach.getIdcompra());
                attachedCompraCollectionNew.add(compraCollectionNewCompraToAttach);
            }
            compraCollectionNew = attachedCompraCollectionNew;
            producto.setCompraCollection(compraCollectionNew);
            Collection<Venta> attachedVentaCollectionNew = new ArrayList<Venta>();
            for (Venta ventaCollectionNewVentaToAttach : ventaCollectionNew) {
                ventaCollectionNewVentaToAttach = em.getReference(ventaCollectionNewVentaToAttach.getClass(), ventaCollectionNewVentaToAttach.getIdventa());
                attachedVentaCollectionNew.add(ventaCollectionNewVentaToAttach);
            }
            ventaCollectionNew = attachedVentaCollectionNew;
            producto.setVentaCollection(ventaCollectionNew);
            producto = em.merge(producto);
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getProductoCollection().remove(producto);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getProductoCollection().add(producto);
                proveedorNew = em.merge(proveedorNew);
            }
            for (Compra compraCollectionNewCompra : compraCollectionNew) {
                if (!compraCollectionOld.contains(compraCollectionNewCompra)) {
                    Producto oldIdproductoOfCompraCollectionNewCompra = compraCollectionNewCompra.getIdproducto();
                    compraCollectionNewCompra.setIdproducto(producto);
                    compraCollectionNewCompra = em.merge(compraCollectionNewCompra);
                    if (oldIdproductoOfCompraCollectionNewCompra != null && !oldIdproductoOfCompraCollectionNewCompra.equals(producto)) {
                        oldIdproductoOfCompraCollectionNewCompra.getCompraCollection().remove(compraCollectionNewCompra);
                        oldIdproductoOfCompraCollectionNewCompra = em.merge(oldIdproductoOfCompraCollectionNewCompra);
                    }
                }
            }
            for (Venta ventaCollectionOldVenta : ventaCollectionOld) {
                if (!ventaCollectionNew.contains(ventaCollectionOldVenta)) {
                    ventaCollectionOldVenta.setIdproducto(null);
                    ventaCollectionOldVenta = em.merge(ventaCollectionOldVenta);
                }
            }
            for (Venta ventaCollectionNewVenta : ventaCollectionNew) {
                if (!ventaCollectionOld.contains(ventaCollectionNewVenta)) {
                    Producto oldIdproductoOfVentaCollectionNewVenta = ventaCollectionNewVenta.getIdproducto();
                    ventaCollectionNewVenta.setIdproducto(producto);
                    ventaCollectionNewVenta = em.merge(ventaCollectionNewVenta);
                    if (oldIdproductoOfVentaCollectionNewVenta != null && !oldIdproductoOfVentaCollectionNewVenta.equals(producto)) {
                        oldIdproductoOfVentaCollectionNewVenta.getVentaCollection().remove(ventaCollectionNewVenta);
                        oldIdproductoOfVentaCollectionNewVenta = em.merge(oldIdproductoOfVentaCollectionNewVenta);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getCodigo();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Compra> compraCollectionOrphanCheck = producto.getCompraCollection();
            for (Compra compraCollectionOrphanCheckCompra : compraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Compra " + compraCollectionOrphanCheckCompra + " in its compraCollection field has a non-nullable idproducto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proveedor proveedor = producto.getProveedor();
            if (proveedor != null) {
                proveedor.getProductoCollection().remove(producto);
                proveedor = em.merge(proveedor);
            }
            Collection<Venta> ventaCollection = producto.getVentaCollection();
            for (Venta ventaCollectionVenta : ventaCollection) {
                ventaCollectionVenta.setIdproducto(null);
                ventaCollectionVenta = em.merge(ventaCollectionVenta);
            }
            em.remove(producto);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Producto as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from Producto as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

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
            throw e;
        }finally{
            return retorno;
        }
    }

}
