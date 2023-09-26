package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Arena;

public class ArenaDAOImpl implements ArenaDAO{
    private static ArenaDAOImpl instance;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public ArenaDAOImpl() {
    }

    public static ArenaDAOImpl getInstance() {
        if (instance == null) {
            instance = new ArenaDAOImpl();
        }
        return instance;
    }
    @Override
    public int createArena(NBA_Arena arena) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(arena);
            em.getTransaction().commit();
        }
        return arena.getId();
    }
}
