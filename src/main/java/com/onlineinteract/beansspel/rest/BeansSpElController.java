package com.onlineinteract.beansspel.rest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import com.onlineinteract.beansspel.model.Game;

@Controller
@EnableAutoConfiguration
public class BeansSpElController {

	@Autowired
	@Qualifier(value = "rock")
	Game game;

	@PostConstruct
	public void play() {
		game.setName("Space Rock");
		game.setLength(4);
		game.setWidth(3);
		game.setVolume(12);
		System.out.println();
		game.play();
		game.printDetails();
		System.out.println();
	}
}
