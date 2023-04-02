/* (C)2023 */
package entities.impl;

import entities.Animal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="PET")
public class Pet extends Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    long id;

    @ManyToOne(targetEntity = PetOwner.class)
    private PetOwner owner;

    @ManyToOne(targetEntity = Doctor.class)
    private Doctor doctor;

    public Pet() {}

    public Pet(long id, String name, Doctor doctor, PetOwner owner) {
        super(name);
        this.id = id;
        this.doctor = doctor;
        this.owner = owner;
    }
}
