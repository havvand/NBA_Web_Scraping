package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDAOImplTest {

    private static PlayerDAOImpl playerDAO;

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();


    // Validate that the createPlayer method returns the correct id
    @Test
    public void testCreatePlayerFirstName(){
        playerDAO = PlayerDAOImpl.getInstance();
        NBA_Player player = new NBA_Player();
        player.setFirstName("Lebron");
        int id = playerDAO.createPlayer(player);
        assertEquals(1, id);
    }

    @Test
    public void testCreatePlayerLastName(){
        playerDAO = PlayerDAOImpl.getInstance();
        NBA_Player player = new NBA_Player();
        player.setLastName("James");
        int id = playerDAO.createPlayer(player);
        assertEquals(1,id);

    }

    // Validate that the readPlayer method returns the correct id
    @Test
    public void testReadPlayerFirstName(){
        playerDAO = PlayerDAOImpl.getInstance();
        NBA_Player player = new NBA_Player();
        player.setFirstName("Lebron");
        playerDAO.createPlayer(player);
        int id = playerDAO.readPlayer(player);
        assertEquals(1, id);
    }

    @Test
    public void testReadPlayerLastName(){
        playerDAO = PlayerDAOImpl.getInstance();
        NBA_Player player = new NBA_Player();
        player.setLastName("James");
        playerDAO.createPlayer(player);
        int id = playerDAO.readPlayer(player);
        assertEquals(1,id);
    }



    // Validate that the updatePlayer method returns the correct id
    @Test
    public void testUpdatePlayer(){
        playerDAO = PlayerDAOImpl.getInstance();
        NBA_Player player = new NBA_Player();
        player.setFirstName("Lebron");
        playerDAO.createPlayer(player);
        player.setFirstName("Michael");
        NBA_Player updatedPlayer = playerDAO.updatePlayer(player);
        assertEquals("Michael", updatedPlayer.getFirstName());
    }
}