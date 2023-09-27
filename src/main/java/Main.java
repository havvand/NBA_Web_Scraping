import APIReader.PlayerAPIReader;
import dao.*;
import model.*;
import webscraper.WebScraper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TeamDAO teamDAO = TeamDAOImpl.getInstance();
        PlayerDAO playerDAO = PlayerDAOImpl.getInstance();
        DivisionDAO divisionDAO = DivisionDAOImpl.getInstance();
        ArenaDAO arenaDAO = ArenaDAOImpl.getInstance();
        LocationDAO locationDAO = LocationDAOImpl.getInstance();
        WebScraper webScraper = new WebScraper();
        List<WebScraper.ScraperDTO> scraperList = webScraper.teamScraper();
        scraperList.forEach(s -> {
            NBA_Arena arena = new NBA_Arena(s.getArena(), s.getCapacity());
            arenaDAO.createArena(arena);
            NBA_Location location = new NBA_Location(s.getLocation());
            locationDAO.createLocation(location);
        });
//        NBA_Team team = new NBA_Team("Brooklyn Nets", "BKN");
//        NBA_Team team2 = new NBA_Team("New York Knicks", "NYK");
//        NBA_Division division = new NBA_Division("Atlantic", NBA_Conference.EASTERN);
//        NBA_Arena arena = new NBA_Arena("Barclays Center", 17732);
//        NBA_Arena arena2 = new NBA_Arena("Madison Square Garden", 19812);
//        NBA_Location location = new NBA_Location("New York City, New York");
//        NBA_Player player = new NBA_Player("Jalen", "Wilson", "SF");
//        NBA_Player player2 = new NBA_Player("Josh", "Hart", "SG");
//        team.addPlayer(player);
//        team2.addPlayer(player2);
//        division.addTeam(team);
//        division.addTeam(team2);
//        arena.addTeam(team);
//        arena2.addTeam(team2);
//        location.addTeam(team);
//        location.addTeam(team2);
//        divisionDAO.createDivision(division);
//        arenaDAO.createArena(arena);
//        arenaDAO.createArena(arena2);
//        locationDAO.createLocation(location);
//        teamDAO.createTeam(team);
//        teamDAO.createTeam(team2);
//        playerDAO.createPlayer(player);
//        playerDAO.createPlayer(player2);

    }


}
