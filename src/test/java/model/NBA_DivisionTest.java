package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NBA_DivisionTest {

    @Test
    void testToString() {
        NBA_Division division = new NBA_Division("Pacific", NBA_Conference.WESTERN);
        assertEquals("NBA_Division(id=0, divisionName=Pacific, conference=WESTERN, teams=[])", division.toString());
    }


}