package enrichment;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import dao.PlayerDAO;
import dao.PlayerDAOImpl;
import dao.TeamDAO;
import dao.TeamDAOImpl;
import dto.PlayerDTO;
import APIReader.PlayerAPIReader;
import model.NBA_Player;
import model.NBA_Team;

import java.util.List;
import java.util.Map;

public class PlayerEnricher {
    PlayerDAO playerDAO = PlayerDAOImpl.getInstance();
    PlayerAPIReader playerApiReader = new PlayerAPIReader();
    List<PlayerDTO> playerList = playerApiReader.callToAPI();

    public PlayerEnricher(){

    }

    public void methodOne(){
        TeamDAO teamDAO = TeamDAOImpl.getInstance();
        List< NBA_Team> teams = teamDAO.getAllTeams();
        Gson gson = new Gson();
        playerList.forEach(p -> {
            // Extract the team id from the team JSON string
            LinkedTreeMap<String, Object> teamMap = (LinkedTreeMap<String, Object>) p.getTeam();
            String teamJson = gson.toJson(teamMap);
            int teamId = extractTeamId(teamJson);
            teamId -= 1;
            // Create an NBA_Player object and set the team_id
            if (teamId >= 0 && teamId < teams.size()) {
                NBA_Player player = new NBA_Player(p.getFirst_name(), p.getLast_name(), p.getPosition());
                player.setTeam(teams.get(teamId));
                playerDAO.createPlayer(player);
            } else {
                // Handle the case where teamId is out of bounds or invalid
                System.err.println("Invalid teamId: " + teamId);
            }
        });

    }

    private int extractTeamId(String teamJson) {
        try {
            // Parse the JSON string using Gson
            Gson gson = new Gson();
            Map<String, Object> teamMap = gson.fromJson(teamJson, new TypeToken<Map<String, Object>>() {}.getType());

            // Extract the "id" field from the map
            Object idObject = teamMap.get("id");

            if (idObject instanceof Double) {
                // Convert the id to an integer
                return ((Double) idObject).intValue();
            } else if (idObject instanceof Integer) {
                return (Integer) idObject;
            } else {
                throw new NumberFormatException("Invalid id format");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle parsing errors gracefully
        }
    }



}

