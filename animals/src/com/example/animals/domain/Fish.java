package com.example.animals.domain;

public class Fish extends Animal implements Pet {
	private String name;

	public Fish(String name) {
		super(0);
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
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

	@Override
	public void walk() {
		System.err.println(String.format("%s is swimming now...", this.name));
	}
	
}
