package repositories;

import entities.impl.PetOwner;
import org.springframework.data.repository.CrudRepository;

public interface PetOwnerDao extends CrudRepository<PetOwner, Long> {
}
