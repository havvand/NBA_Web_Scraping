import APIReader.PlayerAPIReader;
import APIReader.TeamAPIReader;
import dao.*;
import dto.PlayerDTO;
import dto.ScraperDTO;
import dto.TeamDTO;
import enrichment.ArenaEnricher;
import enrichment.DivisionEnricher;
import enrichment.LocationEnricher;
import enrichment.TeamEnricher;
import model.*;
import webscraper.WebScraper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        TeamDAO teamDAO = TeamDAOImpl.getInstance();
        PlayerDAO playerDAO = PlayerDAOImpl.getInstance();
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
        list.forEach(l -> {
          NBA_Player player = new NBA_Player(l.getFirst_name(), l.getLast_name(), l.getPosition());
          playerDAO.createPlayer(player);
      });

//        TeamAPIReader teamAPIReader = new TeamAPIReader();
//        List<TeamDTO> teamList = teamAPIReader.callToAPI();
//        teamList.forEach(t -> {
//                    int id = Integer.parseInt(t.getId());
//                    NBA_Team team = new NBA_Team(t.getFull_name(), t.getAbbreviation());
//                    team.setId(id);
//                    teamDAO.createTeam(team);
//                    NBA_Division division = new NBA_Division(t.getDivision());
//                    if(t.getConference().matches("East")) {
//                        division.setConference(NBA_Conference.EASTERN);
//                    } else {
//                        division.setConference(NBA_Conference.WESTERN);
//                    }
//                    divisionDAO.createDivision(division);
//        });
//        ArenaEnricher ae = new ArenaEnricher();
//        ae.arenaEnricher();
//        LocationEnricher le = new LocationEnricher();
//        le.locationEnricher();
//        DivisionEnricher div = new DivisionEnricher();
//        div.divisionEnricher();
//        TeamEnricher te = new TeamEnricher();
//        te.teamEnricher();
    }



}
