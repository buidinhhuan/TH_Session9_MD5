package ra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import ra.Model.Dto.Request.ProductRequest;
import ra.Model.Dto.Response.ProductResponse;
import ra.Service.IProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v7/products")
public class PersonController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> add(@RequestBody @Valid ProductRequest productRequest)  {
        return new ResponseEntity<>(productService.save(productRequest), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@RequestBody @Valid ProductRequest productRequest, @PathVariable Long id)  {
        return new ResponseEntity<>(productService.update(productRequest, id), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> delete(@PathVariable Long id) {
        return new ResponseEntity<>(productService.delete(id), HttpStatus.OK);
    }
}
