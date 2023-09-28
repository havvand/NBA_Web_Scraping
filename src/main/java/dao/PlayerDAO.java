package dao;

import model.NBA_Player;

public interface PlayerDAO {
    int createPlayer(NBA_Player player);

    NBA_Player readPlayer(int id);

    void deletePlayer(int id);
}
