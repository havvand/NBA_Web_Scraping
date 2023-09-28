package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.NBA_Arena;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

class ArenaDAOImplTest {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private ArenaDAOImpl arenaDAO;

    // Validate that the createArena method returns the correct id
    @Test
    public void testCreateArena(){
        EntityManager em = emf.createEntityManager();
        arenaDAO = ArenaDAOImpl.getInstance();
        NBA_Arena arena = new NBA_Arena();
        arena.setArenaName("TD Garden");
        int id = arenaDAO.createArena(arena);
        assertEquals(1, id);
        em.close();
        emf.close();
    }

    @Test
    // Validate that the readArena method returns the correct id
    public void testReadArena(){
        EntityManager em = emf.createEntityManager();
        arenaDAO = ArenaDAOImpl.getInstance();
        NBA_Arena arena = new NBA_Arena();
        arena.setArenaName("TD Garden");
        arenaDAO.createArena(arena);
        int id = arenaDAO.readArena(arena);
        assertEquals(1, id);
        em.close();
        emf.close();
    }

    @Test
    // Validate that the updateArena method returns the correct id
    public void testUpdateArena(){
        EntityManager em = emf.createEntityManager();
        arenaDAO = ArenaDAOImpl.getInstance();
        NBA_Arena arena = new NBA_Arena();
        arena.setArenaName("TD Garden");
        arenaDAO.createArena(arena);
        arena.setArenaName("Fenway Park");
        NBA_Arena updatedArena = arenaDAO.updateArena(arena);
        assertEquals("Fenway Park", updatedArena.getArenaName());
        em.close();
        emf.close();
    }






//    @BeforeEach
//    public void setUp() {
//        emf = Persistence.createEntityManagerFactory("NBA_Web_Scraping_Test");
//        em = emf.createEntityManager();
//        arenaDAO = ArenaDAOImpl.getInstance();
//    }
//
//    @AfterEach
//
//    public void tearDown() {
//        em.close();
//        emf.close();
//    }
//
//
//
//    @Test
//    // Assert that the createArena method returns the correct id
//    public void testArenaDAO(){
//        NBA_Arena arena = new NBA_Arena();
//        arena.setArenaName("TD Garden");
//
//
//        int id = arenaDAO.createArena(arena);
//        assertEquals(1, id);
//
//    }
//
//    @Test
//    // Assert that the readArena method returns the correct id
//    public void testReadArena(){
//        NBA_Arena arena = new NBA_Arena();
//        arena.setArenaName("TD Garden");
//        arenaDAO.createArena(arena);
//        int id = arenaDAO.readArena(arena);
//        assertEquals(1, id);
//    }




}