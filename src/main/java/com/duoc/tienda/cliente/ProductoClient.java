package com.duoc.tienda.cliente;

import com.duoc.tienda.dto.ProductoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (name = "productos", url =
"http://localhost:8081/api/productos")
public interface ProductoClient {


    @GetMapping
    List<ProductoDto> obtenerProductos();

    @GetMapping("/{id}")
    ProductoDto obtenerProducto(@PathVariable Long id);

}
