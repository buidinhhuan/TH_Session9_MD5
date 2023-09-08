package ra.springboot.Model.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonResponse {
    private Long id;

    private String name;

    private String email;

    private String phone;

    private boolean sex;
}
