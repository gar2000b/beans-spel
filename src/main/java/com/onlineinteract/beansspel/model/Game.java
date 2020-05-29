package com.onlineinteract.beansspel.model;

import org.springframework.beans.factory.annotation.Value;

public abstract class Game {
	String name;
	int width;
	int length;
	@Value("#{10 + 4}")
	int volume;

	public abstract void play();

	public void printDetails() {
		System.out.println("Name: " + name);
		System.out.println("Width: " + width);
		System.out.println("Length: " + length);
		System.out.println("Volume: " + volume);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
