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

    @Override

    public int readLocation(NBA_Location location) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.find(NBA_Location.class , location.getId());
            em.getTransaction().commit();

        }
        return location.getId();
    }

    @Override
    public NBA_Location updateLocation(NBA_Location location){
        NBA_Location updatedLocation;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            updatedLocation = em.merge(location);
            em.getTransaction().commit();
        }
        return updatedLocation;
    }

    @Override
    public void deleteLocation(int id){
        NBA_Location deletedLocation;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            deletedLocation = em.find(NBA_Location.class, id);
            em.remove(deletedLocation);
            em.getTransaction().commit();
        }
    }

}
