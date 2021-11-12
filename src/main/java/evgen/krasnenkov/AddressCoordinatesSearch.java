package evgen.krasnenkov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCaching
@RestController
public class AddressCoordinatesSearch {

    @RequestMapping("/")
    public String home() {
        return "Coordinate Search!";
    }

    public static void main(String[] args) {
        SpringApplication.run(AddressCoordinatesSearch.class, args);
    }

}
