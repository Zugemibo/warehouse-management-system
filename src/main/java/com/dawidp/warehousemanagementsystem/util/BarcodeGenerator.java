package com.dawidp.warehousemanagementsystem.util;

import java.util.Random;

import lombok.Data;

@Data
public class BarcodeGenerator {
	int leftLimit = 97; // letter 'a'
	int rightLimit = 122; // letter 'z'
	int targetStringLength = 4;
	Random random = new Random();
	String generatedString = null;
	private static BarcodeGenerator gen = null;

	private BarcodeGenerator() {
		generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

	public static BarcodeGenerator getInstance() {
		if (gen == null)
			gen = new BarcodeGenerator();
		return gen;
	}

	public String getPalette() {
		return "P" + this.generatedString.toUpperCase();
	}

}
