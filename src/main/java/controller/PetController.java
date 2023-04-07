package controller;

import entities.impl.Doctor;
import entities.impl.Pet;
import entities.impl.PetOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
public class PetController {

  private static final Logger log = LoggerFactory.getLogger(PetController.class);
  @Autowired PetDao petRepository;
  @Autowired DoctorDao doctorRepository;
  @Autowired PetOwnerDao ownerRepository;

  @MutationMapping
  public boolean createPet(
      @Argument int id,
      @Argument String name,
      @Argument DoctorInput doctor,
      @Argument PetOwnerInput owner) {
    try {
      Doctor doctorObject =
          doctorRepository
              .findOne(doctor.getId())
              .orElse(doctorRepository.create(doctor.getDoctorObject()));
      PetOwner ownerObject =
          ownerRepository
              .findOne(owner.getId())
              .orElse(ownerRepository.create(owner.getOwnerObject()));
      Pet pet = new Pet(id, name, doctorObject, ownerObject);
      petRepository.create(pet);
    } catch (Exception e) {
      log.error("Unable to create pet", e);
      return false;
    }
    return true;
  }

  @QueryMapping
  public Pet findPetById(@Argument int id) {
    Pet pet = petRepository.findOne(id).get();
    return pet;
  }

  @MutationMapping
  public boolean updatePet(
      @Argument int id,
      @Argument String name,
      @Argument DoctorInput doctor,
      @Argument PetOwnerInput owner) {
    try {
      Pet pet = petRepository.findOne(id).get();
      if (name != null) {
        pet.setName(name);
      }

      if (doctor != null) {
        Doctor doctorObj =
            doctorRepository
                .findOne(doctor.getId())
                .orElse(doctorRepository.create(doctor.getDoctorObject()));
        pet.setDoctor(doctorObj);
      }

      if (owner != null) {
        PetOwner ownerObj =
            ownerRepository
                .findOne(owner.getId())
                .orElse(ownerRepository.create(owner.getOwnerObject()));
        pet.setOwner(ownerObj);
      }

      petRepository.update(pet);
    } catch (Exception e) {
      log.error("Unable to update Pet", e);
      return false;
    }
    return true;
  }

  @MutationMapping
  public boolean deletePet(@Argument int id) {
    try {
      petRepository.deleteById(id);
    } catch (Exception e) {
      log.error("Unable to delete pet", e);
      return false;
    }
    return true;
  }
}
