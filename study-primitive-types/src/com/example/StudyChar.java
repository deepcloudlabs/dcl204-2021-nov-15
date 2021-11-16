package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char c = 'x'; // 2-Byte
		System.err.println("c= " + (int) c);
		System.err.println("c= " + (char) (c + 1));
		c = '\u20BA';
		// c = (char)0;
		System.err.println(c);
	}

}
