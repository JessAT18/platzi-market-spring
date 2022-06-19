package com.jessat18.market.persistence;

import com.jessat18.market.persistence.crud.ProductoCrudRepository;
import com.jessat18.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
