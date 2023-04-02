package repositories.impl;

import entities.impl.PetOwner;
import org.springframework.stereotype.Repository;
import repositories.AbstractHibernateDao;

@Repository
public class PetOwnerDao extends AbstractHibernateDao<PetOwner> {
    public PetOwnerDao() {
        setClazz(PetOwner.class);
    }
}
