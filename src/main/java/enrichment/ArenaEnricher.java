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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArenaEnricher {
    private WebScraper webScraper = new WebScraper();
    private List<ScraperDTO> arenaList = webScraper.teamScraper();
    private ArenaDAO arenaDAO = ArenaDAOImpl.getInstance();

    public List<ScraperDTO> arenaEnricher() {
        TeamAPIReader teamAPIReader = new TeamAPIReader();
        Set<String> arenaNames = new HashSet<>();
        arenaList.removeIf(t -> !arenaNames.add(t.getArena()));
        arenaList.forEach(a -> {
            NBA_Arena arena = new NBA_Arena(a.getArena(), a.getCapacity());
            arenaDAO.createArena(arena);
        });
        return  arenaList;
    }

    public void updateFK() {
        TeamDAO teamDAO = TeamDAOImpl.getInstance();
        List<NBA_Team> teams = teamDAO.getAllTeams();


    }
}
