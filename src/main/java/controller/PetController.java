package controller;

import entities.impl.Doctor;
import entities.impl.Pet;
import entities.impl.PetOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import repositories.impl.DoctorDao;
import repositories.impl.PetDao;
import repositories.impl.PetOwnerDao;
import schema.DoctorInput;
import schema.PetOwnerInput;

import java.util.ArrayList;

@Controller
public class PetController {

    @Autowired
    PetDao petRepository;
    @Autowired
    DoctorDao doctorRepository;
    @Autowired
    PetOwnerDao ownerRepository;


    @MutationMapping
    public boolean createPet(@Argument int id, @Argument String name, @Argument DoctorInput doctor, @Argument PetOwnerInput owner) {
        Doctor doctorObject = new Doctor(doctor.getId(), doctor.getFirstName(), doctor.getLastName(), doctor.getPhone(), new ArrayList<>());
        PetOwner ownerObject = new PetOwner(owner.getId(), owner.getFirstName(), owner.getLastName(), owner.getPhone(), new ArrayList<>());
        Pet pet = new Pet(id, name, doctorObject, ownerObject);
//        doctorObject.getPatients().add(pet);
//        ownerObject.getPets().add(pet);
        ownerRepository.create(ownerObject);
        doctorRepository.create(doctorObject);
        petRepository.create(pet);
        return true;
    }

    @QueryMapping
    public Pet findPetById(@Argument int id) {
        Pet pet =  petRepository.findOne(id);
//        System.out.println(pet.getDoctor().getPatients().size());
        return pet;
    }
}
