package com.shop_wee_cameron.components;

import com.shop_wee_cameron.models.Item;
import com.shop_wee_cameron.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ItemRepository itemRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args){

        Item standard_tee = new Item(name:"The Wee Cameron Tee");
        ItemRepository.save(standard_tee);
    }
}
