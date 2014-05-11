package com.kunhong.design.Builder;

public class Director {
	private Builder mBuilder;

	public Director() {
	}

	public Director(Builder builder) {
		mBuilder = builder;
	}

	public void setDirector(Builder builder) {
		mBuilder = builder;
	}

	public Food construct(String name, String feature, String tastes,
			String chillies, String salt, String sugar) {
		mBuilder.setFoodName(name);
		mBuilder.setFoodFeature(feature);
		mBuilder.setFoodTastes(tastes);
		mBuilder.addChillies(chillies);
		mBuilder.addSalt(salt);
		mBuilder.addSugar(sugar);
		return mBuilder.getResult();
	}

}
