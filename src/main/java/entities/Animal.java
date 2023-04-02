/* (C)2023 */
package entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Animal {


  @Id
  @Column(unique = true, nullable = false)
  int id;

  @Column(nullable = false)
  String name;


  public Animal(int id, String name) {
    this.name = name;
    this.id = id;
  }

  public Animal() {}

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
