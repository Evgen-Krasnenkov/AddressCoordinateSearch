package evgen.krasnenkov.service.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import evgen.krasnenkov.model.Coordinate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CoordinateApiService {
    private static final String PARAMETERS = "?format=json&addressdetails=1"
            + "&limit=4&accept-language=en";
    @Value("${coordinates.url}")
    private String url;

    public Optional<Coordinate> getCoordinatesByAddress(String address) {
        HttpGet request = new HttpGet(url + address + PARAMETERS);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                String result = EntityUtils.toString(httpEntity);
                List<LinkedHashMap<String, Object>> list = objectMapper.readValue(result, List.class);
                List<Coordinate> coordinates = new ArrayList<>();
                Coordinate coordinate = new Coordinate();
                for (Map<String, Object> map : list) {
                    coordinate.setLatitude(map.get("lat").toString());
                    coordinate.setLongitude(map.get("lon").toString());
                }
                return Optional.ofNullable(coordinate);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot get coordinates by address:" + address, e);
        }
        return Optional.empty();
    }
}
