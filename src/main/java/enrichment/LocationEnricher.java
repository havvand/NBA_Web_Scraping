package enrichment;

import dao.LocationDAO;
import dao.LocationDAOImpl;
import dto.ScraperDTO;
import model.NBA_Location;
import model.NBA_Team;
import webscraper.WebScraper;

import java.util.List;

public class LocationEnricher {
    private WebScraper webScraper = new WebScraper();
    private List<ScraperDTO> locationList = webScraper.teamScraper();
    public List<ScraperDTO> locationEnricher() {
        LocationDAO locationDAO = LocationDAOImpl.getInstance();
        locationList = webScraper.teamScraper();
        locationList.forEach(a -> {
            NBA_Location location = new NBA_Location(a.getLocation());
            locationDAO.createLocation(location);
        });
        return  locationList;
    }

    public void addLocationToTeam() {

    }

}
