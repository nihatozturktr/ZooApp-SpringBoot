package be.intecbrussel.zoo.controllers.interfaces;

import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.repositories.AnimalRepository;
import be.intecbrussel.zoo.services.interfaces.AnimalService;
import be.intecbrussel.zoo.services.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnimalControllerImpl implements AnimalController{

    private AnimalService animalService;

    private CountryService countryService;

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalControllerImpl(AnimalService animalService, CountryService countryService) {
        this.animalService = animalService;
        this.countryService = countryService;
    }


    @Override
    @GetMapping("/animals/{countryName}")
    public String seeAllAnimalsByCountry(Model model,@PathVariable("countryName") String countryName) {

        Country country = countryService.getCountryByName(countryName);
        model.addAttribute("animals",animalService.getAnimalsByCountry(country));

        return "animals";
    }

    @Override
    @PostMapping("/animals/{countryName}")
    public String addAnimal(String animalName,@PathVariable("countryName") String countryName) {

        Country country = countryService.getCountryByName(countryName);
        Animal animal = new Animal(animalName,country);

        animalService.addAnimal(animal);
        return "redirect:/animals/{countryName}";
    }

    @Override
    @GetMapping("/animals/{countryName}/{id}")
    public String deleteAnimal(@PathVariable Long id) {

        animalService.deleteAnimal(id);

        return "redirect:/animals/{countryName}";  //redirect:/animals/{countryName}/{id}
    }
}
