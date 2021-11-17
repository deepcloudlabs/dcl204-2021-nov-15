package com.example.animals.domain;

public class Cat extends Animal implements Pet {
	private String name;

	public Cat() { // default/no-arg constructor
		this("Tekir"); // delegates to other over-loaded constructor
	}

	public Cat(String name) {
		super(4); // delegates to super class' constructor
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.err.println(String.format("%s is playing now...", this.name));
	}

	@Override
	public void eat() {
		System.err.println(String.format("%s is eating now...", this.name));
	}

}
