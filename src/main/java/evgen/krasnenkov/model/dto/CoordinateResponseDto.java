package evgen.krasnenkov.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class CoordinateResponseDto {
    private String latitude;
    private String longitude;
}
