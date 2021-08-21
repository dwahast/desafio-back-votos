package com.example.demo.Partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/partner", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartnerController {

    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) { this.partnerService = partnerService; }

    @GetMapping
    public List<Partner> getPartners() {
        return partnerService.getPartners();
    }

    @PostMapping
    public Partner addNewPartner(@RequestBody Partner partner) {
        return partnerService.addNewPartner(partner.getFirstName(), partner.getLastName(), partner.getDocId());
    }
}
