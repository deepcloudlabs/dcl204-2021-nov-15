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

class Base {
	int x;
}
class AA extends Base {
	public AA() {
		super();
	}
}
class BB extends Base {}
class CC extends AA {
	void fun() {
		x++; // which x?
	}
}

abstract interface I1 {
	int x=42;
	void fun(int x,double y);
}

interface I2 {
	public abstract void fun(int x,double y);	
	void fun(int x);	
}
interface I3 {
	void fun(int x,double y);	
	public abstract void fun(double y);		
}
interface I4 extends I1, I2, I3 {}

abstract class DDD implements I1, I3 {

	
	
}
