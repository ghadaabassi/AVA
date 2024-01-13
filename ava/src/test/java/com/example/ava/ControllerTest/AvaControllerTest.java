package com.example.ava.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.ava.Controller.AgentController;
import com.example.ava.Controller.AvaController;
import com.example.ava.Controller.AvaEController;
import com.example.ava.Controller.PersonneController;
import com.example.ava.Model.Agent;
import com.example.ava.Model.Ava;
import com.example.ava.Model.AvaE;
import com.example.ava.Model.Client;
import com.example.ava.Model.Personne;
import com.example.ava.Model.Enums.Etat;
import com.example.ava.Service.AgentService;
import com.example.ava.Service.AvaEService;
import com.example.ava.Service.AvaService;
import com.example.ava.Service.BeneficiaireService;
import com.example.ava.Service.ClientService;
import com.example.ava.Service.PersonneService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class AvaControllerTest {

    @Mock
    private AvaService avaService;

    @Mock
    private PersonneService personneService;

    @Mock
    private PersonneController personneController;

    @Mock
    private ClientService clientService;

    @InjectMocks
    private AvaController avaController;

    @Mock
    private AvaEService avaEService;

    @Mock
    private BeneficiaireService beneficiaireService;

    @InjectMocks
    private AvaEController avaEController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private AgentService agentService;

    @InjectMocks
    private AgentController agentController;

    @Test
    public void testAvaAttente() throws Exception {
        Ava ava = new Ava();

        when(avaService.getAllAvas()).thenReturn(Collections.singletonList(ava));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/avas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ava)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/avas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[-1].etat").value("Attente"));
    }

    @Test
    public void testActivateAva() {
     
        Long avaId = 1L;
        Ava existingAva = new Ava();
        existingAva.setId(avaId);
        existingAva.setEtat(Etat.Attente);

        when(avaService.getAvaById(avaId)).thenReturn(Optional.of(existingAva));

        when(avaService.saveAva(existingAva)).thenReturn(existingAva);

        ResponseEntity<String> responseEntity = avaController.activateAva(avaId);

        verify(avaService, times(1)).getAvaById(avaId);
        verify(avaService, times(1)).saveAva(existingAva);
        
        assertEquals(ResponseEntity.ok("L'état de l'Ava a été changé avec succès."), responseEntity);
    }

    
    @Test
    public void testUtilizeAva() {
        
        Long avaId = 1L;
        double amountToUtilize = 20.0;
        Ava existingAva = new Ava();
        existingAva.setId(avaId);
        existingAva.setEtat(Etat.Actif);
        existingAva.setSolde(30.0); 







        

        when(avaService.getAvaById(avaId)).thenReturn(Optional.of(existingAva));
    
        when(avaService.saveAva(existingAva)).thenReturn(existingAva);

        ResponseEntity<String> responseEntity = avaController.utilizeAva(avaId, amountToUtilize);

        verify(avaService, times(1)).getAvaById(avaId);
        verify(avaService, times(1)).saveAva(existingAva);

    
     

        assertEquals(existingAva.getSolde(), 10.0); 
        assertEquals(ResponseEntity.ok("Le montant a été retiré avec succès."), responseEntity);
    }

}
