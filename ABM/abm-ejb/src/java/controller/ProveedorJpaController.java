/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import controller.exceptions.RollbackFailureException;
import entidades.Proveedor;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import entidades.Compra;
import java.util.ArrayList;
import java.util.Collection;
import entidades.Producto;
import javax.transaction.UserTransaction;

/**
 *
 * @author Cecilia
 */
public class ProveedorJpaController {
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "abm-ejbPU")
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (proveedor.getCompraCollection() == null) {
            proveedor.setCompraCollection(new ArrayList<Compra>());
        }
        if (proveedor.getProductoCollection() == null) {
            proveedor.setProductoCollection(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Compra> attachedCompraCollection = new ArrayList<Compra>();
            for (Compra compraCollectionCompraToAttach : proveedor.getCompraCollection()) {
                compraCollectionCompraToAttach = em.getReference(compraCollectionCompraToAttach.getClass(), compraCollectionCompraToAttach.getIdcompra());
                attachedCompraCollection.add(compraCollectionCompraToAttach);
            }
            proveedor.setCompraCollection(attachedCompraCollection);
            Collection<Producto> attachedProductoCollection = new ArrayList<Producto>();
            for (Producto productoCollectionProductoToAttach : proveedor.getProductoCollection()) {
                productoCollectionProductoToAttach = em.getReference(productoCollectionProductoToAttach.getClass(), productoCollectionProductoToAttach.getCodigo());
                attachedProductoCollection.add(productoCollectionProductoToAttach);
            }
            proveedor.setProductoCollection(attachedProductoCollection);
            em.persist(proveedor);
            for (Compra compraCollectionCompra : proveedor.getCompraCollection()) {
                Proveedor oldIdproveedorOfCompraCollectionCompra = compraCollectionCompra.getIdproveedor();
                compraCollectionCompra.setIdproveedor(proveedor);
                compraCollectionCompra = em.merge(compraCollectionCompra);
                if (oldIdproveedorOfCompraCollectionCompra != null) {
                    oldIdproveedorOfCompraCollectionCompra.getCompraCollection().remove(compraCollectionCompra);
                    oldIdproveedorOfCompraCollectionCompra = em.merge(oldIdproveedorOfCompraCollectionCompra);
                }
            }
            for (Producto productoCollectionProducto : proveedor.getProductoCollection()) {
                Proveedor oldProveedorOfProductoCollectionProducto = productoCollectionProducto.getProveedor();
                productoCollectionProducto.setProveedor(proveedor);
                productoCollectionProducto = em.merge(productoCollectionProducto);
                if (oldProveedorOfProductoCollectionProducto != null) {
                    oldProveedorOfProductoCollectionProducto.getProductoCollection().remove(productoCollectionProducto);
                    oldProveedorOfProductoCollectionProducto = em.merge(oldProveedorOfProductoCollectionProducto);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProveedor(proveedor.getCodigo()) != null) {
                throw new PreexistingEntityException("Proveedor " + proveedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getCodigo());
            Collection<Compra> compraCollectionOld = persistentProveedor.getCompraCollection();
            Collection<Compra> compraCollectionNew = proveedor.getCompraCollection();
            Collection<Producto> productoCollectionOld = persistentProveedor.getProductoCollection();
            Collection<Producto> productoCollectionNew = proveedor.getProductoCollection();
            List<String> illegalOrphanMessages = null;
            for (Compra compraCollectionOldCompra : compraCollectionOld) {
                if (!compraCollectionNew.contains(compraCollectionOldCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Compra " + compraCollectionOldCompra + " since its idproveedor field is not nullable.");
                }
            }
            for (Producto productoCollectionOldProducto : productoCollectionOld) {
                if (!productoCollectionNew.contains(productoCollectionOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + productoCollectionOldProducto + " since its proveedor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Compra> attachedCompraCollectionNew = new ArrayList<Compra>();
            for (Compra compraCollectionNewCompraToAttach : compraCollectionNew) {
                compraCollectionNewCompraToAttach = em.getReference(compraCollectionNewCompraToAttach.getClass(), compraCollectionNewCompraToAttach.getIdcompra());
                attachedCompraCollectionNew.add(compraCollectionNewCompraToAttach);
            }
            compraCollectionNew = attachedCompraCollectionNew;
            proveedor.setCompraCollection(compraCollectionNew);
            Collection<Producto> attachedProductoCollectionNew = new ArrayList<Producto>();
            for (Producto productoCollectionNewProductoToAttach : productoCollectionNew) {
                productoCollectionNewProductoToAttach = em.getReference(productoCollectionNewProductoToAttach.getClass(), productoCollectionNewProductoToAttach.getCodigo());
                attachedProductoCollectionNew.add(productoCollectionNewProductoToAttach);
            }
            productoCollectionNew = attachedProductoCollectionNew;
            proveedor.setProductoCollection(productoCollectionNew);
            proveedor = em.merge(proveedor);
            for (Compra compraCollectionNewCompra : compraCollectionNew) {
                if (!compraCollectionOld.contains(compraCollectionNewCompra)) {
                    Proveedor oldIdproveedorOfCompraCollectionNewCompra = compraCollectionNewCompra.getIdproveedor();
                    compraCollectionNewCompra.setIdproveedor(proveedor);
                    compraCollectionNewCompra = em.merge(compraCollectionNewCompra);
                    if (oldIdproveedorOfCompraCollectionNewCompra != null && !oldIdproveedorOfCompraCollectionNewCompra.equals(proveedor)) {
                        oldIdproveedorOfCompraCollectionNewCompra.getCompraCollection().remove(compraCollectionNewCompra);
                        oldIdproveedorOfCompraCollectionNewCompra = em.merge(oldIdproveedorOfCompraCollectionNewCompra);
                    }
                }
            }
            for (Producto productoCollectionNewProducto : productoCollectionNew) {
                if (!productoCollectionOld.contains(productoCollectionNewProducto)) {
                    Proveedor oldProveedorOfProductoCollectionNewProducto = productoCollectionNewProducto.getProveedor();
                    productoCollectionNewProducto.setProveedor(proveedor);
                    productoCollectionNewProducto = em.merge(productoCollectionNewProducto);
                    if (oldProveedorOfProductoCollectionNewProducto != null && !oldProveedorOfProductoCollectionNewProducto.equals(proveedor)) {
                        oldProveedorOfProductoCollectionNewProducto.getProductoCollection().remove(productoCollectionNewProducto);
                        oldProveedorOfProductoCollectionNewProducto = em.merge(oldProveedorOfProductoCollectionNewProducto);
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
                Integer id = proveedor.getCodigo();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Compra> compraCollectionOrphanCheck = proveedor.getCompraCollection();
            for (Compra compraCollectionOrphanCheckCompra : compraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedor (" + proveedor + ") cannot be destroyed since the Compra " + compraCollectionOrphanCheckCompra + " in its compraCollection field has a non-nullable idproveedor field.");
            }
            Collection<Producto> productoCollectionOrphanCheck = proveedor.getProductoCollection();
            for (Producto productoCollectionOrphanCheckProducto : productoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedor (" + proveedor + ") cannot be destroyed since the Producto " + productoCollectionOrphanCheckProducto + " in its productoCollection field has a non-nullable proveedor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(proveedor);
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

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Proveedor as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Proveedor findProveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from Proveedor as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
