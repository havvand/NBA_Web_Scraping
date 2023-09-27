package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Team;

public class TeamDAOImpl implements TeamDAO{
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
}