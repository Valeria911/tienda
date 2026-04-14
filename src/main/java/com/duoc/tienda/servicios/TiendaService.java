package com.duoc.tienda.servicios;

import com.duoc.tienda.entidades.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaService {

    private final ProductoService productoService;

    public TiendaService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    public Optional<Producto> verProducto(Long id) {
        return productoService.obtenerProducto(id);
    }

    @Transactional
    public String comprarProducto(Long id) {
        Optional<Producto> productoOpt = productoService.obtenerProducto(id);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            if (productoService.reducirStock(id, 1)) {
                return "Compra realizada exitosamente: " + producto.getNombre();
            } else {
                return "Error: No hay stock disponible para " + producto.getNombre();
            }
        }
        return "Error: Producto no encontrado";
    }

}
