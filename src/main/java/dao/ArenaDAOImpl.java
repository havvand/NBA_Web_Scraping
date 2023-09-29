package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Arena;

import java.util.List;

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

    @Override
    public NBA_Arena readArena(int id){
        NBA_Arena arena;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            arena = em.find(NBA_Arena.class, id);
            em.getTransaction().commit();


        }
        return arena;
    }

    @Override
    public NBA_Arena updateArena(NBA_Arena arena){
        NBA_Arena updatedArena;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
           updatedArena = em.merge(arena);
            em.getTransaction().commit();

        }
        return updatedArena;
    }

    @Override
    public void deleteArena(int id){
        NBA_Arena deletedArena;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            deletedArena = em.find(NBA_Arena.class, id);
            if(deletedArena != null){
                em.remove(deletedArena);
            }
        em.getTransaction().commit();}

    }

    @Override
    public List<NBA_Arena> getAllArenas() {
        List<NBA_Arena> arenas;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            arenas = em.createQuery("SELECT a FROM NBA_Arena a", NBA_Arena.class).getResultList();
            em.getTransaction().commit();
        }
        return arenas;
    }


}
