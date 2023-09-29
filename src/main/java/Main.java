import APIReader.TeamAPIReader;
import dao.*;
import dto.ScraperDTO;
import dto.TeamDTO;
import enrichment.*;
import webscraper.WebScraper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DivisionEnricher div = new DivisionEnricher();
        div.divisionEnricher();
        LocationEnricher loc = new LocationEnricher();
        loc.locationEnricher();
        TeamEnricher te = new TeamEnricher();
        te.enrich();
        ArenaEnricher ae = new ArenaEnricher();
        ae.arenaEnricher();
        PlayerEnricher pe = new PlayerEnricher();
        pe.methodOne();

    }



}
