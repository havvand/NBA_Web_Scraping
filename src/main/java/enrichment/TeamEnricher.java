package enrichment;

import APIReader.TeamAPIReader;
import dao.*;
import dto.ScraperDTO;
import dto.TeamDTO;
import model.*;
import webscraper.WebScraper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamEnricher {
    private WebScraper webScraper = new WebScraper();
    private TeamAPIReader teamAPIReader = new TeamAPIReader();
    private List<ScraperDTO> scrapeList = webScraper.teamScraper();
    private ArenaDAO arenaDAO = ArenaDAOImpl.getInstance();
    private LocationDAO locationDAO = LocationDAOImpl.getInstance();
    private DivisionDAO divisionDAO = DivisionDAOImpl.getInstance();
    List<TeamDTO> teamList = teamAPIReader.callToAPI();
    private TeamDAO teamDAO = TeamDAOImpl.getInstance();

    public List<TeamDTO> enrich() {
        teamList.forEach(t -> {
            int id = Integer.parseInt(t.getId());
            NBA_Team team = new NBA_Team(id, t.getFull_name(), t.getAbbreviation());
            scrapeList.forEach(scraperDTO -> {
                if (team.getName().contains(scraperDTO.getTeamName())) {
                    NBA_Arena arena = new NBA_Arena(scraperDTO.getArena(), scraperDTO.getCapacity());
                    team.setArena(arena);
                    arenaDAO.createArena(arena);
                    NBA_Location location = new NBA_Location(scraperDTO.getLocation());
                    team.setLocation(location);
                    locationDAO.createLocation(location);
                }

            });
            teamDAO.createTeam(team);
        });
        return teamList;
    }

    public List<ScraperDTO> enrich2() {
        scrapeList.forEach(t -> {

            NBA_Team team = new NBA_Team(00, t.getTeamName(), "");
            NBA_Arena arena = new NBA_Arena(t.getArena(), t.getCapacity());
            NBA_Location location = new NBA_Location(t.getLocation());


        });
        return scrapeList;
    }

    public void enrichAbbreviationAndId() {
        TeamDAO teamDAO = TeamDAOImpl.getInstance();
        DivisionDAO divisionDAO = DivisionDAOImpl.getInstance();
        List<NBA_Division> list = divisionDAO.getAllDivisions();
        List<NBA_Team> nbaTeams = teamDAO.getAllTeams();



    }


}
