package com.vehicles.demo.services;

import com.vehicles.demo.entities.Brand;
import com.vehicles.demo.entities.Model;
import com.vehicles.demo.enums.VehicleCategory;
import com.vehicles.demo.repositories.BrandRepository;
import com.vehicles.demo.repositories.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    protected DataInitializer(BrandRepository brandRepository, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (brandRepository.count() == 0) {
            seedBrandsAndModels();
        }
    }

    private void seedBrandsAndModels() {
        Brand ford = new Brand();
        ford.setName("Ford");

        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        focus.setCategory(VehicleCategory.CAR);
        focus.setYear(2014);

        Model fiesta = new Model();
        fiesta.setName("Fiesta");
        fiesta.setBrand(ford);
        fiesta.setYear(2006);
        fiesta.setCategory(VehicleCategory.CAR);

        ford.setModels(List.of(focus, fiesta));

        brandRepository.save(ford);

        Brand ssangyong = new Brand();
        ssangyong.setName("Ssangyong");

        Model kyron = new Model();
        kyron.setCategory(VehicleCategory.CAR);
        kyron.setBrand(ssangyong);
        kyron.setYear(2006);
        kyron.setName("Kyron");

        Model rexton = new Model();
        rexton.setName("Rexton");
        rexton.setBrand(ssangyong);
        rexton.setYear(2006);
        rexton.setCategory(VehicleCategory.CAR);

        ssangyong.setModels(List.of(kyron, rexton));
        brandRepository.save(ssangyong);


    }
}
