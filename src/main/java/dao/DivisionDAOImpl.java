package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Division;

import java.util.List;

public class DivisionDAOImpl implements DivisionDAO{
    private static DivisionDAOImpl instance;

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public DivisionDAOImpl() {
    }

    public static DivisionDAOImpl getInstance() {
        if (instance == null) {
            instance = new DivisionDAOImpl();
        }
        return instance;
    }
    @Override
    public int createDivision(NBA_Division division) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(division);
            em.getTransaction().commit();
        }
        return division.getId();
    }

    @Override
    public int readDivision(NBA_Division division){
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.find(NBA_Division.class, division.getId());
            em.getTransaction().commit();

        }
        return division.getId();
    }

    @Override
    public NBA_Division updateDivision(NBA_Division division){
        NBA_Division updatedDivision;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            updatedDivision = em.merge(division);
            em.getTransaction().commit();


        }
        return updatedDivision;
    }

    @Override

    public void deleteDivision(int id){
        NBA_Division deletedDivision;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            deletedDivision = em.find(NBA_Division.class, id);
            if(deletedDivision != null){
                em.remove(deletedDivision);
                em.getTransaction().commit();
            }
        }
    }

    public List<NBA_Division> getAllDivisions() {
        List<NBA_Division> divisions;
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            divisions = em.createQuery("SELECT d FROM NBA_Division d", NBA_Division.class).getResultList();
            em.getTransaction().commit();
        }
        return divisions;
    }



}
