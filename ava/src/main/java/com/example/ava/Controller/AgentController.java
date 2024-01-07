package com.example.ava.Controller;

import com.example.ava.Model.Agent;
import com.example.ava.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/email/{email}")
    public Agent getAgentByEmail(@PathVariable String email) {
        return agentService.getAgentByEmail(email).orElse(null);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable Long id) {
        Optional<Agent> agent = agentService.getAgentById(id);

        if (agent.isPresent()) {
            return ResponseEntity.ok(agent.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/emailAndPassword")
    public Agent getAgentByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return agentService.getAgentByEmailAndPassword(email, password).orElse(null);
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
