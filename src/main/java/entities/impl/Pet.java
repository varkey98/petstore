/* (C)2023 */
package entities.impl;

import entities.Animal;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity(name = "PET")
public class Pet extends Animal implements Serializable {

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

  public Doctor getDoctor() {
    return this.doctor;
  }

  public PetOwner getOwner() {
    return this.owner;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public void setOwner(PetOwner owner) {
    this.owner = owner;
  }
}
