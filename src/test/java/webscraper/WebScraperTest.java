package webscraper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebScraperTest {

    // Validate that the WebScraper method returns the correct number of teams
    @Test
    public void testWebScraper(){
        WebScraper webScraper = new WebScraper();
        int size = webScraper.teamScraper().size();
        assertEquals(30, size);
    }

    // Validate that the teamScraper method returns the correct team name
    @Test
    public void testWebScraper2(){
        WebScraper webScraper = new WebScraper();
        String teamName = webScraper.teamScraper().get(0).getTeamName();
        assertEquals("Boston Celtics", teamName);
    }

    // Validate that the teamScraper method returns the correct location
    @Test
    public void testWebScraper3(){
        WebScraper webScraper = new WebScraper();
        String location = webScraper.teamScraper().get(0).getLocation();
        assertEquals("Boston, Massachusetts", location);
    }

    // Validate that the teamScraper method returns the correct arena
    @Test
    public void testWebScraper4(){
        WebScraper webScraper = new WebScraper();
        String arena = webScraper.teamScraper().get(0).getArena();
        assertEquals("TD Garden", arena);
    }

    // Validate that the scraper method returns the correct capacity

    @Test
    public void testWebScraper5(){
        WebScraper webScraper = new WebScraper();
        int capacity = webScraper.teamScraper().get(0).getCapacity();
        assertEquals(19156,capacity);
    }


    // Write a test to validate that the scraper method returns the correct number of players
    @Test
    public void testWebScraper6(){
        WebScraper webScraper = new WebScraper();
        int size = webScraper.teamScraper().size();
        assertEquals(30, size);
    }



}