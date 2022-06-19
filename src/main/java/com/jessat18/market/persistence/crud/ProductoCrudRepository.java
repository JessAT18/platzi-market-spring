package com.jessat18.market.persistence.crud;

import com.jessat18.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {
}
