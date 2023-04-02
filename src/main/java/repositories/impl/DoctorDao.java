package repositories.impl;

import entities.impl.Doctor;
import org.springframework.stereotype.Repository;
import repositories.AbstractHibernateDao;

@Repository
public class DoctorDao extends AbstractHibernateDao<Doctor> {
    public DoctorDao() {
        setClazz(Doctor.class);
    }
}
