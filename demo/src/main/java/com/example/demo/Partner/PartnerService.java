package com.example.demo.Partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerService(PartnerRepository partnerRepository) { this.partnerRepository = partnerRepository;}

    public Partner addNewPartner(String firstName, String lastName, Long docId) {
        Partner partner = new Partner(firstName, lastName, docId);
        System.out.println(partner);
        partnerRepository.save(partner);
        return partner;
    }

    public List<Partner> getPartners() {
        return partnerRepository.findAll();
    }
}
