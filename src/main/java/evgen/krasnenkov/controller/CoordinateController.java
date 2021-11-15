package evgen.krasnenkov.controller;

import evgen.krasnenkov.model.Coordinate;
import evgen.krasnenkov.model.dto.AddressRequestDto;
import evgen.krasnenkov.model.dto.CoordinateResponseDto;
import evgen.krasnenkov.service.CoordinateService;
import evgen.krasnenkov.service.mapper.CoordinateMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/coordinates")
public class CoordinateController {
    private final CoordinateService coordinateService;
    private final CoordinateMapper coordinateMapper;

    @PostMapping
    public CoordinateResponseDto getCoordinatesByAddress (@RequestBody AddressRequestDto addressRequestDto) {
        String address = addressRequestDto.getCountry()
                .concat("%20")
                .concat(addressRequestDto.getCity())
                .concat("%20")
                .concat(addressRequestDto.getStreet())
                .concat("%20")
                .concat(String.valueOf(addressRequestDto.getHouseNumber()))
                .replaceAll(" ", "%20");

        Coordinate coordinatesByAddress = coordinateService.getCoordinatesByAddress(address);
        return coordinateMapper.mapToDto(coordinatesByAddress);
    }
}
