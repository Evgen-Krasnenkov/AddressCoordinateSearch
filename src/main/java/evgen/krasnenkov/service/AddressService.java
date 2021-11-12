package evgen.krasnenkov.service;

import evgen.krasnenkov.model.Address;
import evgen.krasnenkov.model.Coordinate;
import evgen.krasnenkov.model.dto.AddressResponseDto;
import java.util.List;

public interface AddressService {
    public Address saveToLocalDB(Address address);

    public List<Address> getAll();

    public List<AddressResponseDto> getAllFromApi(List<Coordinate> coordinatesFromDB);
}
