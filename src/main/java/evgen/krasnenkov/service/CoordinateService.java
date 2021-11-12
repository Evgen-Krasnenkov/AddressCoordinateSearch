package evgen.krasnenkov.service;

import evgen.krasnenkov.model.Coordinate;
import java.util.List;

public interface CoordinateService {
    Coordinate getCoordinatesByAddress(String address);

    Coordinate saveCoordinate(Coordinate coordinate);

    List<Coordinate> getAllCoordinates();
}
