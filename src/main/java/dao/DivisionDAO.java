package dao;

import model.NBA_Division;

import java.util.List;

public interface DivisionDAO {
    int createDivision(NBA_Division division);

    int readDivision(NBA_Division division);

    NBA_Division updateDivision(NBA_Division division);

    void deleteDivision(int id);

    List<NBA_Division> getAllDivisions();
}
