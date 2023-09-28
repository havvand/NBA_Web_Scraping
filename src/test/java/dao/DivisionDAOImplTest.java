package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Division;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionDAOImplTest {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private DivisionDAOImpl divisionDAO;

    // Validate that the createDivision method returns the correct id
    @Test
    public void testCreateDivision(){
        EntityManager em = emf.createEntityManager();
        divisionDAO = DivisionDAOImpl.getInstance();
        NBA_Division division = new NBA_Division();
        division.setDivisionName("Atlantic");
        int id = divisionDAO.createDivision(division);
        assertEquals(1, id);
        em.close();
        emf.close();
    }

// Validate that the readDivision method returns the correct id
    @Test
    public void testReadDivision(){
        EntityManager em = emf.createEntityManager();
        divisionDAO = DivisionDAOImpl.getInstance();
        NBA_Division division = new NBA_Division();
        division.setDivisionName("Atlantic");
        divisionDAO.createDivision(division);
        int id = divisionDAO.readDivision(division);
        assertEquals(1, id);
        em.close();
        emf.close();
    }

// Validate that the updateDivision method returns the correct id
    @Test
    public void testUpdateDivision(){
        EntityManager em = emf.createEntityManager();
        divisionDAO = DivisionDAOImpl.getInstance();
        NBA_Division division = new NBA_Division();
        division.setDivisionName("Atlantic");
        divisionDAO.createDivision(division);
        division.setDivisionName("Central");
        NBA_Division updatedDivision = divisionDAO.updateDivision(division);
        assertEquals("Central", updatedDivision.getDivisionName());
        em.close();
        emf.close();
    }




}