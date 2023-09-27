import APIReader.PlayerAPIReader;
import dao.*;
import dto.PlayerDTO;
import dto.ScraperDTO;
import model.*;
import webscraper.WebScraper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        TeamDAO teamDAO = TeamDAOImpl.getInstance();
//        PlayerDAO playerDAO = PlayerDAOImpl.getInstance();
//        DivisionDAO divisionDAO = DivisionDAOImpl.getInstance();
//        ArenaDAO arenaDAO = ArenaDAOImpl.getInstance();
//        LocationDAO locationDAO = LocationDAOImpl.getInstance();
//        WebScraper webScraper = new WebScraper();
//        List<ScraperDTO> scraperList = webScraper.teamScraper();
//        scraperList.forEach(s -> {
//            NBA_Arena arena = new NBA_Arena(s.getArena(), s.getCapacity());
//            arenaDAO.createArena(arena);
//            NBA_Location location = new NBA_Location(s.getLocation());
//            locationDAO.createLocation(location);
//        });
        PlayerAPIReader apiReader = new PlayerAPIReader();
        List<PlayerDTO> list = apiReader.callToAPI();
        list.forEach(System.out::println);


    }


}
