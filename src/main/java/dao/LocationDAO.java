package dao;

import model.NBA_Location;

import java.util.List;

public interface LocationDAO {
    int createLocation(NBA_Location location);

    NBA_Location readLocation(int id);

    NBA_Location updateLocation(NBA_Location location);

    void deleteLocation(int id);

    List<NBA_Location> getAllLocations();
}
