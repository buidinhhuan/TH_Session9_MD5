package ra.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.springboot.Model.Domain.Person;

@Repository
public interface IPersonRepsository extends JpaRepository<Person, Long> {
boolean existsByEmail(String email);
boolean existsByPhone(String phone);
}
