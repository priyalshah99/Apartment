package com.apartment.utils;

import java.util.Random;

public final class RandomNumber {
	public static String getNext() {
		Random random = new Random();
		int n = 100000 + random.nextInt(900000);
		return String.valueOf(n);
	}
}
