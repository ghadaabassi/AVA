package com.example.ava.ControllerTest;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.ava.Controller.AgentController;
import com.example.ava.Controller.AvaController;
import com.example.ava.Controller.PersonneController;
import com.example.ava.Model.Agent;
import com.example.ava.Model.Ava;
import com.example.ava.Model.AvaE;
import com.example.ava.Model.Personne;
import com.example.ava.Model.Enums.Etat;
import com.example.ava.Service.AgentService;
import com.example.ava.Service.AvaService;
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





}
