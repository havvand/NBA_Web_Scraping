package enrichment;

import APIReader.TeamAPIReader;
import dao.TeamDAO;
import dao.TeamDAOImpl;
import dto.TeamDTO;
import model.NBA_Team;
import webscraper.WebScraper;

import java.util.List;

public class TeamEnricher {
    private WebScraper webScraper = new WebScraper();

    public List<TeamDTO> teamEnricher() {
        TeamDAO teamDAO = TeamDAOImpl.getInstance();
        TeamAPIReader teamAPIReader = new TeamAPIReader();
        List<TeamDTO> teamList = teamAPIReader.callToAPI();
        teamList.forEach(t -> {
            int id = Integer.parseInt(t.getId());
            NBA_Team team = new NBA_Team(t.getFull_name(), t.getAbbreviation());
            team.setId(id);
            teamDAO.createTeam(team);

        });
        return teamList;
    }
}
