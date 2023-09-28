package APIReader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamAPIReaderTest {

    // Validate that method has a connection to the API
    @Test
    public void testCallToAPI(){
        TeamAPIReader teamAPIReader = new TeamAPIReader();
        teamAPIReader.main(null);
        assertNotNull(teamAPIReader);
    }


}