package com.musicvote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "party")
public class Party {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "party", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Song> songs = new ArrayList<>();

}