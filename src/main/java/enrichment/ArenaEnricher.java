package enrichment;

import APIReader.TeamAPIReader;
import dao.ArenaDAO;
import dao.ArenaDAOImpl;
import dao.TeamDAO;
import dao.TeamDAOImpl;
import dto.ScraperDTO;
import dto.TeamDTO;
import model.NBA_Arena;
import model.NBA_Team;
import webscraper.WebScraper;

import java.util.List;

public class ArenaEnricher {
    private WebScraper webScraper = new WebScraper();

    public List<ScraperDTO> arenaEnricher() {
        TeamAPIReader teamAPIReader = new TeamAPIReader();
        ArenaDAO arenaDAO = ArenaDAOImpl.getInstance();
        TeamDAO teamDAO = TeamDAOImpl.getInstance();
        List<ScraperDTO> arenaList = webScraper.teamScraper();
        List<TeamDTO> teamList = teamAPIReader.callToAPI();
        arenaList.forEach(a -> {
            NBA_Arena arena = new NBA_Arena(a.getArena(), a.getCapacity());
            arenaDAO.createArena(arena);
        });
        return  arenaList;
    }


  List<ScraperDTO> scraperList = webScraper.teamScraper();
}
