package com.onlineinteract.beansspel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeansSpElApplication {
	public static String FILE_PATH = "/files/";

	public static void main(String[] args) {
		if (args.length > 0)
			FILE_PATH = args[0] + "/";
		System.out.println("File Path set is: " + FILE_PATH);
		SpringApplication.run(BeansSpElApplication.class, args);
	}

}
