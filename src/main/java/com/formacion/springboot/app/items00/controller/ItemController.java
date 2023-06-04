package com.formacion.springboot.app.items00.controller;

import com.formacion.springboot.app.items00.models.Item;
import com.formacion.springboot.app.items00.models.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;
    @GetMapping("/listar")
    public List<Item> obtenerItems(){
        return itemService.findAll();
    }

}
