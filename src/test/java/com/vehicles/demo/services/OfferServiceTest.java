package com.vehicles.demo.services;

import com.vehicles.demo.dtos.OfferDisplayDto;
import com.vehicles.demo.entities.Brand;
import com.vehicles.demo.entities.Model;
import com.vehicles.demo.entities.Offer;
import com.vehicles.demo.entities.User;
import com.vehicles.demo.repositories.OfferRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class OfferServiceTest {

    @Mock
    private OfferRepository offerRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private OfferService offerService;


    @Test
    public void testGetOfferById_WhenOfferExists_ReturnsDto() {
        UUID id = UUID.randomUUID();

        Offer mockOffer = new Offer();
        mockOffer.setId(id);

        User seller = new User();
        seller.setUsername("Pesho");
        mockOffer.setSeller(seller);

        Brand brand = new Brand();
        brand.setName("VW");

        Model model = new Model();
        model.setName("Golf");
        model.setBrand(brand);
        mockOffer.setModel(model);

        OfferDisplayDto mockDto = new OfferDisplayDto();
        mockDto.setId(id);

        Mockito.when(offerRepository.findById(id)).thenReturn(Optional.of(mockOffer));

        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(mockDto);

        OfferDisplayDto result = offerService.getOfferById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
    }

    @Test
    public void testGetOfferById_WhenOfferDoesNotExist_ThrowsException() {
        UUID id = UUID.randomUUID();

        Mockito.when(offerRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            offerService.getOfferById(id);
        });
    }
}