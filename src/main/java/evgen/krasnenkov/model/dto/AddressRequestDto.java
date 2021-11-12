package evgen.krasnenkov.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;


@ToString
@EqualsAndHashCode
@Getter
@Setter
public class AddressRequestDto {
    @NonNull
    private String country;
    @NonNull
    private String city;
    @NonNull
    private String street;
    @NonNull
    private Long houseNumber;
}
