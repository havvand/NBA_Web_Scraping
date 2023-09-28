package dao;

import model.NBA_Team;

public interface TeamDAO {
    int createTeam(NBA_Team team);

    int readTeam(NBA_Team team);

    NBA_Team updateTeam(NBA_Team team);

    void deleteTeam(int id);

}
