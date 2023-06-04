package com.formacion.springboot.app.items00.models.service;

import com.formacion.springboot.app.items00.models.Item;
import com.formacion.springboot.app.items00.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl  implements ItemService{
    @Autowired
    private RestTemplate clienteRest;
    @Override
    public List<Item> findAll() {

        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar",Producto[].class));
       return productos.stream().map(producto -> {
            Item item = new Item();
            item.setProducto(producto);
            item.setCantidad(1);
            return item;
        }).collect(Collectors.toList());
    }
    public Item obtenerItem(Long id,Integer cantidad){
        Map<String ,String> mapa = new HashMap<>();
        mapa.put("id",id.toString());
       Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}",Producto.class, mapa);
       Item item = new Item();
       item.setCantidad(cantidad);
       item.setProducto(producto);
       return item;

    }
}
