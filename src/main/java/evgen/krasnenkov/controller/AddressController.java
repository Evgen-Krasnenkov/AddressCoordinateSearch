package evgen.krasnenkov.controller;

import evgen.krasnenkov.model.dto.AddressResponseDto;
import evgen.krasnenkov.service.AddressService;
import evgen.krasnenkov.service.CoordinateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class AddressController {
    public final AddressService addressService;
    public final CoordinateService coordinateService;

    @GetMapping("/addresses")
    public List<AddressResponseDto> getAddressForAllStored() {
        return addressService.getAllFromApi(coordinateService.getAllCoordinates());
    }
}
