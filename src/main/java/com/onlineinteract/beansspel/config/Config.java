package com.onlineinteract.beansspel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onlineinteract.beansspel.model.Game;
import com.onlineinteract.beansspel.model.Paper;
import com.onlineinteract.beansspel.model.Rock;

@Configuration
public class Config {

	@Bean()
	public Game rock() {
		return new Rock();
	}

	@Bean
	public Game paper() {
		return new Paper();
	}
}
