package com.example.cacibproject.controller;

import com.example.cacibproject.model.Partner;
import com.example.cacibproject.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @GetMapping
    public List<Partner> getPartners() {
        return partnerService.getAllPartners();
    }

    @PostMapping
    public Partner addPartner(@RequestBody Partner partner) {
        return partnerService.addPartner(partner);
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
    }
}