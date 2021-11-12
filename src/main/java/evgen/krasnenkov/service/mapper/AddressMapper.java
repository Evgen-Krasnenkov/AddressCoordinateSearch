package evgen.krasnenkov.service.mapper;

import evgen.krasnenkov.model.Address;
import evgen.krasnenkov.model.dto.AddressRequestDto;

public class AddressMapper {
    public Address mapToModel(AddressRequestDto addressRequestDto) {
        Address address = new Address();
        address.setCountry(addressRequestDto.getCountry());
        address.setCity(addressRequestDto.getCity());
        address.setStreet(addressRequestDto.getStreet());
        address.setHouseNumber(addressRequestDto.getHouseNumber());
        return address;
    }
}
