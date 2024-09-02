package com.ajinkya.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
public class Journal {



    @Id
    ObjectId id;
    String content;
    String description;
    LocalDateTime date;


}
