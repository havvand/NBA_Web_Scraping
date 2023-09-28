package enrichment;

import dao.LocationDAO;
import dao.LocationDAOImpl;
import dto.ScraperDTO;
import model.NBA_Location;
import webscraper.WebScraper;

import java.util.List;

public class LocationEnricher {
    private WebScraper webScraper = new WebScraper();
    public List<ScraperDTO> locationEnricher() {
        LocationDAO locationDAO = LocationDAOImpl.getInstance();
        List<ScraperDTO> locationList = webScraper.teamScraper();
        locationList.forEach(a -> {
            NBA_Location location = new NBA_Location(a.getLocation());
            locationDAO.createLocation(location);
        });
        return  locationList;
    }

}
