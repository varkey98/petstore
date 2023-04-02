package repositories;

import entities.impl.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetDao extends CrudRepository<Pet, Long> {
}
