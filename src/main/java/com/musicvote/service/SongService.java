package com.musicvote.service;

import com.musicvote.entity.Party;
import com.musicvote.entity.Song;
import com.musicvote.repository.PartyRepository;
import com.musicvote.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllPartySongs(String name) {
        Party party = partyRepository.findByName(name);
        return party.getSongs();
    }

    public String addSongToParty(Song song, int id) {

        Party p = partyRepository.findById(id).get();
        if(p != null) {
            p.getSongs().add(song);
            System.out.println(p);
            partyRepository.save(p);
            return "1";
        }
        return "0";
    }
}
