package com.example.ava.Controller;

import com.example.ava.Model.AvaE;
import com.example.ava.Model.Beneficiaire;
import com.example.ava.Model.Client;
import com.example.ava.Service.AvaEService;
import com.example.ava.Service.BeneficiaireService;
import com.example.ava.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/avaes")
public class AvaEController {

    private final AvaEService avaEService;
    private final ClientService clientService;
    private final BeneficiaireService beneficiaireService;

    @Autowired
    public AvaEController(AvaEService avaEService, ClientService clientService,
            BeneficiaireService beneficiaireService) {
        this.avaEService = avaEService;
        this.clientService = clientService;
        this.beneficiaireService = beneficiaireService;
    }

    @GetMapping
    public List<AvaE> getAllAvaEs() {
        return avaEService.getAllAvaEs();
    }

    @GetMapping("/{id}")
    public AvaE getAvaEById(@PathVariable Long id) {
        return avaEService.getAvaEById(id).orElse(null);
    }

    @PostMapping
    public AvaE createAvaE(@RequestBody AvaE avaE) {
        /*
         * if (avaE.getBeneficiaires() != null && !avaE.getBeneficiaires().isEmpty()) {
         * Beneficiaire newBeneficiaire = avaE.getBeneficiaires().get(0);
         * System.out.println("\ntypeeeeeeeeee: " + avaE.getBeneficiaires().get(0) +
         * "\n\n");
         * 
         * Beneficiaire savedBeneficiaire =
         * beneficiaireService.saveBeneficiaire(newBeneficiaire);
         * avaE.getBeneficiaires().add(savedBeneficiaire);
         * }
         * 
         * /////////////////
         * 
         * if (avaE.getBeneficiaires() != null && !avaE.getBeneficiaires().isEmpty()) {
         * Beneficiaire newBeneficiaire = avaE.getBeneficiaires().get(0);
         * 
         * // Check if the Beneficiaire is not yet persisted in the database
         * //if (newBeneficiaire.getFonction() = null) {
         * // If not persisted, save the Beneficiaire first
         * Beneficiaire savedBeneficiaire =
         * beneficiaireService.saveBeneficiaire(newBeneficiaire);
         * 
         * // Update the reference in the AvaE entity
         * //avaE.getBeneficiaires().clear();
         * avaE.getBeneficiaires().add(savedBeneficiaire);
         * //}
         * }
         * 
         */

        if (avaE.getClient() != null) {

            Client savedClient = clientService.saveClient(avaE.getClient());
            avaE.setClient(savedClient);
            avaE.setSolde(avaE.getBase() / 2);
            avaE.setType(1);
            System.out.println("\ntypeeeeeeeeee: " + avaE.getClass().getSimpleName() + "\n\n");
        }

        return avaEService.saveAvaE(avaE);
    }

    @PutMapping("/{id}")
    public AvaE updateAvaE(@PathVariable Long id, @RequestBody AvaE avaE) {
        avaE.setId(id);
        return avaEService.saveAvaE(avaE);
    }

    @DeleteMapping("/{id}")
    public void deleteAvaE(@PathVariable Long id) {
        avaEService.deleteAvaE(id);
    }

    @GetMapping("/client-email/{clientEmail}")
    public List<AvaE> getAvaEsByClientEmail(@PathVariable String clientEmail) {
        return avaEService.getAvaEsByClientEmail(clientEmail);
    }
}
