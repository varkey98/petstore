/* (C)2023 */
package entities.impl;

import entities.Person;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "DOCTOR")
public class Doctor extends Person implements Serializable {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
  private List<Pet> patients;

  public Doctor() {}

  public Doctor(int id, String firstName, String lastName, int phone, List<Pet> patients) {
    super(id, firstName, lastName, phone);
    this.patients = patients;
  }

  @Override
  public String toString() {
    return
        " firstName: "
        + super.getFirstName()
        + " lastName: "
        + super.getLastName()
        + " phone: "
        + super.getPhone();
  }
}
