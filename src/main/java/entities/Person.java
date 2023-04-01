package entities;

import lombok.Data;

@Data
@MappedSuperClass
public class Person {
    String firstName;
    String lastName;
    int phoneNumber;
}
