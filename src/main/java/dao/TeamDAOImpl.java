package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Team;

public class TeamDAOImpl implements TeamDAO {
    private static TeamDAOImpl instance;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public TeamDAOImpl() {
    }

    public static TeamDAOImpl getInstance() {
        if (instance == null) {
            instance = new TeamDAOImpl();
        }
        return instance;
    }

    @Override
    public int createTeam(NBA_Team team) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(team);
            em.getTransaction().commit();
        }
        return team.getId();
    }

    public int readTeam(NBA_Team team) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.find(NBA_Team.class, team.getId());
            em.getTransaction().commit();

        }
        return team.getId();


    }

    public NBA_Team updateTeam(NBA_Team team) {
        NBA_Team updatedTeam;
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            updatedTeam = em.merge(team);
            em.getTransaction().commit();

        }
        return updatedTeam;
    }

    public void deleteTeam(int id) {
        NBA_Team deletedTeam;
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            deletedTeam = em.find(NBA_Team.class, id);
            em.remove(deletedTeam);
            em.getTransaction().commit();

        }
    }




}