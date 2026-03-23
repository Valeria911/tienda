package com.duoc.tienda.servicios;

import com.duoc.tienda.cliente.ProductoClient;
import com.duoc.tienda.dto.ProductoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService {

    private ProductoClient cliente;

    public TiendaService(ProductoClient cliente) {
        this.cliente = cliente;
    }

    public List<ProductoDto> listarProductos() {
        return cliente.obtenerProductos();
    }

    public ProductoDto verProducto(Long id) {
        return cliente.obtenerProducto(id);
    }

    public String comprarProducto(Long id) {
        ProductoDto p = cliente.obtenerProducto(id);
        return "Compra realizada exitosamente: " + p.getNombre();
    }



}
