package application;

import entities.impl.Doctor;
import entities.impl.Pet;
import entities.impl.PetOwner;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("entities.impl")
@EnableJpaRepositories("petstore")
@ComponentScan(basePackages = {"controller", "repositories"})
public class PetStoreApplication {

  private SessionFactory sessionFactory;

  public static void main(String[] args) {
    SpringApplication.run(PetStoreApplication.class, args);
  }

  @Bean(name = "entityManagerFactory")
  public SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      sessionFactory = buildSessionFactory();
    }
    return sessionFactory;
  }

  public SessionFactory buildSessionFactory() {
    ServiceRegistry serviceRegistry =
        new StandardServiceRegistryBuilder().applySettings(dbSettings()).build();
    Metadata metadata =
        new MetadataSources(serviceRegistry)
            .addAnnotatedClass(Doctor.class)
            .addAnnotatedClass(Pet.class)
            .addAnnotatedClass(PetOwner.class)
            .buildMetadata();
    return metadata.buildSessionFactory();
  }

  private Map<String, Object> dbSettings() {
    Map<String, Object> dbSettings = new HashMap<>();
    dbSettings.put(Environment.URL, "jdbc:h2:mem:spring_hibernate_one_to_many");
    dbSettings.put(Environment.USER, "sa");
    dbSettings.put(Environment.PASS, "");
    dbSettings.put(Environment.DRIVER, "org.h2.Driver");
    dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
    dbSettings.put(Environment.SHOW_SQL, "true");
    dbSettings.put(Environment.HBM2DDL_AUTO, "create");
    return dbSettings;
  }
}
