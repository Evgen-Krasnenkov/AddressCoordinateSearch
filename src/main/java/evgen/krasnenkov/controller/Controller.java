package evgen.krasnenkov.controller;

import evgen.krasnenkov.model.Address;
import evgen.krasnenkov.model.Coordinate;
import evgen.krasnenkov.model.dto.AddressRequestDto;
import evgen.krasnenkov.model.dto.AddressResponseDto;
import evgen.krasnenkov.model.dto.CoordinateResponseDto;
import evgen.krasnenkov.service.AddressService;
import evgen.krasnenkov.service.CoordinateService;
import evgen.krasnenkov.service.mapper.CoordinateMapper;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    private final CoordinateService coordinateService;
    private final CoordinateMapper coordinateMapper;
    private final AddressService addressService;

    public Controller(CoordinateService coordinateService, CoordinateMapper coordinateMapper, AddressService addressService) {
        this.coordinateService = coordinateService;
        this.coordinateMapper = coordinateMapper;
        this.addressService = addressService;
    }

    @PostMapping("/coordinate")
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
        coordinateService.saveCoordinate(coordinatesByAddress);
        return coordinateMapper.mapToDto(coordinatesByAddress);
    }

    @GetMapping("/address")
    public List<AddressResponseDto> getAddressForAllStored() {
        return addressService.getAllFromApi(coordinateService.getAllCoordinates());
    }
}
