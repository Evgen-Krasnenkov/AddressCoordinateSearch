package evgen.krasnenkov.service;

import evgen.krasnenkov.exception.DataProcessingException;
import evgen.krasnenkov.model.Address;
import evgen.krasnenkov.model.Coordinate;
import evgen.krasnenkov.model.dto.AddressResponseDto;
import evgen.krasnenkov.repository.AddressRepository;
import evgen.krasnenkov.service.api.AddressApiService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressApiService addressApiService;

    @Override
    public Address saveToLocalDB(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public List<AddressResponseDto> getAllFromApi(List<Coordinate> coordinatesFromDB) {
        return coordinatesFromDB.stream()
                        .map(coordinate -> addressApiService.getAddressByCoordinate(coordinate).orElseThrow(() ->
                                new DataProcessingException("Cannot map a coordinate to an address")))
                                .collect(Collectors.toList());
    }
}
