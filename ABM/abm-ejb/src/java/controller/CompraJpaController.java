/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import controller.exceptions.RollbackFailureException;
import entidades.Compra;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import entidades.Producto;
import entidades.Proveedor;
import javax.transaction.UserTransaction;

/**
 *
 * @author Cecilia
 */
public class CompraJpaController {
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "abm-ejbPU")
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compra compra) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Producto idproducto = compra.getIdproducto();
            if (idproducto != null) {
                idproducto = em.getReference(idproducto.getClass(), idproducto.getCodigo());
                compra.setIdproducto(idproducto);
            }
            Proveedor idproveedor = compra.getIdproveedor();
            if (idproveedor != null) {
                idproveedor = em.getReference(idproveedor.getClass(), idproveedor.getCodigo());
                compra.setIdproveedor(idproveedor);
            }
            em.persist(compra);
            if (idproducto != null) {
                idproducto.getCompraCollection().add(compra);
                idproducto = em.merge(idproducto);
            }
            if (idproveedor != null) {
                idproveedor.getCompraCollection().add(compra);
                idproveedor = em.merge(idproveedor);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCompra(compra.getIdcompra()) != null) {
                throw new PreexistingEntityException("Compra " + compra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compra compra) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Compra persistentCompra = em.find(Compra.class, compra.getIdcompra());
            Producto idproductoOld = persistentCompra.getIdproducto();
            Producto idproductoNew = compra.getIdproducto();
            Proveedor idproveedorOld = persistentCompra.getIdproveedor();
            Proveedor idproveedorNew = compra.getIdproveedor();
            if (idproductoNew != null) {
                idproductoNew = em.getReference(idproductoNew.getClass(), idproductoNew.getCodigo());
                compra.setIdproducto(idproductoNew);
            }
            if (idproveedorNew != null) {
                idproveedorNew = em.getReference(idproveedorNew.getClass(), idproveedorNew.getCodigo());
                compra.setIdproveedor(idproveedorNew);
            }
            compra = em.merge(compra);
            if (idproductoOld != null && !idproductoOld.equals(idproductoNew)) {
                idproductoOld.getCompraCollection().remove(compra);
                idproductoOld = em.merge(idproductoOld);
            }
            if (idproductoNew != null && !idproductoNew.equals(idproductoOld)) {
                idproductoNew.getCompraCollection().add(compra);
                idproductoNew = em.merge(idproductoNew);
            }
            if (idproveedorOld != null && !idproveedorOld.equals(idproveedorNew)) {
                idproveedorOld.getCompraCollection().remove(compra);
                idproveedorOld = em.merge(idproveedorOld);
            }
            if (idproveedorNew != null && !idproveedorNew.equals(idproveedorOld)) {
                idproveedorNew.getCompraCollection().add(compra);
                idproveedorNew = em.merge(idproveedorNew);
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
                Integer id = compra.getIdcompra();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdcompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            Producto idproducto = compra.getIdproducto();
            if (idproducto != null) {
                idproducto.getCompraCollection().remove(compra);
                idproducto = em.merge(idproducto);
            }
            Proveedor idproveedor = compra.getIdproveedor();
            if (idproveedor != null) {
                idproveedor.getCompraCollection().remove(compra);
                idproveedor = em.merge(idproveedor);
            }
            em.remove(compra);
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

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Compra as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Compra findCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from Compra as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
