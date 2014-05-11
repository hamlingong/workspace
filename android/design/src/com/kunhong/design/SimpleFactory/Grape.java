package com.kunhong.design.SimpleFactory;

public class Grape implements Fruit {
	private boolean seedless;

	public void grow() {
		log("Grape is growing.");
	}

	public void harvest() {
		log("Grape has been harvested");
	}

	public void plant() {
		log("Grape ha been planted");
	}

	public static void log(String msg) {
		System.out.println(msg);
	}

	public boolean isSeedless() {
		return seedless;
	}

	public void setSeedless(boolean seedless) {
		this.seedless = seedless;
	}

}
