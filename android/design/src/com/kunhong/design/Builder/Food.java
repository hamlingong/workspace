package com.kunhong.design.Builder;

/**
 * 上面菜肴中各种属性，比较简单，就是一个实体类。
 * @author lyq
 *
 */
public class Food {
	private String mFoodName;
	private String mFoodTastes;
	private String mFoodFeatures;
	private String mChillies;
	private String mSugar;
	private String mSalt;

	public void setFoodName(String name) {
		mFoodName = name;
	}

	public String getFoodName() {
		return mFoodName;
	}

	public void setFoodTastes(String tastes) {
		mFoodTastes = tastes;
	}

	public String getFoodTastes() {
		return mFoodTastes;
	}

	public void setFoodFeatures(String features) {
		mFoodFeatures = features;
	}

	public String getFoodFeatures() {
		return mFoodFeatures;
	}

	public String getChillies() {
		return mChillies;
	}

	public void setChillies(String mChillies) {
		this.mChillies = mChillies;
	}

	public String getSugar() {
		return mSugar;
	}

	public void setSugar(String mSugar) {
		this.mSugar = mSugar;
	}

	public String getSalt() {
		return mSalt;
	}

	public void setSalt(String salt) {
		mSalt = salt;
	}

	@Override
	public String toString() {
		return "Food Name: " + getFoodName() + "\r\n" + "Food Feature: "
				+ getFoodFeatures() + "\r\n" + "Food Tastes: "
				+ getFoodTastes() + "\r\n" + "Food Chillies: " + getChillies()
				+ "\r\n" + "Food Salt: " + getSalt() + "\r\n" + "Food Sugar: "
				+ getSugar();
	}
}
