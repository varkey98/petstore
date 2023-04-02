/* (C)2023 */
package entities.impl;

import entities.Person;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PETOWNER")
public class PetOwner extends Person {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  List<Pet> pets;

  public PetOwner() {}

  public PetOwner(int id, String firstName, String lastName, int phone, List<Pet> pets) {
    super(id, firstName, lastName, phone);
    this.pets = pets;
  }
}
