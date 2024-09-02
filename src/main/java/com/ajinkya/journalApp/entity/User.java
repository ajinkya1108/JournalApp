package com.ajinkya.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection="users")
@NoArgsConstructor
public class User {
    @Id
    ObjectId objectId;
    @NonNull
    @Indexed(unique = true)
    String username;
    @NonNull
    String Password;
    @DBRef
    List<Journal> journalList=new ArrayList<>();
}
