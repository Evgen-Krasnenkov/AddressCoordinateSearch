package evgen.krasnenkov.model.dto;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
public class AddressResponseDto {
    Map<String, String> address;
}
