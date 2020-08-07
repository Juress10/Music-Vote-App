package com.musicvote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.musicvote.repository.PartyRepository;

@SpringBootApplication()
public class MusicVoteApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicVoteApplication.class, args);
	}
}
