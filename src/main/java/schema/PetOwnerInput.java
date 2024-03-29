package schema;

import entities.impl.PetOwner;
import java.util.ArrayList;

public class PetOwnerInput {
  int id;
  String firstName;
  String lastName;
  int phone;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }

  public PetOwner getOwnerObject() {
    return new PetOwner(
        this.getId(), this.getFirstName(), this.getLastName(), this.getPhone(), new ArrayList<>());
  }
}
