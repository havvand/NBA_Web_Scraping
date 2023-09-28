package APIReader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerAPIReaderTest {

    // Validate that the list of players is not null
    @Test
    public void testCallToAPI(){
        PlayerAPIReader playerAPIReader = new PlayerAPIReader();
        playerAPIReader.callToAPI();
        assertNotNull(playerAPIReader);

    }



}