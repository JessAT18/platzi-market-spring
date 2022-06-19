package com.jessat18.market.persistence;

import com.jessat18.market.domain.Product;
import com.jessat18.market.domain.repository.ProductRepository;
import com.jessat18.market.persistence.crud.ProductoCrudRepository;
import com.jessat18.market.persistence.entity.Producto;
import com.jessat18.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//Indicamos a Spring que esta clase se encarga de interactuar con la base de datos.
//Component es una generalización de este tipo de anotaciones
public class ProductoRepository implements ProductRepository {
    @Autowired
    //Al ser un componente de Spring, podemos utilizar Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Long categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Long quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(Long productId) {
        productoCrudRepository.deleteById(productId);
    }
}
