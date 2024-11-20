package edu.mcc.class14.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class Glass {
    @Max(64)
    @NotNull
    private Integer ounces;
    @NotNull
    private String shape;
    private String material;

    public Integer getOunces() {
        return ounces;
    }

    public Glass setOunces(Integer ounces) {
        this.ounces = ounces;
        return this;
    }

    public String getShape() {
        return shape;
    }

    public Glass setShape(String shape) {
        this.shape = shape;
        return this;
    }

    public String getMaterial() {
        return material;
    }

    public Glass setMaterial(String material) {
        this.material = material;
        return this;
    }
}
