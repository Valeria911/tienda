package com.duoc.tienda.controladores;

import com.duoc.tienda.entidades.Producto;
import com.duoc.tienda.servicios.TiendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tienda")
public class TiendaController {

    private final TiendaService servicio;

    public TiendaController(TiendaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> verProductos() {
        return ResponseEntity.ok(servicio.listarProductos());
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> verProducto(@PathVariable Long id) {
        Optional<Producto> producto = servicio.verProducto(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/comprar/{id}")
    public ResponseEntity<String> comprar(@PathVariable Long id) {
        String resultado = servicio.comprarProducto(id);
        if (resultado.startsWith("Error")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }

}
