package com.example.cacibproject.service;


import com.example.cacibproject.model.Partner;
import com.example.cacibproject.repositorie.PartnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PartnerServiceTest {

    @Mock
    private PartnerRepository partnerRepository;

    @InjectMocks
    private PartnerService partnerService;

    private Partner partner;
    private List<Partner> partners;

    @BeforeEach
    public void setUp() {
        // Setup mock data
        partner = new Partner();
        partner.setId(1L);
        partner.setAlias("TestAlias");
        partner.setType("TestType");
        partner.setDirection("INBOUND");
        partner.setApplication("TestApp");
        partner.setProcessedFlowType("MESSAGE");
        partner.setDescription("Test Description");

        partners = new ArrayList<>();
        partners.add(partner);
    }

    @Test
    public void testGetAllPartners() {
        // Mock the repository method to return a list of partners
        when(partnerRepository.findAll()).thenReturn(partners);

        // Call the service method
        List<Partner> result = partnerService.getAllPartners();

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("TestAlias", result.get(0).getAlias());
        verify(partnerRepository, times(1)).findAll();
    }

    @Test
    public void testAddPartner() {
        // Mock the repository method to return the saved partner
        when(partnerRepository.save(Mockito.any(Partner.class))).thenReturn(partner);

        // Call the service method
        Partner result = partnerService.addPartner(partner);

        // Verify the result
        assertEquals("TestAlias", result.getAlias());
        assertEquals("TestType", result.getType());
        verify(partnerRepository, times(1)).save(Mockito.any(Partner.class));
    }

    @Test
    public void testDeletePartner() {
        // Mock the repository method to perform deletion (no return value needed)
        doNothing().when(partnerRepository).deleteById(Mockito.anyLong());

        // Call the service method
        partnerService.deletePartner(1L);

        // Verify that the deleteById method was called with the correct argument
        verify(partnerRepository, times(1)).deleteById(1L);
    }
}

