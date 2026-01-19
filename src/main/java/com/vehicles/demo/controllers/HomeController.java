package com.vehicles.demo.controllers;

import com.vehicles.demo.enums.Engine;
import com.vehicles.demo.repositories.BrandRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final BrandRepository brandRepository;

    public HomeController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        int currentYear = java.time.Year.now().getValue();

        List<Integer> years = new ArrayList<>();

        for (int i = currentYear; i >= 1930; i--) {
            years.add(i);
        }

        model.addAttribute("years", years);
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("engines", Engine.values());
        return "index";
    }
}
