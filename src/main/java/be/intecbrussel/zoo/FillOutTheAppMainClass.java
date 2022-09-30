package be.intecbrussel.zoo;

import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.repositories.AnimalRepository;
import be.intecbrussel.zoo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FillOutTheAppMainClass implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FillOutTheAppMainClass.class, args);
    }

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void run(String... args) throws Exception {


    }
}
