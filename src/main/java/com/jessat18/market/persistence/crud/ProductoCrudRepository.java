package com.jessat18.market.persistence.crud;

import com.jessat18.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    //List<Producto> getByCategoria(Long idCategoria);
    //Query method
    //List<Producto> findByIdCategoria(Long idCategoria);
    List<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Long cantidadStock, Boolean estado);
}
