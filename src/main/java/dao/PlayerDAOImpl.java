package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Player;

public class PlayerDAOImpl implements PlayerDAO{
    private static PlayerDAOImpl instance;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    public PlayerDAOImpl() {
    }
    public static PlayerDAOImpl getInstance() {
        if (instance == null) {
            instance = new PlayerDAOImpl();
        }
        return instance;
    }
    @Override
    public int createPlayer(NBA_Player player) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        }
        return player.getId();
    }

    @Override
    public NBA_Player readPlayer(int id){
        NBA_Player foundPlayer;
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            foundPlayer = em.find(NBA_Player.class,id);
            em.getTransaction().commit();

        }
        return foundPlayer;
    }

    @Override
    public void deletePlayer(int id){
        NBA_Player deletedPlayer;
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            deletedPlayer = em.find(NBA_Player.class, id);
            em.remove(deletedPlayer);
            em.getTransaction().commit();

        }
    }


}
