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
}
