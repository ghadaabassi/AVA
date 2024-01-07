package com.example.ava.Controller;

import com.example.ava.Model.Beneficiaire;
import com.example.ava.Service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaires")
@CrossOrigin(origins = "*")
public class BeneficiaireController {

    private final BeneficiaireService beneficiaireService;

    @Autowired
    public BeneficiaireController(BeneficiaireService beneficiaireService) {
        this.beneficiaireService = beneficiaireService;
    }

    @GetMapping
    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficiaireService.getAllBeneficiaires();
    }

    @GetMapping("/{email}")
    public Beneficiaire getBeneficiaireByEmail(@PathVariable String email) {
        return beneficiaireService.getBeneficiaireByEmail(email).orElse(null);
    }

    @PostMapping
    public Beneficiaire createBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        return beneficiaireService.saveBeneficiaire(beneficiaire);
    }

    @PutMapping("/{email}")
    public Beneficiaire updateBeneficiaire(@PathVariable String email, @RequestBody Beneficiaire updatedBeneficiaire) {
        return beneficiaireService.updateBeneficiaire(email, updatedBeneficiaire).orElse(null);
    }

    @DeleteMapping("/{email}")
    public void deleteBeneficiaire(@PathVariable String email) {
        beneficiaireService.deleteBeneficiaireByEmail(email);
    }
}
