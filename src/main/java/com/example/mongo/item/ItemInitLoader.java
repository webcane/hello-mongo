package com.example.mongo.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cane
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ItemInitLoader {

    private static final List<Item> allItems = new ArrayList<>();

    private final ItemRepository repo;

    private static Item getItem(String name, int quantity, String category) {
        return Item.builder().name(name).quantity(quantity).category(category).build();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent() {
        List<Item> existedItems = this.repo.findAll();
        log.info("Number of items: " + existedItems.size());

        if (existedItems.isEmpty()) {
            allItems.add(getItem("item1", 1, "other"));
            allItems.add(getItem("item2", 5, "other"));
            allItems.add(getItem("item3", 2, "other"));

            log.info("Populate articles");
            for (Item a : allItems) {
                Item a2 = repo.save(a);
                log.info("{} added ", a2);
            }
        }
    }
}
