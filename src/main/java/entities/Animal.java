/* (C)2023 */
package entities;

import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {}
}
