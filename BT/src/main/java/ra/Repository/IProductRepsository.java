package ra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.Model.Domain.Product;

@Repository
public interface IProductRepsository extends JpaRepository<Product, Long> {

}
