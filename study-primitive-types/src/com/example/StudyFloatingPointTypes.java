package com.example;

import java.math.BigDecimal;

public class StudyFloatingPointTypes {

	public static void main(String[] args) {
		float f = 3.1415F; // 4-Byte
		double d = 3.1415; // 8-Byte (FPU) - IEEE-754 v5
		d = 2.0;
		d = d - 1.10;
		System.err.println(String.format("%3.16f", d));
		f = 1_000_000_000;
		f = f + 50;
		System.err.println(String.format("%12.3f", f));
		d = 4.35;
		d = d * 100;
		System.err.println(String.format("%3.16f", d));
		BigDecimal bd = BigDecimal.valueOf(4.35); // immutable
		bd = bd.multiply(BigDecimal.valueOf(100));
		System.err.println("bd: " + bd.toString());
		d = 1 / -0D; // ALU
		System.err.println("d= " + d);
		d = 0 / 0D;
		System.err.println("d= " + d);
		d++;
		System.err.println(Double.isNaN(d));
		System.out.println(Double.isNaN(d));
	}

}
