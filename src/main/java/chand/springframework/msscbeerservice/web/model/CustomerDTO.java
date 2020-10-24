package chand.springframework.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private UUID id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String firstName;

    @NotBlank
    private String lastName;

    @Positive
    private int age;
    @NotNull
    private String location;

}
