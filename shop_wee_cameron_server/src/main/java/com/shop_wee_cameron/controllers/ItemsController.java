package com.shop_wee_cameron.controllers;

import com.shop_wee_cameron.models.Item;
import com.shop_wee_cameron.repositories.ItemRepository;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemsController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> getAllItems(){
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/items/{id}")
    public ResponseEntity getItem(@PathVariable Long id){
        return new ResponseEntity<>(itemRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/items")
    public ResponseEntity<Item> postItem(@RequestBody Item item){
        ItemRepository.save(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/items/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long id) {
        Optional<Item> itemToDelete = ItemRepository.findById(id);
        itemRepository.delete(itemToDelete.get());
        return new ResponseEntity<>(itemToDelete.get(),HttpStatus.OK);
    }

    @PutMapping(value = "/items/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item updatedItem, @PathVariable Long id){
        Item existingItem = ItemRepository.findById(id).get();
        existingItem.setName(updatedItem.getName());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setCategory(updatedItem.setCategory());

    itemRepository.save(existingItem);

    return new ResponseEntity<>(existingItem, HttpStatus.OK);
    }
}
