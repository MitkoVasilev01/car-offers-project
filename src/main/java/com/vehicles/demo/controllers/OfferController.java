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
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

        if (!model.containsAttribute("addOfferDto")) {
            model.addAttribute("addOfferDto", new AddOfferDto());
        }
        int currentYear = java.time.Year.now().getValue();

        List<Integer> years = new ArrayList<>();

        for (int i = currentYear; i >= 1930; i--) {
            years.add(i);
        }
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("colors", Color.values());
        model.addAttribute("years", years);
        model.addAttribute("allExtras", Extra.values());
        model.addAttribute("regions", Region.values());
        model.addAttribute("doors", DoorCount.values());
        model.addAttribute("euroStandards", EuroStandard.values());
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
    public String searchOffersForm(SearchOfferDto searchOfferDto, Model model) {

        if (!model.containsAttribute("searchOfferDto")) {
            model.addAttribute("searchOfferDto", new SearchOfferDto());
        }



        populateDropdowns(model);

        model.addAttribute("offers", offerService.searchOffers(searchOfferDto));

        return "offers-search";
    }

    private void populateDropdowns(Model model) {
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
        model.addAttribute("doors", DoorCount.values());
        model.addAttribute("eurostandard", EuroStandard.values());
        model.addAttribute("regions", Region.values());
        model.addAttribute("sort", Sort.values());
        model.addAttribute("allExtras", Extra.values());

    }

    @GetMapping("/offers")
    public String showOffersResults(@Valid SearchOfferDto searchOfferDto, OfferDisplayDto offerDisplayDto,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                    Model model) {

redirectAttributes.addFlashAttribute("searchOfferDto", searchOfferDto);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.searchOfferDto", bindingResult);

        populateDropdowns(model);
        if (bindingResult.hasErrors()) {
            return "offers-search";
        }

        model.addAttribute("offers", offerService.searchOffers(searchOfferDto));
        model.addAttribute("offer.id", offerDisplayDto.getId());

        return "offers-all";
    }

    @GetMapping("/offers/details/{id}")
    public String showOfferDetails (@PathVariable("id") UUID id, Model model) {

        OfferDisplayDto offerDto = offerService.getOfferById(id);
        model.addAttribute("offer", offerDto);
        return "offer-details";

    }

    @PostMapping("/offers/delete/{id}")
    public String deleteOffer(@PathVariable("id") UUID id,
                              @AuthenticationPrincipal UserDetails userDetails) {

        offerService.deleteOffer(id, userDetails.getUsername());

     return "redirect:/offers";
    }

    @GetMapping("/offers/edit/{id}")
    public String editOffer(@PathVariable("id") UUID id, Model model) {


        AddOfferDto offerDto = offerService.getOfferForEdit(id);
        model.addAttribute("addOfferDto", offerDto);
        model.addAttribute("offerId", id);

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
        model.addAttribute("doors", DoorCount.values());
        model.addAttribute("euroStandards", EuroStandard.values());
        model.addAttribute("regions", Region.values());
        model.addAttribute("allExtras", Extra.values());

        return "offer-edit";
    }
    @PostMapping("/offers/edit/{id}")
    public String editOfferConfirm(@PathVariable("id") UUID id,
                                   @Valid AddOfferDto addOfferDto,
                                   BindingResult bindingResult,
                                   @AuthenticationPrincipal UserDetails userDetails,
                                   Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("offerId", id);
            model.addAttribute("brands", brandRepository.findAll());
            model.addAttribute("allExtras", Extra.values());
            return "offer-edit";
        }

        offerService.editOffer(id, addOfferDto, userDetails);

        return "redirect:/offers/details/" + id;
    }

}

