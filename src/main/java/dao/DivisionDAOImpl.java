package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Division;

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
}
