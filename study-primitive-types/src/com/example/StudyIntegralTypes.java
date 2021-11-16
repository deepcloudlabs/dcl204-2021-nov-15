package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte b = 1; // 1-Byte, [-128..127]
		b = 127;
		b++;
		System.err.println("b= " + b);
		b = -128;
		b--;
		System.err.println("b= " + b);
		short s = 1; // 2-Byte, [-32768..32767]
		s = Short.MAX_VALUE;
		System.err.println("s= " + s);
		s++;
		System.err.println("s= " + s);
		int i = Integer.MAX_VALUE; // 4-Byte, [-2147483648..2147483647]
		System.err.println("i= " + i);
		i++;
		System.err.println("i= " + i);
		long l = Long.MAX_VALUE; // 8-Byte [-9223372036854775808..9223372036854775807]
		System.err.println("l= " + l);
		l++;
		System.err.println("l= " + l);
		BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
		System.err.println("bi= " + bi);
		bi = bi.add(BigInteger.ONE);
		System.err.println("bi= " + bi);
		// i = 0/0; // ArithmeticException
		byte p = 127, q = 1;
		byte r = (byte) (p + q); // explicit type conversion, JLS: int -> byte
		System.err.println("r= " + r);
		long very_long = Integer.MAX_VALUE + 1L; // implicit conversion
		System.err.println("very_long: " + very_long);
		byte u = 3, v = 5, w = 0;
		w += u + v; // w = (byte)(w + u + v);
		long ll = 12345 + 5432L;
		System.err.println("ll= " + ll);
	}

}
