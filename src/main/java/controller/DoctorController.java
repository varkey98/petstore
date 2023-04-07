package controller;

import entities.impl.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import repositories.impl.DoctorDao;


@Controller
public class DoctorController {

    @Autowired
    private DoctorDao repository;
    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

    @MutationMapping
    public boolean createDoctor(@Argument Integer id, @Argument String firstName, @Argument String lastName, @Argument Integer phone) {
        try{
            Doctor doctor = new Doctor(id, firstName, lastName, phone, null);
            repository.create(doctor);
        } catch (Exception e) {
            log.error("Unable to create the doctor entity", e);
            return false;
        }
        return true;

    }

    @QueryMapping
    public Doctor findDoctorById(@Argument int id) {
        return  repository.findOne(id).get();
    }

    @MutationMapping
    public boolean deleteDoctor(@Argument int id) {
        try {
            repository.deleteById(id);
        } catch(Exception e) {
            log.error("Unable to delete the doctor entity", e);
            return false;
        }
        return true;

    }

    @MutationMapping
    public boolean updateDoctor(@Argument Integer id, @Argument String firstName, @Argument String lastName, @Argument Integer phone){
        try {
            Doctor doctor = repository.findOne(id).get();
            if(phone!=null) {
                doctor.setPhone(phone);
            }
            if(firstName!=null) {
                doctor.setFirstName(firstName);
            }
            if(lastName!=null) {
                doctor.setLastName(lastName);
            }
            repository.update(doctor);
        } catch(Exception e) {
            log.error("Unable to update the doctor entity", e);
            return false;
        }
        return true;
    }
}
