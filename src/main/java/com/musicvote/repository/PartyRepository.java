package com.musicvote.repository;

import com.musicvote.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party,Integer> {

    @Query("FROM Party WHERE name = ?1")
    Party findByName(String name);
}

