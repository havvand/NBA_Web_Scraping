package enrichment;

import APIReader.TeamAPIReader;
import dao.DivisionDAO;
import dao.DivisionDAOImpl;
import dto.TeamDTO;
import model.NBA_Conference;
import model.NBA_Division;
import webscraper.WebScraper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DivisionEnricher {
    private WebScraper webScraper = new WebScraper();

    public List<TeamDTO> divisionEnricher() {
        TeamAPIReader teamAPIReader = new TeamAPIReader();
        List<TeamDTO> divisionList = teamAPIReader.callToAPI();
        Set<String> divisionNames = new HashSet<>();
        divisionList.removeIf(t -> !divisionNames.add(t.getDivision()));
        divisionList.forEach(t -> {
            DivisionDAO divisionDAO = DivisionDAOImpl.getInstance();
            NBA_Division division = new NBA_Division(t.getDivision());
            if(t.getConference().matches("East")) {
                division.setConference(NBA_Conference.EASTERN.toString());
            } else {
                division.setConference(NBA_Conference.WESTERN.toString());
            }
            divisionDAO.createDivision(division);
        });
        return divisionList;
    }
}
