package ra.Service.Mapper;

import org.springframework.stereotype.Component;
import ra.Model.Domain.Product;
import ra.Model.Dto.Request.ProductRequest;
import ra.Model.Dto.Response.ProductResponse;
import ra.Service.IGenricMapper;

@Component
public class ProductMapper implements IGenricMapper<Product, ProductRequest, ProductResponse> {
    @Override
    public Product toEntity(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .producer(productRequest.getProducer()).build();
    }

    @Override
    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .producer(product.getProducer()).build();
    }
}
