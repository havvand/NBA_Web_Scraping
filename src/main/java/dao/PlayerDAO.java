package dao;

import model.NBA_Player;

import java.util.List;

public interface PlayerDAO {
    int createPlayer(NBA_Player player);

    NBA_Player readPlayer(int id);

    void deletePlayer(int id);

    List<NBA_Player> getAllPlayers();
}
