package evgen.krasnenkov.service.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import evgen.krasnenkov.model.Coordinate;
import evgen.krasnenkov.model.dto.AddressResponseDto;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class AddressApi {
    public static final String ADDRESS_URL = "https://nominatim.openstreetmap.org/reverse?format=json&lat=";

    public Optional<AddressResponseDto> getAddressByCoordinate(Coordinate coordinate) {
        HttpGet request = new HttpGet(ADDRESS_URL + coordinate.getLatitude() + "&lon=" + coordinate.getLongitude());
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                String result = EntityUtils.toString(httpEntity);
                Map<String, String> map = (Map<String, String>) objectMapper.readValue(result, Map.class).get("address");
                AddressResponseDto addressResponseDto = new AddressResponseDto();
                addressResponseDto.setAddress(map);
                return Optional.ofNullable(addressResponseDto);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot get address by coordinate. Latitude: " + coordinate.getLatitude()
                    + ", longitude: " + coordinate.getLongitude(), e);
        }
        return Optional.empty();
    }
}
