package de.aittr.g_31_2_shop.services.jpa;

import de.aittr.g_31_2_shop.domain.dto.ProductDto;
import de.aittr.g_31_2_shop.domain.interfaces.Product;
import de.aittr.g_31_2_shop.domain.jpa.JpaProduct;
import de.aittr.g_31_2_shop.domain.jpa.Task;
import de.aittr.g_31_2_shop.exception_handling.exceptions.FourTestException;
import de.aittr.g_31_2_shop.exception_handling.exceptions.ProductValidationException;
import de.aittr.g_31_2_shop.exception_handling.exceptions.ThirdTestException;
import de.aittr.g_31_2_shop.repositories.jpa.JpaProductRepository;
import de.aittr.g_31_2_shop.scheduling.ScheduleExecutor;
import de.aittr.g_31_2_shop.services.interfaces.ProductService;
import de.aittr.g_31_2_shop.services.mapping.ProductMappingService;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaProductService implements ProductService {

    private JpaProductRepository repository;
    private ProductMappingService mappingService;
    //private Logger logger= LogManager.getLogger(JpaProductService.class);
private Logger logger= LoggerFactory.getLogger(JpaProductService.class);
    public JpaProductService(JpaProductRepository repository, ProductMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }

    @Override
    public ProductDto save(ProductDto dto) {
        try {
            JpaProduct entity = mappingService.mapDtoToJpaProduct(dto);
            entity.setID(0);
            entity = repository.save(entity);
            return mappingService.mapProductEntityToDto(entity);

        } catch (Exception e){
            throw new ProductValidationException("Incorrect values of product fields", e);
        }

    }


    @Override
    public List<ProductDto> getAllActiveProducts() {

        Task task = new Task("Method getAllActiveProducts called");
        ScheduleExecutor.scheduleAndExecuteTask(task);
//здесь будет джоин поинт и будет внедряться дополнительный код

        return repository.findAll()
                .stream()
                .filter(p-> p.isActive())
                .map(p->mappingService.mapProductEntityToDto(p))
                .toList();
    }


    @Override
    public ProductDto getActiveProductById(int id) {


        //logger.log(Level.INFO, String.format("Запрошен продукт с идентификатором %d.",id));
        //logger.log(Level.WARN, String.format("Запрошен продукт с идентификатором %d.",id));
        //logger.log(Level.ERROR, String.format("Запрошен продукт с идентификатором %d.",id));

        //logger.info( String.format("Запрошен продукт с идентификатором %d.",id));
        //logger.warn( String.format("Запрошен продукт с идентификатором %d.",id));
        //logger.error( String.format("Запрошен продукт с идентификатором %d.",id));


        Product product = repository.findById(id).orElse(null);

if(product!= null&& product.isActive()){

    return mappingService.mapProductEntityToDto(product);
}
        throw new ThirdTestException("Продукт с указанным идентификатором отсутствует в базе данных");
    }

    @Override
    public void update(ProductDto dto) {
        JpaProduct entity = mappingService.mapDtoToJpaProduct(dto);
repository.save(entity);
    }

    //@Override
    //public void deleteById(int id) {
       // repository.deleteById(id);

   // }
   @Override
   @Transactional
    public void deleteById(int id){
        Product product= repository.findById(id).orElse(null);
        if ((product != null && product.isActive())) {
            product.setActive(false);
        }
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        Product product= repository.findByName(name);
        if (product != null && product.isActive()) {
            product.setActive(false);
        }
    }

    @Override
    @Transactional
    public void restoreById(int id) {
        Product product= repository.findById(id).orElse(null);
        if ((product != null && !product.isActive())) {
            product.setActive(true);
        }

    }

    @Override
    public int getActiveProductCount() {


        return (int) repository.findAll()
                .stream()
                .filter(p->p.isActive())
                .count();
    }

    @Override
    public double getActiveProductTotalPrice() {

        return repository.findAll()
                .stream()
                .filter(p->p.isActive())
                .mapToDouble(p->p.getPrice())
                .sum();
    }

    @Override
    public double getActiveProductAveragePrice() {

        return repository.findAll()
                .stream()
                .filter(p->p.isActive())
                .mapToDouble(p->p.getPrice())
                .average()
                .orElse(0);
    }
}
