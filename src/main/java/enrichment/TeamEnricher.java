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
        List<NBA_Division> divisions = divisionDAO.getAllDivisions();
        List<NBA_Location> locations = locationDAO.getAllLocations();
        List<NBA_Arena> arenas = arenaDAO.getAllArenas();
        teamList.forEach(t -> {
            int id = Integer.parseInt(t.getId());
            NBA_Team team = new NBA_Team(id, t.getFull_name(), t.getAbbreviation());
            divisions.forEach(d -> {
                if(d.getDivisionName().equals(t.getDivision())) {
                    team.setDivision(d);
                }
            });
            locations.forEach(l -> {
                if(l.getLocation().contains(t.getCity())) {
                    team.setLocation(l);
                }
                else if(team.getName().equals("LA Clippers")) {
                    NBA_Location loc = locationDAO.readLocation(21);
                    team.setLocation(loc);

                }
                else if(team.getName().equals("Golden State Warriors"))  {
                    NBA_Location loc = locationDAO.readLocation(20);
                    team.setLocation(loc);
                }
                else if(team.getName().equals("Brooklyn Nets")) {
                    NBA_Location loc = locationDAO.readLocation(2);
                    team.setLocation(loc);
                }
            });
            teamDAO.createTeam(team);
        });
        return teamList;
    }


}
