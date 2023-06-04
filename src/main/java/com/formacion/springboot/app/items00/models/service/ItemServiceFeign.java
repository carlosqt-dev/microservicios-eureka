package com.formacion.springboot.app.items00.models.service;

import com.formacion.springboot.app.items00.clientes.ProductoClienteRest;
import com.formacion.springboot.app.items00.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductoClienteRest clienteFeign;
    @Override
    public List<Item> findAll() {
        return clienteFeign.listar().stream().map(producto -> {
            Item item = new Item();
            item.setCantidad(1);
            item.setProducto(producto);
            return item;
        }) .collect(Collectors.toList());
    }
}
