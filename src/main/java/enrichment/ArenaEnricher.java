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

    public List<ScraperDTO> arenaEnricher() {
        TeamAPIReader teamAPIReader = new TeamAPIReader();
        ArenaDAO arenaDAO = ArenaDAOImpl.getInstance();
        TeamDAO teamDAO = TeamDAOImpl.getInstance();
        List<ScraperDTO> arenaList = webScraper.teamScraper();
        List<NBA_Team> teams = teamDAO.getAllTeams();
        Set<String> arenaNames = new HashSet<>();
        arenaList.removeIf(t -> !arenaNames.add(t.getArena()));
        arenaList.forEach(a -> {
            NBA_Arena arena = new NBA_Arena(a.getArena(), a.getCapacity());
            teams.forEach(t -> {
                if(t.getName().equals(a.getTeamName())) {
                    t.setArena(arena);
                    arena.addTeam(t);
                }
            });
            arenaDAO.createArena(arena);
        });
        return  arenaList;
    }
}
