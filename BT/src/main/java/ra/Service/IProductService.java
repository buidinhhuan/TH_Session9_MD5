package ra.Service;

import ra.Model.Dto.Request.ProductRequest;
import ra.Model.Dto.Response.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> findAll();

    ProductResponse findById(Long id);

    ProductResponse save(ProductRequest personRequest);

    ProductResponse update(ProductRequest personRequest, Long id);

    ProductResponse delete(Long id);

}
