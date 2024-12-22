package com.example.mongo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> save(final @RequestBody Item item) {
        return ResponseEntity.ok(itemRepository.save(item));
    }

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok(itemRepository.findAll());
    }
}
