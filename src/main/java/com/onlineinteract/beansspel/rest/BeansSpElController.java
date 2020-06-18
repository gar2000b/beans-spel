package com.onlineinteract.beansspel.rest;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineinteract.beansspel.model.Game;
import com.onlineinteract.beansspel.process.InfoProcessor;

@RestController
//@EnableAutoConfiguration
public class BeansSpElController {

	private static final String ENTITLEMENTS_1_IMPORTANT = "@rock.volume == 14 && @rock.volume == 14 && @rock.volume == 14 && "
			+ "@rock.volume == 14 && @rock.volume == 14 && @rock.volume == 14 && @rock.volume == 14 && "
			+ "@rock.volume == 14 && @rock.volume == 14 && @rock.volume == 14";

	@Autowired
	InfoProcessor infoProcessor;
	
	@Autowired
	@Qualifier(value = "rock")
	Game game;

	@PostConstruct
	public void play() {
		game.setName("Space Rock");
		game.setLength(4);
		game.setWidth(3);
		System.out.println();
		game.play();
		game.printDetails();
		System.out.println();
	}

	@RequestMapping("/important")
	// @PreAuthorize(ENTITLEMENTS_1_IMPORTANT)
	public void important(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Important method invoked successfully");
		// throw new RuntimeException("test exception");
		infoProcessor.process();
	}
}
