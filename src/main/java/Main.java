import APIReader.PlayerAPIReader;
import APIReader.TeamAPIReader;

public class Main {
    public static void main(String[] args) {
        PlayerAPIReader playerAPIReader = new PlayerAPIReader();
        TeamAPIReader teamAPIReader = new TeamAPIReader();

        playerAPIReader.callToAPI();
        //teamAPIReader.callToAPI();

    }
}
