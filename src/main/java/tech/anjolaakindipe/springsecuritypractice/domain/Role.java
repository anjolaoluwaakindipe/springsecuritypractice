package tech.anjolaakindipe.springsecuritypractice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    @Id
    private String id;
    private String name;
}
