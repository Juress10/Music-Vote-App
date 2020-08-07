package com.musicvote.controllers;

import com.musicvote.entity.Party;
import com.musicvote.entity.Song;
import com.musicvote.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.musicvote.service.PartyService;

import java.util.List;

@RestController
@RequestMapping("api/party")
public class PartyController {

    @Autowired
    private PartyService service;
    @Autowired
    private SongService songService;


    @GetMapping("/")
    public String index() {
        return "home";
    }

    @PostMapping("/addParty")
    public Party addProduct(@RequestBody Party product) {
        return service.saveParty(product);
    }

    @PostMapping("/addProducts")
    public List<Party> addProducts(@RequestBody List<Party> products) {
        return service.saveParties(products);
    }

    @GetMapping("/products")
    public List<Party> findAllProducts() {
        return service.getAllParty();
    }

    @GetMapping("/productById/{id}")
    public Party findProductById(@PathVariable int id) {
        return service.getPartyById(id);
    }

    @GetMapping("/product/{name}")
    public Party findProductByName(@PathVariable String name) {
        return service.getPartyByName(name);//todo je tu error pre viacero entit
    }

    @PutMapping("/update")
    public Party updateProduct(@RequestBody Party product) {
        return service.updateParty(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteParty(id);
    }

    @GetMapping("/partySongs/{name}")
    public List<Song> getAllPartySongs(@PathVariable String name) {
        return songService.getAllPartySongs(name);
    }

    @PostMapping("/addSong/{party_id}")
    public String addSongToParty(@RequestBody Song song,@PathVariable int party_id){
        return songService.addSongToParty(song,party_id);
    }
}
