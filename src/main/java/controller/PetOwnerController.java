package controller;

import entities.impl.PetOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import repositories.impl.PetOwnerDao;

import java.util.ArrayList;

@Controller
public class PetOwnerController {
    private static Logger log = LoggerFactory.getLogger(PetOwnerController.class);
    @Autowired
    PetOwnerDao repository;

    @MutationMapping
    public boolean createOwner(@Argument Integer id, @Argument String firstName, @Argument String lastName, @Argument int phone){
        try {
            repository.create(new PetOwner(id, firstName, lastName, phone, new ArrayList<>()));
            return true;
        } catch (Exception e){
            log.error("Unable to create owner",e);
            return false;
        }
    }

    @QueryMapping
    public PetOwner findOwnerById(@Argument int id){
        return repository.findOne(id);
    }

    @MutationMapping
    public boolean deleteOwner(@Argument int id){
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Unable to delete owner", e);
            return false;
        }
    }

    @MutationMapping
    public boolean updateOwner(@Argument int id, @Argument String firstName, @Argument String lastName, @Argument Integer phone) {
        try {
            PetOwner owner = repository.findOne(id);
            if(firstName!=null) {
                owner.setFirstName(firstName);
            }
            if(lastName!=null) {
                owner.setLastName(lastName);
            }
            if(phone!=null) {
                owner.setPhone(phone);
            }
            return true;
        }catch (Exception e) {
            log.error("Unable to update owner", e);
            return false;
        }
    }
}
