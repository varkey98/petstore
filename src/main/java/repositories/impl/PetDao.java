package repositories.impl;

import entities.impl.Pet;
import org.springframework.stereotype.Repository;
import repositories.AbstractHibernateDao;

@Repository
public class PetDao extends AbstractHibernateDao<Pet> {
  public PetDao() {
    setClazz(Pet.class);
  }
}
