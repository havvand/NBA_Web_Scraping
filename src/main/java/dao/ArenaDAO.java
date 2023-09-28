package dao;

import model.NBA_Arena;

public interface ArenaDAO {
    int createArena(NBA_Arena arena);
    int readArena(NBA_Arena arena);

    NBA_Arena updateArena(NBA_Arena arena);

    void deleteArena(int id);
}
