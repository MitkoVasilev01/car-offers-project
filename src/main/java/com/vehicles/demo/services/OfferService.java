package com.vehicles.demo.services;

import com.vehicles.demo.dtos.AddOfferDto;
import com.vehicles.demo.dtos.OfferDisplayDto;
import com.vehicles.demo.dtos.SearchOfferDto;
import com.vehicles.demo.entities.Model;
import com.vehicles.demo.entities.Offer;
import com.vehicles.demo.entities.OfferImage;
import com.vehicles.demo.entities.User;
import com.vehicles.demo.enums.Extra;
import com.vehicles.demo.repositories.ModelRepository;
import com.vehicles.demo.repositories.OfferRepository;
import com.vehicles.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Stream;

@Slf4j
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
        offer.setExtras(addOfferDto.getExtras());
        offer.setPhoneNumber(addOfferDto.getPhoneNumber());
        offer.setRegion(addOfferDto.getRegion());
        offer.setDoorCount(addOfferDto.getDoorCount());
        offer.setEuroStandard(addOfferDto.getEuroStandard());
        offer.setColor(addOfferDto.getColor());
        offer.setCubes(addOfferDto.getCubes());
        offer.setHorsePower(addOfferDto.getHorsePower());

        User seller = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        offer.setSeller(seller);
        Model model = modelRepository.findById(addOfferDto.getModelId()).orElseThrow();
        offer.setModel(model);

        offer = offerRepository.save(offer);


        List<MultipartFile> files = addOfferDto.getImages();
        List<OfferImage> offerImages = new ArrayList<>();
        boolean isFirstImage = true;
        if (files != null && !files.isEmpty()) {
            Path uploadDir = Paths.get("uploads");
            try {
                if (!Files.exists(uploadDir)) Files.createDirectories(uploadDir);
            } catch (IOException e) { throw new RuntimeException(e); }

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String uniqueName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                        Path filePath = uploadDir.resolve(uniqueName);
                        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                        OfferImage imageEntity = new OfferImage();
                        imageEntity.setUrl("/uploads/" + uniqueName);
                        imageEntity.setOffer(offer);
                        imageEntity.setMainImage(isFirstImage);
                        isFirstImage = false;
                        offerImages.add(imageEntity);

                    } catch (IOException e) {
                        log.error("Грешка при запис на снимка. Причина: {}", e.getMessage(), e);
                        throw new RuntimeException("Грешка при запис на файл", e);
                    }
                }
            }
        }

        if (!offerImages.isEmpty()) {
            offer.setImages(offerImages);
            offerRepository.save(offer);
        }
    }


    public List<OfferDisplayDto> searchOffers(SearchOfferDto searchDto) {

        List<Offer> offers = offerRepository.searchOffers(
                searchDto.getModelId(),
                searchDto.getMinYear(),
                searchDto.getMaxYear(),
                searchDto.getMinPrice(),
                searchDto.getEngine(),
                searchDto.getMaxPrice(),
                searchDto.getMileage(),
                searchDto.getMinCubes(),
                searchDto.getMaxCubes(),
                searchDto.getMinHorsePower(),
                searchDto.getMaxHorsePower(),
                searchDto.getColor(),
                searchDto.getTransmission(),
                searchDto.getDoorCount(),
                searchDto.getEuroStandard(),
                searchDto.getRegion(),
                searchDto.getSort()
        );

        Set<Extra> searchedExtras = searchDto.getExtras();

        if (searchedExtras != null && !searchedExtras.isEmpty()) {
            offers = offers.stream()
                    .filter(offer -> offer.getExtras().containsAll(searchedExtras))
                    .toList();


        }
        Stream<OfferDisplayDto> dtoStream = offers.stream()
                .map(this::mapToOfferDisplayDto);

        if (searchDto.getSort() != null) {
            switch (searchDto.getSort()) {
                case PRICE_ASCEDING:
                    dtoStream = dtoStream.sorted(Comparator.comparing(OfferDisplayDto::getPrice));
                    break;
                case PRICE_DESCEDING:
                    dtoStream = dtoStream.sorted(Comparator.comparing(OfferDisplayDto::getPrice).reversed());
                    break;
                case DATE_MANUFACTURE_DESCEDING:
                    dtoStream = dtoStream.sorted(Comparator.comparing(OfferDisplayDto::getYear).reversed());
                    break;
                case DATE_MANUFACTURE_ASCEDING:
                    dtoStream = dtoStream.sorted(Comparator.comparing(OfferDisplayDto::getYear));
                    break;
                case NAME_ASCEDING:
                    dtoStream = dtoStream.sorted(Comparator.comparing(OfferDisplayDto::getBrandName).thenComparing(OfferDisplayDto::getModelName));
                    break;
                case NAME_DESCEDING:
                    dtoStream = dtoStream.sorted(Comparator.comparing(OfferDisplayDto::getBrandName).thenComparing(OfferDisplayDto::getModelName).reversed());
                    break;
                case MILEAGE_ASCEDING:
                    dtoStream = dtoStream.sorted(Comparator.comparing(OfferDisplayDto::getMileage));
                    break;
                case MILEAGE_DESCEDING:
                    dtoStream = dtoStream.sorted(Comparator.comparing(OfferDisplayDto::getMileage).reversed());
                    break;
            }
            return dtoStream.toList();
        }




        return offers.stream()
                .map(this::mapToOfferDisplayDto)
                .toList();
    }


    private OfferDisplayDto mapToOfferDisplayDto(Offer offer) {
        OfferDisplayDto dto = modelMapper.map(offer, OfferDisplayDto.class);

        dto.setId(offer.getId());
        dto.setBrandName(offer.getModel().getBrand().getName());
        dto.setModelName(offer.getModel().getName());
        dto.setSellerUsername(offer.getSeller().getUsername());
        dto.setExtras(offer.getExtras());
        dto.setRegion(offer.getRegion());
        dto.setDoorCount(offer.getDoorCount());
        dto.setEuroStandard(offer.getEuroStandard());
        dto.setColor(offer.getColor());
        dto.setHorsePower(offer.getHorsePower());
        dto.setCubes(offer.getCubes());



        List<OfferImage> allImages = offer.getImages();


        dto.setImages(allImages);


        if (allImages != null && !allImages.isEmpty()) {
            String mainImageUrl = allImages.stream()
                    .filter(OfferImage::isMainImage)
                    .map(OfferImage::getUrl)
                    .findFirst()
                    .orElse(allImages.get(0).getUrl());

            dto.setImageUrl(mainImageUrl);
        } else {
            dto.setImageUrl(null);
        }


        return dto;
    }

    public OfferDisplayDto getOfferById(UUID id) {
        return offerRepository.findById(id).map(offer -> {
            return mapToOfferDisplayDto(offer);
        })
                .orElseThrow(() -> new RuntimeException("Offer not found!"));
    }

    public void deleteOffer (UUID offerId, String username) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Обявата не е намерена!"));

        if (!offer.getSeller().getUsername().equals(username)) {
            throw new RuntimeException("Нямате право да изтриете тази обява!");
        }
        offerRepository.delete(offer);
    }

    public AddOfferDto getOfferForEdit(UUID id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Обявата не е намерена"));

        AddOfferDto dto = new AddOfferDto();
        dto.setDescription(offer.getDescription());
        dto.setPrice(offer.getPrice());
        dto.setYear(offer.getYear());
        dto.setMileage(offer.getMileage());
        dto.setEngine(offer.getEngine());
        dto.setTransmission(offer.getTransmission());
        dto.setExtras(offer.getExtras());
        dto.setModelId(offer.getModel().getId());
        dto.setRegion(offer.getRegion());
        dto.setDoorCount(offer.getDoorCount());
        dto.setEuroStandard(offer.getEuroStandard());
        dto.setColor(offer.getColor());
        dto.setPhoneNumber(offer.getPhoneNumber());
        dto.setCubes(offer.getCubes());
        dto.setHorsePower(offer.getHorsePower());



        return dto;
    }

    @Transactional
    public void editOffer(UUID id, AddOfferDto offerDto, UserDetails userDetails) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Обявата не е намерена"));

        if (!offer.getSeller().getUsername().equals(userDetails.getUsername())) {
            throw new RuntimeException("Нямате право да редактирате тази обява!");
        }

        offer.setDescription(offerDto.getDescription());
        offer.setPrice(offerDto.getPrice());
        offer.setMileage(offerDto.getMileage());
        offer.setColor(offerDto.getColor());
        offer.setEngine(offerDto.getEngine());
        offer.setTransmission(offerDto.getTransmission());
        offer.setRegion(offerDto.getRegion());
        offer.setDoorCount(offerDto.getDoorCount());
        offer.setEuroStandard(offerDto.getEuroStandard());
        offer.setExtras(offerDto.getExtras());
        offer.setPhoneNumber(offerDto.getPhoneNumber());
        offer.setCubes(offerDto.getCubes());
        offer.setHorsePower(offerDto.getHorsePower());

        offerRepository.save(offer);
    }


}

