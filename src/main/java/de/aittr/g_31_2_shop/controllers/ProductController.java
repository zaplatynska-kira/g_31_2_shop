package de.aittr.g_31_2_shop.controllers;

import de.aittr.g_31_2_shop.domain.dto.ProductDto;
import de.aittr.g_31_2_shop.exception_handling.Response;
import de.aittr.g_31_2_shop.exception_handling.exceptions.FirstTestException;
import de.aittr.g_31_2_shop.services.interfaces.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductDto save(@Valid @RequestBody ProductDto product) {
        return service.save(product);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return service.getAllActiveProducts();
    }
    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable int id){
        return service.getActiveProductById(id);

    }
    @PutMapping
    public void update(@RequestBody ProductDto dto){
        service.update(dto);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }
    @DeleteMapping("/delete/{name}")
    public void deleteByName(@PathVariable String name){
        service.deleteByName(name);
    }
    @PutMapping("/{id}")
    public void restoreByName(@PathVariable int id){
        service.deleteById(id);
    }

    // 1  способ обработки ошибок
@ExceptionHandler(FirstTestException.class)
@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Response handleException(FirstTestException e){
return  new Response(e.getMessage());

    }
    @GetMapping("/count")
    public int getCount(){
        return service.getActiveProductCount();
    }

    @GetMapping("/total")
    public double getTotalPrice(){
        return service.getActiveProductTotalPrice();
    }
    @GetMapping("/average")
public double getAveragePrice(){
        return service.getActiveProductAveragePrice();
}
}