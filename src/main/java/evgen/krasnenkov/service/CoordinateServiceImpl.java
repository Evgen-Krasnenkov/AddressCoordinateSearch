package evgen.krasnenkov.service;

import evgen.krasnenkov.exception.DataProcessingException;
import evgen.krasnenkov.model.Coordinate;
import evgen.krasnenkov.repository.CoordinateRepository;
import evgen.krasnenkov.service.api.CoordinateApiService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoordinateServiceImpl implements CoordinateService {
    private final CoordinateApiService coordinateApiService;
    private final CoordinateRepository coordinateRepository;

    @Override
    public Coordinate getCoordinatesByAddress(String address) {
        Coordinate coordinate = coordinateApiService.getCoordinatesByAddress(address).orElseThrow(() ->
                new DataProcessingException("Cannot get coordinate by address: " + address));
        saveCoordinate(coordinate);
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
