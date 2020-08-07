package com.musicvote.service;

import com.musicvote.entity.Party;
import com.musicvote.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.musicvote.repository.PartyRepository;

import java.util.List;

@Service
public class PartyService {

    @Autowired
    private PartyRepository repository;

    public Party saveParty(Party party) {
        return repository.save(party);
    }

    public List<Party> saveParties(List<Party> parties) {
        return repository.saveAll(parties);
    }

    public List<Party> getAllParty(){
        return repository.findAll();
    }

    public Party getPartyById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Party getPartyByName(String name) {
        return repository.findByName(name);
    }

    public String deleteParty(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Party updateParty(Party party) {
        Party existingProduct = repository.findById(party.getId()).orElse(null);
        existingProduct.setName(party.getName());
        return repository.save(existingProduct);
    }
}
