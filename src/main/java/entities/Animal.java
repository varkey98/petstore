package entities;

import lombok.Data;

@Data
@MappedSuperClass
public class Animal {
    String name;
    Person owner;
 }
