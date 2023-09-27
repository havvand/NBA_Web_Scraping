package dao;

import model.NBA_Location;

public interface LocationDAO {
    int createLocation(NBA_Location location);

    int readLocation(NBA_Location location);

    NBA_Location updateLocation(NBA_Location location);

    void deleteLocation(int id);
}
