package dao;

import model.NBA_Division;

public interface DivisionDAO {
    int createDivision(NBA_Division division);

    int readDivision(NBA_Division division);

    NBA_Division updateDivision(NBA_Division division);

    void deleteDivision(int id);
}
