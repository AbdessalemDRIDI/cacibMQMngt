package com.example.cacibproject.controller;
import com.example.cacibproject.model.Partner;
import com.example.cacibproject.service.PartnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PartnerControllerTest {

    @Mock
    private PartnerService partnerService;

    @InjectMocks
    private PartnerController partnerController;

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
    public void testGetPartners() {
        // Mock the service method to return a list of partners
        when(partnerService.getAllPartners()).thenReturn(partners);

        // Call the controller method
        List<Partner> result = partnerController.getPartners();

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("TestAlias", result.get(0).getAlias());
        verify(partnerService, times(1)).getAllPartners();
    }

    @Test
    public void testAddPartner() {
        // Mock the service method to return the saved partner
        when(partnerService.addPartner(Mockito.any(Partner.class))).thenReturn(partner);

        // Call the controller method
        Partner result = partnerController.addPartner(partner);

        // Verify the result
        assertEquals("TestAlias", result.getAlias());
        assertEquals("TestType", result.getType());
        verify(partnerService, times(1)).addPartner(Mockito.any(Partner.class));
    }

    @Test
    public void testDeletePartner() {
        // Mock the service method to perform deletion (no return value needed)
        doNothing().when(partnerService).deletePartner(Mockito.anyLong());

        // Call the controller method
        partnerController.deletePartner(1L);

        // Verify that the deletePartner method was called with the correct argument
        verify(partnerService, times(1)).deletePartner(1L);
    }
}
