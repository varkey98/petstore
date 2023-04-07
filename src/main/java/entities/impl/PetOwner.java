/* (C)2023 */
package entities.impl;

import entities.Person;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "PETOWNER")
public class PetOwner extends Person implements Serializable {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
  List<Pet> pets;

  public PetOwner() {}

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }

  public PetOwner(int id, String firstName, String lastName, int phone, List<Pet> pets) {
    super(id, firstName, lastName, phone);
    this.pets = pets;
  }
}
