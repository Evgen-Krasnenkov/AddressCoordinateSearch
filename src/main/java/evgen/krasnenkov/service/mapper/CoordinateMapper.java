package evgen.krasnenkov.service.mapper;

import evgen.krasnenkov.model.Coordinate;
import evgen.krasnenkov.model.dto.CoordinateResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CoordinateMapper {
    public CoordinateResponseDto mapToDto(Coordinate coordinate) {
        CoordinateResponseDto coordinateResponseDto = new CoordinateResponseDto();
        coordinateResponseDto.setLatitude(coordinate.getLatitude());
        coordinateResponseDto.setLongitude(coordinate.getLongitude());
        return coordinateResponseDto;
    }
}
