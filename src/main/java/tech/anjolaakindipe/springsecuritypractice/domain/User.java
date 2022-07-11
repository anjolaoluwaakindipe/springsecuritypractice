package tech.anjolaakindipe.springsecuritypractice.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    @DocumentReference(lazy = false)
    private Collection<Role> roles = new ArrayList<>();
}
