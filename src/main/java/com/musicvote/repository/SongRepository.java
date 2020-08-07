package com.musicvote.repository;

import com.musicvote.entity.Party;
import com.musicvote.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {

    Song findByName(String name);

    @Query("Select s from Song s Join Party p ON s.party.id=p.id WHERE p.name=?1")
    List<Song> findByPartyName(String name);
}