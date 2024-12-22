package com.example.mongo.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
@AllArgsConstructor
public class Item {

    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;
}
