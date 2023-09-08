package ra.springboot.Model.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRequest {
    @NotEmpty
    private String name;
    @Pattern(regexp = "^(.+)@(\\S+)$" ,message = "Email is not valid")
    private String email;
    @Pattern(regexp = "^0\\d{10}$", message = "Phone is not valid")
    private String phone;
    private boolean sex;
}
