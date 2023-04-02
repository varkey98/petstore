/* (C)2023 */
package entities.impl;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="DOCTOR")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    long id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    int phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Pet> patients;

    public Doctor() {}

    public Doctor(long id, String firstName, String lastName, int phone, List<Pet> patients) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.id = id;
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "id: " +id+" firstName: "+firstName+" lastName: "+lastName+" phone: "+ phone;
    }
}
