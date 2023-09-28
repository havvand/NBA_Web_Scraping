package dao;

import model.NBA_Team;

public interface TeamDAO {
    int createTeam(NBA_Team team);

    NBA_Team readTeam(int id);

    NBA_Team updateTeam(NBA_Team team);

    void deleteTeam(int id);

}
