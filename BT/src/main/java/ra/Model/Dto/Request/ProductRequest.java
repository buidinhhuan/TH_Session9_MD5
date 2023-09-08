package ra.Model.Dto.Request;

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
public class ProductRequest {
    @NotEmpty
    private String name;
    //    @Pattern(regexp = "^(.+)@(\\S+)$" ,message = "Email is not valid")
    private double price;
    //    @Pattern(regexp = "^0\\d{10}$", message = "Phone is not valid")
    private String description;
    private String producer;
}
