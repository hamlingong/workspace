package com.kunhong.design.Builder;

public abstract class Builder {

	protected Food mFood = new Food();

	public abstract void setFoodName(String name);

	public abstract void setFoodTastes(String tastes);

	public abstract void setFoodFeature(String feature);

	public abstract void addSugar(String sugar);

	public abstract void addSalt(String salt);

	public abstract void addChillies(String chillies);

	public Food getResult() {
		return mFood;
	}
}
