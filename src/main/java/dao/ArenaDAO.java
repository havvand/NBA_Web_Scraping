package dao;

import model.NBA_Arena;

import java.util.List;

public interface ArenaDAO {
    int createArena(NBA_Arena arena);
    NBA_Arena readArena(int id);

    NBA_Arena updateArena(NBA_Arena arena);

    void deleteArena(int id);

    List<NBA_Arena> getAllArenas();
}
