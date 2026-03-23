package com.duoc.tienda.controladores;

import com.duoc.tienda.dto.ProductoDto;
import com.duoc.tienda.servicios.TiendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class TiendaController {

    private TiendaService servicio;

    public TiendaController(TiendaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/productos")
    public List<ProductoDto> verProductos() {
        return servicio.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ProductoDto verProducto(@PathVariable Long id) {
        return servicio.verProducto(id);
    }

    @PostMapping("/comprar/{id}")
    public String comprar(@PathVariable Long id) {
        return servicio.comprarProducto(id);
    }

}
