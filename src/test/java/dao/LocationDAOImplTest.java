package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.NBA_Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationDAOImplTest {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private LocationDAOImpl locationDAO;

    // Validate that the createLocation method returns the correct id
    @Test
    public void testCreateLocation(){
        locationDAO = LocationDAOImpl.getInstance();
        NBA_Location location = new NBA_Location();
        location.setLocation("New York");
        int id = locationDAO.createLocation(location);
        assertEquals(1, id);
    }

    @Test
    public void testReadLocation(){
        locationDAO = LocationDAOImpl.getInstance();
        NBA_Location location = new NBA_Location();
        location.setLocation("New York");
        locationDAO.createLocation(location);
        int id = locationDAO.readLocation(location);
        assertEquals(1, id);
    }

    // Validate that the updateLocation method returns the correct id
    @Test
    public void testUpdateLocation(){
        locationDAO = LocationDAOImpl.getInstance();
        NBA_Location location = new NBA_Location();
        location.setLocation("New York");
        locationDAO.createLocation(location);
        location.setLocation("Brooklyn");
        NBA_Location updatedLocation = locationDAO.updateLocation(location);
        assertEquals("Brooklyn", updatedLocation.getLocation());
    }



}