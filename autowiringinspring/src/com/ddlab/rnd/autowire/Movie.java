package com.ddlab.rnd.autowire;

public class Movie {
	
	private String name;
	
	private Actor actor;
	
	public Movie( Actor actor ) {
		this.actor = actor;
	}
	
	public Movie() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
