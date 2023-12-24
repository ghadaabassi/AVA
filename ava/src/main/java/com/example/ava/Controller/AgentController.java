package com.example.ava.Controller;

import com.example.ava.Model.Agent;
import com.example.ava.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public List<Agent> getAllAgents() {
        return agentService.getAllAgents();
    }

    @GetMapping("/{email}")
    public Agent getAgentByEmail(@PathVariable String email) {
        return agentService.getAgentByEmail(email).orElse(null);
    }

    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }

    @PutMapping("/{email}")
    public Agent updateAgent(@PathVariable String email, @RequestBody Agent updatedAgent) {
        return agentService.updateAgent(email, updatedAgent).orElse(null);
    }

    @DeleteMapping("/{email}")
    public void deleteAgent(@PathVariable String email) {
        agentService.deleteAgentByEmail(email);
    }
}
