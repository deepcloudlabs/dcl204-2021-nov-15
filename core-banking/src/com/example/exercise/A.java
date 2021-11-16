package com.example.exercise;

@SuppressWarnings("unused")
public class A extends Object {
	private class C { // inner class

	}

}

class B extends Object {

}

class U extends Object {
	public U(int x) {
	}
}

class V extends U {
	public V() {
		super(42); // No-argument Constructor
	}
}