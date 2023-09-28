package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NBA_ArenaTest {

    @Test
    void testToString() {
        NBA_Arena arena = new NBA_Arena("Staples Center", 19060);
        assertEquals("NBA_Arena(id=0, arenaName=Staples Center, capacity=19060, teams=[])", arena.toString());
    }

}

