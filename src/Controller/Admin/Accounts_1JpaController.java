/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.Admin.exceptions.NonexistentEntityException;
import Controller.Admin.exceptions.PreexistingEntityException;
import Model.Accounts_1;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author hp
 */
public class Accounts_1JpaController implements Serializable {

    public Accounts_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Accounts_1 accounts_1) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(accounts_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAccounts_1(accounts_1.getId()) != null) {
                throw new PreexistingEntityException("Accounts_1 " + accounts_1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Accounts_1 accounts_1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            accounts_1 = em.merge(accounts_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = accounts_1.getId();
                if (findAccounts_1(id) == null) {
                    throw new NonexistentEntityException("The accounts_1 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Accounts_1 accounts_1;
            try {
                accounts_1 = em.getReference(Accounts_1.class, id);
                accounts_1.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accounts_1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(accounts_1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Accounts_1> findAccounts_1Entities() {
        return findAccounts_1Entities(true, -1, -1);
    }

    public List<Accounts_1> findAccounts_1Entities(int maxResults, int firstResult) {
        return findAccounts_1Entities(false, maxResults, firstResult);
    }

    private List<Accounts_1> findAccounts_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Accounts_1.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Accounts_1 findAccounts_1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Accounts_1.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccounts_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Accounts_1> rt = cq.from(Accounts_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
