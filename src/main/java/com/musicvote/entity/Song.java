package com.musicvote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne              //insertable znamena, ze nevies cez song vytvorit party
    @JoinColumn(name="party_id", referencedColumnName = "id", insertable = false,
            updatable = false, nullable=false)
    private Party party;
}