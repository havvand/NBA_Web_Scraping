package enrichment;

import dao.ArenaDAO;
import dao.ArenaDAOImpl;
import dto.ScraperDTO;
import model.NBA_Arena;
import webscraper.WebScraper;

import java.util.List;

public class Enricher {
    private WebScraper webScraper = new WebScraper();

    public List<ScraperDTO> arenaEnricher() {
        ArenaDAO arenaDAO = ArenaDAOImpl.getInstance();
        List<ScraperDTO> arenaList = webScraper.teamScraper();
        arenaList.forEach(a -> {
            NBA_Arena arena = new NBA_Arena(a.getArena(), a.getCapacity());
            arenaDAO.createArena(arena);
        });
        return  arenaList;
    }

    public List<ScraperDTO> locationEnricher() {
        return null;
    }
  List<ScraperDTO> scraperList = webScraper.teamScraper();
}
