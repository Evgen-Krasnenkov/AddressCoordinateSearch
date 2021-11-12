package evgen.krasnenkov.service;

import evgen.krasnenkov.exception.DataProcessingException;
import evgen.krasnenkov.model.Coordinate;
import evgen.krasnenkov.repository.CoordinateRepository;
import evgen.krasnenkov.service.api.CoordinateApi;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImpl implements CoordinateService {
    private final CoordinateApi coordinateApi;
    private final CoordinateRepository coordinateRepository;

    public CoordinateServiceImpl(CoordinateApi coordinateApi, CoordinateRepository coordinateRepository) {
        this.coordinateApi = coordinateApi;
        this.coordinateRepository = coordinateRepository;
    }

    @Override
    public Coordinate getCoordinatesByAddress(String address) {
        Coordinate coordinate = coordinateApi.getCoordinatesByAddress(address).orElseThrow(() ->
                new DataProcessingException("Cannot get coordinate by address: " + address));
        return coordinate;
    }

    @Override
    public Coordinate saveCoordinate(Coordinate coordinate) {
        return coordinateRepository.save(coordinate);
    }

    @Override
    public List<Coordinate> getAllCoordinates() {
        return coordinateRepository.findAll();
    }
}
