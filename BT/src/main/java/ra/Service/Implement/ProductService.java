package ra.Service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.Model.Domain.Product;
import ra.Model.Dto.Request.ProductRequest;
import ra.Model.Dto.Response.ProductResponse;
import ra.Repository.IProductRepsository;
import ra.Service.IProductService;
import ra.Service.Mapper.ProductMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepsository iProductRepsository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductResponse> findAll() {
        return iProductRepsository.findAll().stream()
                .map(c -> productMapper.toResponse(c)).collect(Collectors.toList());

    }

    @Override
    public ProductResponse findById(Long id) {
        Optional<Product> product = iProductRepsository.findById(id);
        if (product.isPresent()) {
            return productMapper.toResponse(product.get());
        }
        return null;
    }


    @Override
    public ProductResponse save(ProductRequest personRequest) {
        Product person = iProductRepsository.save(productMapper.toEntity(personRequest));
        return productMapper.toResponse(person);
    }

    @Override
    public ProductResponse update(ProductRequest personRequest, Long id) {
        Product p = productMapper.toEntity(personRequest);
        p.setId(id);
        return productMapper.toResponse(iProductRepsository.save(p));
    }

    @Override
    public ProductResponse delete(Long id) {
        Optional<Product> p = iProductRepsository.findById(id);
        if (p.isPresent()) {
            iProductRepsository.deleteById(id);
            return productMapper.toResponse(p.get());
        }
        return null;
    }
}
