package enrichment;

import dao.LocationDAO;
import dao.LocationDAOImpl;
import dto.ScraperDTO;
import model.NBA_Location;
import model.NBA_Team;
import webscraper.WebScraper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LocationEnricher {
    private WebScraper webScraper = new WebScraper();
    private List<ScraperDTO> locationList = webScraper.teamScraper();
    public List<ScraperDTO> locationEnricher() {
        LocationDAO locationDAO = LocationDAOImpl.getInstance();
        locationList = webScraper.teamScraper();
        Set<String> locationNames = new HashSet<>();
        locationList.removeIf(t -> !locationNames.add(t.getLocation()));
        locationList.forEach(a -> {
            NBA_Location location = new NBA_Location(a.getLocation());
            locationDAO.createLocation(location);
        });
        return  locationList;
    }

    public void addLocationToTeam() {

    }

}
