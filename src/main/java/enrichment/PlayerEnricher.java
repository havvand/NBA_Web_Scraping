package enrichment;

import dao.PlayerDAO;
import dao.PlayerDAOImpl;
import dao.TeamDAO;
import dao.TeamDAOImpl;
import dto.PlayerDTO;
import APIReader.PlayerAPIReader;
import model.NBA_Player;

import java.util.List;

public class PlayerEnricher {
    PlayerDAO playerDAO = PlayerDAOImpl.getInstance();
    PlayerAPIReader playerApiReader = new PlayerAPIReader();
    List<PlayerDTO> playerList = playerApiReader.callToAPI();

    public PlayerEnricher(){

    }

    public void methodOne(){

        playerList.forEach(p -> {
            NBA_Player player = new NBA_Player(p.getFirst_name(), p.getLast_name(), p.getPosition());
            playerDAO.createPlayer(player);
        });

    }


}

