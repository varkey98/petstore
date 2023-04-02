package controller;

import entities.impl.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import repositories.impl.DoctorDao;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorDao repository;
    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

//    @SchemaMapping(typeName = "Mutation")
    @MutationMapping
    public boolean createDoctor(@Argument Integer id, @Argument String firstName, @Argument String lastName, @Argument Integer phone) {
        try{
            Doctor doctor = new Doctor(id, firstName, lastName, phone, null);
            repository.create(doctor);
            return true;
        } catch (Exception e) {
            log.error("Unable to update the database", e);
            return false;
        }
    }

    @QueryMapping
    public Doctor findDoctorById(@Argument int id) {
        System.out.println(repository.findAll().get(0).toString());
        return  repository.findOne(id);
    }
}
