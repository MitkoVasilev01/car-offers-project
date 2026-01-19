package com.vehicles.demo.controllers;

import com.vehicles.demo.dtos.AddOfferDto;
import com.vehicles.demo.dtos.OfferDisplayDto;
import com.vehicles.demo.dtos.SearchOfferDto;
import com.vehicles.demo.entities.Offer;
import com.vehicles.demo.enums.*;
import com.vehicles.demo.repositories.BrandRepository;
import com.vehicles.demo.repositories.ModelRepository;
import com.vehicles.demo.repositories.OfferRepository;
import com.vehicles.demo.services.OfferService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final BrandRepository brandRepository;

    public OfferController(OfferService offerService, BrandRepository brandRepository) {
        this.offerService = offerService;
        this.brandRepository = brandRepository;
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model) {

        if (!model.containsAttribute("AddOfferDto")) {
            model.addAttribute("AddOfferDto", new AddOfferDto());
        }

        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("colors", Color.values());

        return "offer-add";

    }

    @PostMapping("/offers/add")
    public String addOfferConfirm(@Valid @ModelAttribute("addOfferDto") AddOfferDto addOfferDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto", bindingResult);
            return "redirect:/offers/add";
        }
        offerService.addOffer(addOfferDto, userDetails);

        return "redirect:/";
    }

    @GetMapping("/offers/search")
    public String searchOffers(@Valid SearchOfferDto searchOfferDto, Model model) {
        if (!model.containsAttribute("searchOfferDto")) {
            model.addAttribute("searchOfferDto", new SearchOfferDto());
        }
        int currentYear = java.time.Year.now().getValue();

        List<Integer> years = new ArrayList<>();

        for (int i = currentYear; i >= 1930; i--) {
            years.add(i);
        }
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("years", years);
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("colors", Color.values());
        model.addAttribute("offers", offerService.searchOffers(searchOfferDto));
        model.addAttribute("colors", Color.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("doors", DoorCount.values());
        model.addAttribute("eurostandard", EuroStandard.values());
        model.addAttribute("regions", Region.values());
        model.addAttribute("sort", Sort.values());
        model.addAttribute("allExtras", Extra.values());

        List<OfferDisplayDto> offers = offerService.searchOffers(searchOfferDto);
        model.addAttribute("offers", offers);
        return "offers-search";
    }
}

