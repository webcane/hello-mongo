package com.example.mongo.item;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, Long> {
}
