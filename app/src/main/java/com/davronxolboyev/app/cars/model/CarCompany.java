package com.davronxolboyev.app.cars.model;

import com.davronxolboyev.app.cars.model.adapter.CarModelsAdapter;


public class CarCompany {
    private final int companyImage;
    private final String companyName;
    private final CarModelsAdapter adapter;

    public CarCompany(int companyImage, String companyName, CarModelsAdapter adapter) {
        this.companyImage = companyImage;
        this.companyName = companyName;
        this.adapter = adapter;
    }

    public CarModelsAdapter getAdapter() {
        return adapter;
    }

    public int getCompanyImage() {
        return companyImage;
    }

    public String getCompanyName() {
        return companyName;
    }
}
