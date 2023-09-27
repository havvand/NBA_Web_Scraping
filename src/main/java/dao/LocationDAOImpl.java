package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Location;

public class LocationDAOImpl implements LocationDAO{
    private static LocationDAOImpl instance;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    public LocationDAOImpl() {
    }
    public static LocationDAOImpl getInstance() {
        if (instance == null) {
            instance = new LocationDAOImpl();
        }
        return instance;
    }
    @Override
    public int createLocation(NBA_Location location) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
        }
        return location.getId();
    }
}
