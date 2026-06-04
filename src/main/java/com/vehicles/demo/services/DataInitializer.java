package com.vehicles.demo.services;

import com.vehicles.demo.entities.*;
import com.vehicles.demo.enums.*;
import com.vehicles.demo.repositories.BrandRepository;
import com.vehicles.demo.repositories.ModelRepository;
import com.vehicles.demo.repositories.OfferRepository;
import com.vehicles.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    protected DataInitializer(BrandRepository brandRepository, ModelRepository modelRepository, OfferRepository offerRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (brandRepository.count() == 0) {
            seedBrandsAndModels();
        }
        if (offerRepository.count() == 0) {
            seedOffers();
        }
    }

    private void seedBrandsAndModels() {
        Brand ford = new Brand();
        ford.setName("Ford");

        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        focus.setCategory(VehicleCategory.CAR);

        Model fiesta = new Model();
        fiesta.setName("Fiesta");
        fiesta.setBrand(ford);
        fiesta.setCategory(VehicleCategory.CAR);

        Model escort = new Model();
        escort.setName("Escort");
        escort.setBrand(ford);
        fiesta.setCategory(VehicleCategory.CAR);

        Model connect = new Model();
        connect.setName("Connect");
        connect.setBrand(ford);
        connect.setCategory(VehicleCategory.CAR);

        Model fusion = new Model();
        fusion.setName("Fusion");
        fusion.setBrand(ford);
        fusion.setCategory(VehicleCategory.CAR);

        Model galaxy = new Model();
        galaxy.setName("Galaxy");
        galaxy.setBrand(ford);
        galaxy.setCategory(VehicleCategory.CAR);

        Model ka = new Model();
        ka.setName("Ka");
        ka.setBrand(ford);
        ka.setCategory(VehicleCategory.CAR);

        Model kuga = new Model();
        kuga.setName("Kuga");
        kuga.setBrand(ford);
        kuga.setCategory(VehicleCategory.CAR);

        Model mondeo = new Model();
        mondeo.setName("Mondeo");
        mondeo.setBrand(ford);
        mondeo.setCategory(VehicleCategory.CAR);

        Model mustang = new Model();
        mustang.setName("Mustang");
        mustang.setBrand(ford);
        mustang.setCategory(VehicleCategory.CAR);

        Model puma = new Model();
        puma.setName("Puma");
        puma.setBrand(ford);
        puma.setCategory(VehicleCategory.CAR);


        ford.setModels(List.of(focus, fiesta, puma, mustang, mondeo, kuga, ka, galaxy, fusion, connect, escort));
        brandRepository.save(ford);


        Brand ssangyong = new Brand();
        ssangyong.setName("Ssangyong");

        Model kyron = new Model();
        kyron.setCategory(VehicleCategory.CAR);
        kyron.setBrand(ssangyong);
        kyron.setName("Kyron");

        Model rexton = new Model();
        rexton.setName("Rexton");
        rexton.setBrand(ssangyong);
        rexton.setCategory(VehicleCategory.CAR);

        ssangyong.setModels(List.of(kyron, rexton));
        brandRepository.save(ssangyong);


        Brand mercedes = new Brand();
        mercedes.setName("Mercedes");

        Model aClass = new Model();
        aClass.setName("A-class");
        aClass.setBrand(mercedes);
        aClass.setCategory(VehicleCategory.CAR);

        Model bClass = new Model();
        bClass.setName("B-class");
        bClass.setBrand(mercedes);
        bClass.setCategory(VehicleCategory.CAR);

        Model cClass = new Model();
        cClass.setName("C-class");
        cClass.setBrand(mercedes);
        cClass.setCategory(VehicleCategory.CAR);

        Model eClass = new Model();
        eClass.setName("E-class");
        eClass.setBrand(mercedes);
        eClass.setCategory(VehicleCategory.CAR);

        Model gClass = new Model();
        gClass.setName("G-class");
        gClass.setBrand(mercedes);
        gClass.setCategory(VehicleCategory.CAR);

        Model sClass = new Model();
        sClass.setName("S-class");
        sClass.setBrand(mercedes);
        sClass.setCategory(VehicleCategory.CAR);

        mercedes.setModels(List.of(aClass, bClass, cClass, eClass, gClass, sClass));
        brandRepository.save(mercedes);


        Brand bmw = new Brand();
        bmw.setName("BMW");

        Model oneSeries = new Model();
        oneSeries.setName("1-Series");
        oneSeries.setBrand(bmw);
        oneSeries.setCategory(VehicleCategory.CAR);

        Model twoSeries = new Model();
        twoSeries.setName("2-Series");
        twoSeries.setBrand(bmw);
        twoSeries.setCategory(VehicleCategory.CAR);

        Model threeSeries = new Model();
        threeSeries.setName("3-Series");
        threeSeries.setBrand(bmw);
        threeSeries.setCategory(VehicleCategory.CAR);

        Model fourSeries = new Model();
        fourSeries.setName("4-Series");
        fourSeries.setBrand(bmw);
        fourSeries.setCategory(VehicleCategory.CAR);

        Model fiveSeries = new Model();
        fiveSeries.setName("5-Series");
        fiveSeries.setBrand(bmw);
        fiveSeries.setCategory(VehicleCategory.CAR);

        Model sixSeries = new Model();
        sixSeries.setName("6-Series");
        sixSeries.setBrand(bmw);
        sixSeries.setCategory(VehicleCategory.CAR);

        Model sevenSeries = new Model();
        sevenSeries.setName("7-Series");
        sevenSeries.setBrand(bmw);
        sevenSeries.setCategory(VehicleCategory.CAR);

        bmw.setModels(List.of(oneSeries, twoSeries, threeSeries, fourSeries, fiveSeries, sixSeries, sevenSeries));
        brandRepository.save(bmw);


        Brand audi = new Brand();
        audi.setName("Audi");

        Model a1 = new Model();
        a1.setName("A1");
        a1.setBrand(audi);
        a1.setCategory(VehicleCategory.CAR);

        Model a2 = new Model();
        a2.setName("A2");
        a2.setBrand(audi);
        a2.setCategory(VehicleCategory.CAR);

        Model a3 = new Model();
        a3.setName("A3");
        a3.setBrand(audi);
        a3.setCategory(VehicleCategory.CAR);

        Model a4 = new Model();
        a4.setName("A4");
        a4.setBrand(audi);
        a4.setCategory(VehicleCategory.CAR);

        Model a5 = new Model();
        a5.setName("A5");
        a5.setBrand(audi);
        a5.setCategory(VehicleCategory.CAR);

        Model a6 = new Model();
        a6.setName("A6");
        a6.setBrand(audi);
        a6.setCategory(VehicleCategory.CAR);

        Model a7 = new Model();
        a7.setName("A7");
        a7.setBrand(audi);
        a7.setCategory(VehicleCategory.CAR);

        Model a8 = new Model();
        a8.setName("A8");
        a8.setBrand(audi);
        a8.setCategory(VehicleCategory.CAR);

        audi.setModels(List.of(a1, a2, a3, a4, a5, a6, a7, a8));
        brandRepository.save(audi);


        Brand vw = new Brand();
        vw.setName("VW");

        Model bora = new Model();
        bora.setName("Bora");
        bora.setBrand(vw);
        bora.setCategory(VehicleCategory.CAR);

        Model caddy = new Model();
        caddy.setName("Caddy");
        caddy.setBrand(vw);
        caddy.setCategory(VehicleCategory.CAR);

        Model golf = new Model();
        golf.setName("Golf");
        golf.setBrand(vw);
        golf.setCategory(VehicleCategory.CAR);

        Model jetta = new Model();
        jetta.setName("Jetta");
        jetta.setBrand(vw);
        jetta.setCategory(VehicleCategory.CAR);

        Model lupo = new Model();
        lupo.setName("Lupo");
        lupo.setBrand(vw);
        lupo.setCategory(VehicleCategory.CAR);

        Model passat = new Model();
        passat.setName("Passat");
        passat.setBrand(vw);
        passat.setCategory(VehicleCategory.CAR);

        Model phaeton = new Model();
        phaeton.setName("Phaeton");
        phaeton.setBrand(vw);
        phaeton.setCategory(VehicleCategory.CAR);

        Model polo = new Model();
        polo.setName("Polo");
        polo.setBrand(vw);
        polo.setCategory(VehicleCategory.CAR);

        Model sharan = new Model();
        sharan.setName("Sharan");
        sharan.setBrand(vw);
        sharan.setCategory(VehicleCategory.CAR);

        Model tayron = new Model();
        tayron.setName("Tayron");
        tayron.setBrand(vw);
        tayron.setCategory(VehicleCategory.CAR);

        Model tiguan = new Model();
        tiguan.setName("Tiguan");
        tiguan.setBrand(vw);
        tiguan.setCategory(VehicleCategory.CAR);

        Model touareg = new Model();
        touareg.setName("Touareg");
        touareg.setBrand(vw);
        touareg.setCategory(VehicleCategory.CAR);

        vw.setModels(List.of(bora, caddy, touareg, tiguan, tayron, sharan, polo, phaeton, passat, lupo, jetta, golf));
        brandRepository.save(vw);


        Brand toyota = new Brand();
        toyota.setName("Toyota");

        Model auris = new Model();
        auris.setName("Auris");
        auris.setBrand(toyota);
        auris.setCategory(VehicleCategory.CAR);

        Model avensis = new Model();
        avensis.setName("Avensis");
        avensis.setBrand(toyota);
        avensis.setCategory(VehicleCategory.CAR);

        Model celica = new Model();
        celica.setName("Celica");
        celica.setBrand(toyota);
        celica.setCategory(VehicleCategory.CAR);

        Model corolla = new Model();
        corolla.setName("Corolla");
        corolla.setBrand(toyota);
        corolla.setCategory(VehicleCategory.CAR);

        Model prius = new Model();
        prius.setName("Prius");
        prius.setBrand(toyota);
        prius.setCategory(VehicleCategory.CAR);

        Model rav4 = new Model();
        rav4.setName("RAV4");
        rav4.setBrand(toyota);
        rav4.setCategory(VehicleCategory.CAR);

        Model supra = new Model();
        supra.setName("Supra");
        supra.setBrand(toyota);
        supra.setCategory(VehicleCategory.CAR);

        Model yaris = new Model();
        yaris.setName("Yaris");
        yaris.setBrand(toyota);
        yaris.setCategory(VehicleCategory.CAR);

        toyota.setModels(List.of(auris, avensis, celica, corolla, prius, rav4, supra, yaris));
        brandRepository.save(toyota);

    }

    private void seedOffers() {
        User admin = userRepository.findByUsername("admin").orElseGet(() -> {
            User newUser = new User();
            newUser.setUsername("admin");
            newUser.setPassword(passwordEncoder.encode("13579Ii..."));
            newUser.setEmail("admin@findcar.com");
            newUser.setActive(true);
            newUser.setCreatedOn(LocalDateTime.now());
            newUser.setRole(UserRole.ADMIN);
            return userRepository.save(newUser);
        });
        Model golf = modelRepository.findByName("Golf").orElse(null);
        Model a3 = modelRepository.findByName("A3").orElse(null);
        Model threeSeries = modelRepository.findByName("3-Series").orElse(null);
        Model a4 = modelRepository.findByName("A4").orElse(null);

        if (golf != null) {
            saveOffer(golf, admin, new BigDecimal("15000"), "Много запазен Голф, икономичен и перфектен за градски условия.", Set.of(Extra.AIR_CONDITIONING, Extra.ALARM), "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2F06.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2F08.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2F02.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2F04.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe01.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe02.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe03.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe06.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe07.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe08.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe09.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe10.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe11.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2958%2F20984%2FYH70TMO%2Fe12.jpg&w=3840&q=75");
        }
        if (a3 != null) {
            saveOffer(a3, admin, new BigDecimal("17000"), "Ауди А3 - топ състояние, спортен дух и изключителен комфорт.", Set.of(Extra.AIR_CONDITIONING, Extra.ALARM), "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2F06.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2F08.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2F02.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2F04.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2Fe01.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2Fe02.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2Fe03.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2Fe03.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2Fe06.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2Fe07.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F5213%2Fprojectcambridge%2FVX18KNU%2Fe08.jpg&w=3840&q=75");
        }
        if (threeSeries != null) {
            saveOffer(threeSeries, admin, new BigDecimal("22000"), "БМВ 3 за истински фенове на марката, напълно обслужен.", Set.of(Extra.AIR_CONDITIONING, Extra.ALARM), "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2F06.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2F08.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2F02.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2F04.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe01.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe02.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe03.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe06.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe07.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe08.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe09.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe10.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe11.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2657%2Fcinch%2FYB67OJW%2Fe12.jpg&w=3840&q=75");
        }
        if (a4 != null) {
            saveOffer(a4, admin, new BigDecimal("21000"), "Ауди А4 семейна кола, просторна и изключително сигурна.", Set.of(Extra.AIR_CONDITIONING, Extra.ALARM), "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe01.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe03.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe05.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe07.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe09.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe10.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe11.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe12.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe14.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe15.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe16.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe17.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe18.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe19.jpg&w=3840&q=75", "https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F7570%2F22083%2FDG68TUP%2Fe20.jpg&w=3840&q=75");
        }
    }

    private void saveOffer(Model model, User seller, BigDecimal price, String desc, Set<Extra> extras, String... imageUrls) {
        Offer offer = new Offer();
        offer.setId(null);
        offer.setImages(new ArrayList<>());
        offer.setModel(model);
        offer.setSeller(seller);
        offer.setPrice(price);
        offer.setDescription(desc);
        offer.setYear(2018);
        offer.setMileage(150000);
        offer.setEngine(Engine.GASOLINE);
        offer.setTransmission(Transmission.MANUAL);
        offer.setRegion(Region.SOFIA);
        offer.setColor(Color.BLACK);
        offer.setDoorCount(DoorCount.FOUR_FIVE);
        offer.setEuroStandard(EuroStandard.EURO5);
        offer.setCubes(1900);
        offer.setHorsePower(150);
        offer.setPhoneNumber("0888123456");
        offer.setCreatedOn(LocalDateTime.now());
        offer.setExtras(extras);


        offer = offerRepository.save(offer);

        List<OfferImage> offerImages = new ArrayList<>();
        boolean isFirstImage = true;
        for (String url : imageUrls) {
            OfferImage image = new OfferImage();
            image.setUrl(url);
            image.setMainImage(isFirstImage);
            image.setOffer(offer);

            offerImages.add(image);
            isFirstImage = false;
        }
        offer.setImages(offerImages);
        offerRepository.save(offer);
    }
}

