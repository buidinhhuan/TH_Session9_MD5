package ra.springboot.Model.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.springboot.Model.Dto.Request.PersonRequest;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "phone", length = 11)
    private String phone;
    @Column(name = "sex")
    private boolean sex;


}
