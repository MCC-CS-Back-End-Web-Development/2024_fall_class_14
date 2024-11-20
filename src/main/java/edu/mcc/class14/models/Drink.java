package edu.mcc.class14.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public class Drink {
    private UUID id;
    @NotNull
    @Size(min = 3, max = 30)
    private String name;
    private String category;
    private List<String> flavors;
    private Boolean alcoholic;
    @Valid
    private Glass drinkWare;

    public UUID getId() {
        return id;
    }

    public Drink setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Drink setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Drink setCategory(String category) {
        this.category = category;
        return this;
    }

    public List<String> getFlavors() {
        return flavors;
    }

    public Drink setFlavors(List<String> flavors) {
        this.flavors = flavors;
        return this;
    }

    public Boolean getAlcoholic() {
        return alcoholic;
    }

    public Drink setAlcoholic(Boolean alcoholic) {
        this.alcoholic = alcoholic;
        return this;
    }

    public Glass getDrinkWare() {
        return drinkWare;
    }

    public Drink setDrinkWare(Glass drinkWare) {
        this.drinkWare = drinkWare;
        return this;
    }
}
