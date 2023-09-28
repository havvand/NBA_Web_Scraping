package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamDAOImplTest {

    private static TeamDAOImpl teamDAO;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    // Validate that the createTeam method returns the correct id

    @Test
    public void testCreateTeam(){
        teamDAO = TeamDAOImpl.getInstance();
        NBA_Team team = new NBA_Team();
        team.setName("Boston Celtics");
        int id = teamDAO.createTeam(team);
        assertEquals(1, id);
    }

    @Test
    // Validate that the readTeam method returns the correct id
    public void testReadTeam(){
        teamDAO = TeamDAOImpl.getInstance();
        NBA_Team team = new NBA_Team();
        team.setName("Boston Celtics");
        teamDAO.createTeam(team);
        int id = teamDAO.readTeam(team);
        assertEquals(1, id);
    }

    @Test
    // Validate that the updateTeam method returns the correct id
    public void testUpdateTeam(){
        teamDAO = TeamDAOImpl.getInstance();
        NBA_Team team = new NBA_Team();
        team.setName("Boston Celtics");
        teamDAO.createTeam(team);
        team.setName("Boston Red Sox");
        NBA_Team updatedTeam = teamDAO.updateTeam(team);
        assertEquals("Boston Red Sox", updatedTeam.getName());
    }






}