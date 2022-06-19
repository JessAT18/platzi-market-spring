package com.jessat18.market.persistence.mapper;

import com.jessat18.market.domain.Category;
import com.jessat18.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
//Indicamos que es un componente de tipo Spring
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    //Indicamos como se convertirán los objetos de categoria a category
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    //Indica que la conversion es la inversa a la que se está realizando en la parte superior
    @Mapping(target = "productos", ignore = true)
    //Indicamos que no va a ir el campo productos de category a categoria
    Categoria toCategoria(Category category);
}
