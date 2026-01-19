package com.vehicles.demo.services;

import com.vehicles.demo.dtos.AddOfferDto;
import com.vehicles.demo.dtos.OfferDisplayDto;
import com.vehicles.demo.dtos.SearchOfferDto;
import com.vehicles.demo.entities.Model;
import com.vehicles.demo.entities.Offer;
import com.vehicles.demo.entities.User;
import com.vehicles.demo.repositories.ModelRepository;
import com.vehicles.demo.repositories.OfferRepository;
import com.vehicles.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
   public void addOffer(AddOfferDto addOfferDto, UserDetails userDetails) {
       Offer offer = new Offer();


    offer.setDescription(addOfferDto.getDescription());
  offer.setPrice(addOfferDto.getPrice());
     offer.setYear(addOfferDto.getYear());
      offer.setMileage(addOfferDto.getMileage());
     offer.setEngine(addOfferDto.getEngine());
      offer.setTransmission(addOfferDto.getTransmission());
     offer.setImageUrl(addOfferDto.getImageUrl());

   User seller = userRepository.findByUsername(userDetails.getUsername())
              .orElseThrow(() -> new RuntimeException("User not found"));
        offer.setSeller(seller);

       Model model = modelRepository.findById(addOfferDto.getModelId())
              .orElseThrow(() -> new RuntimeException("Model not found"));
      offer.setModel(model);

      offerRepository.save(offer);
   }

    public List<OfferDisplayDto> searchOffers(SearchOfferDto searchDto) {
        return offerRepository.searchOffers(
                        searchDto.getModelId(),
                        searchDto.getMinYear(),
                        searchDto.getMaxPrice())
                .stream()
                .map(this::mapToOfferDisplayDto)
                .toList();
    }


    private OfferDisplayDto mapToOfferDisplayDto(Offer offer) {
        OfferDisplayDto dto = modelMapper.map(offer, OfferDisplayDto.class);
        dto.setBrandName(offer.getModel().getBrand().getName());
        dto.setModelName(offer.getModel().getName());
        dto.setSellerUsername(offer.getSeller().getUsername());
        return dto;
    }

}

