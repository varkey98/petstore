/* (C)2023 */
package entities.impl;

import entities.Person;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PETOWNER")
public class PetOwner extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    List<Pet> pets;

    public PetOwner() {}

    public PetOwner(long id, String firstName, String lastName, int phone, List<Pet> pets) {
        super(id, firstName, lastName, phone);
        this.id = id;
        this.pets = pets;
    }
}
