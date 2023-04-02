/* (C)2023 */
package entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {

  @Id
  @Column(unique = true, nullable = false)
  int id;

  @Column(nullable = false)
  String firstName;

  @Column(nullable = false)
  String lastName;

  @Column(nullable = false)
  int phone;


  public Person(int id, String firstName, String lastName, int phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getPhone() {
    return phone;
  }

  public int getId() {
    return id;
  }

  public Person() {}
}
