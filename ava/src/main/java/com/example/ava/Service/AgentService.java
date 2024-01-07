package com.example.ava.Service;

import com.example.ava.Model.Agent;
import com.example.ava.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Optional<Agent> getAgentByEmail(String email) {
        return agentRepository.findByEmail(email);
    }

    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public void deleteAgentByEmail(String email) {
        Optional<Agent> existingAgent = agentRepository.findByEmail(email);
        existingAgent.ifPresent(agent -> agentRepository.delete(agent));
    }


    public Optional<Agent> getAgentByEmailAndPassword(String email, String password) {
       
        Optional<Agent> optionalAgent = agentRepository.findByEmail(email);

       
        if (optionalAgent.isPresent() && verifyPassword(optionalAgent.get(), password)) {
            return optionalAgent;
        } else {
            return Optional.empty();
        }
    }

    private boolean verifyPassword(Agent agent, String password) {

        return agent.getPassword().equals(password);
    }

    public Optional<Agent> getAgentById(Long id) {
        
        return agentRepository.findById(id);
    }
    


    public Optional<Agent> updateAgent(String email, Agent updatedAgent) {
        return getAgentByEmail(email).map(existingAgent -> {
            existingAgent.setFirstName(updatedAgent.getFirstName());
            existingAgent.setLastName(updatedAgent.getLastName());
            existingAgent.setEmail(updatedAgent.getEmail());
            existingAgent.setPhoneNumber(updatedAgent.getPhoneNumber());
            existingAgent.setEtranger(updatedAgent.isEtranger());
            return saveAgent(existingAgent);
        });
    }
}
