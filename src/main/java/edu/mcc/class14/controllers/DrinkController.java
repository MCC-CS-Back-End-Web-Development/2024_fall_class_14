package edu.mcc.class14.controllers;

import edu.mcc.class14.models.Drink;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/drinks")
public class DrinkController {

    Logger logger = LoggerFactory.getLogger(DrinkController.class);
    List<Drink> drinkList = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return ResponseEntity.ok(drinkList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrink(@PathVariable String id){
        Optional<Drink> firstDrink = drinkList
                .stream()
                .filter(d -> d.getId().toString().equals(id))
                .findFirst();

        if (firstDrink.isPresent()) {
            return ResponseEntity.ok(firstDrink.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@Valid @RequestBody Drink request, @PathVariable String id){
        Optional<Drink> firstDrink = drinkList
                .stream()
                .filter(d -> d.getId().toString().equals(id))
                .findFirst();

        if (firstDrink.isPresent()) {
            drinkList.remove(firstDrink.get());
            drinkList.add(request);
            return ResponseEntity.ok(request);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Drink> createDrink(@Valid @RequestBody Drink request) {
        request.setId(UUID.randomUUID());
        logger.info("Created drink with ID: {}", request.getId());
        drinkList.add(request);
        return ResponseEntity.ok(request);
    }

}
