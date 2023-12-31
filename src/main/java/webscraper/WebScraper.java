package webscraper;

import dto.ScraperDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    private String url = "https://en.wikipedia.org/wiki/National_Basketball_Association";
    public static void main(String[] args) {
        List<ScraperDTO> list = new WebScraper().teamScraper();
        list.forEach(System.out::println);
    }
    public List<ScraperDTO> teamScraper() {
        List<ScraperDTO> scraperList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();

            Element table = doc.select("table.wikitable").first();

            Elements rows = table.select("tr:gt(0)");
            rows.forEach(r ->{
                Elements columns = r.select("td");
                String teamName, location, arena, capacity;
                if (columns.size() >= 4) {
                    teamName = columns.get(0).text();
                    location = columns.get(1).text();
                    arena = columns.get(2).text();
                    capacity = columns.get(3).text();
                    if (!location.contains(",")) {
                        location = "";
                        arena = columns.get(1).text();
                        capacity = columns.get(2).text();
                    }
                    if (arena.contains("°")) {
                        arena = "Crypto.com Arena";
                        capacity = "19,079";
                    }
                    if (arena.equals("Crypto.com Arena")) {
                        location = "Los Angeles, California";
                    }
                    if (arena.equals("Madison Square Garden")) {
                        location = "New York City, New York";
                    }
                   capacity = capacity.replace(",", "");
                    ScraperDTO scraperDTO = ScraperDTO.builder()
                            .teamName(teamName)
                            .location(location)
                            .arena(arena)
                            .capacity(Integer.parseInt(capacity))
                            .build();
                    scraperList.add(scraperDTO);

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return scraperList;
    }


}

