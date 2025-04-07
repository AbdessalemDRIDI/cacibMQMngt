package com.example.cacibproject.service;

import com.example.cacibproject.model.Partner;
import com.example.cacibproject.repositorie.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    public Partner addPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    public void deletePartner(Long id) {
        partnerRepository.deleteById(id);
    }
}
