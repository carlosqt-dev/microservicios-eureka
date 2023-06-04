package com.formacion.springboot.app.items00.clientes;

import com.formacion.springboot.app.items00.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="servicio-productos",url="localhost:8080")
public interface ProductoClienteRest {
    @GetMapping("/listar")
    public List<Producto> listar();

}
