package com.davronxolboyev.app.cars.model;

public class CarModels {
    private final int id;
    private final int idCompany;
    private final String carName;
    private final String carCost;
    private final int carImage;
    private final String description;

    public CarModels(int idCompany, int id, String carName, String carCost, int carImage, String description) {
        this.idCompany = idCompany;
        this.id = id;
        this.carName = carName;
        this.carCost = carCost;
        this.carImage = carImage;
        this.description = description;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public int getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarCost() {
        return carCost;
    }

    public int getCarImage() {
        return carImage;
    }

    public String getDescription() {
        return description;
    }
}
