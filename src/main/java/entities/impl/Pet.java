/* (C)2023 */
package entities.impl;

import entities.Animal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PET")
public class Pet extends Animal {

  @ManyToOne(targetEntity = PetOwner.class)
  private PetOwner owner;

  @ManyToOne(targetEntity = Doctor.class)
  private Doctor doctor;

  public Pet() {}

  public Pet(int id, String name, Doctor doctor, PetOwner owner) {
    super(id, name);
    this.doctor = doctor;
    this.owner = owner;
  }
}
