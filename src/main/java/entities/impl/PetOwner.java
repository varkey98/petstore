package entities.impl;

import entities.Person;
import lombok.Data;

import java.util.List;
@Data
public class PetOwner extends Person {
    List<Pet> pets;
}
