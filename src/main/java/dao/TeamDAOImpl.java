package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.NBA_Team;

import java.util.ArrayList;
import java.util.List;

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

    public NBA_Team readTeam(int id) {
        NBA_Team team;
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            team = em.find(NBA_Team.class, id);
            em.getTransaction().commit();

        }
        return team;


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

    public List<NBA_Team> getAllTeams() {
        List<NBA_Team> teams = new ArrayList<>();
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            TypedQuery<NBA_Team> query = em.createQuery("SELECT t FROM NBA_Team t", NBA_Team.class);
            teams = query.getResultList();
            em.getTransaction().commit();
        }
        return teams;
    }



}