package com.amcolabs.quizapp;

import java.util.ArrayList;
import java.util.HashMap;

import com.amcolabs.quizapp.databaseutils.Quiz;
import com.j256.ormlite.field.DatabaseField;

public class User {
	@DatabaseField(index=true, unique=true)
    public String uid;
	@DatabaseField
	public String name;
	public String deviceId;
	public String emailId;
	@DatabaseField
	public String pictureUrl;
	@DatabaseField
	public String coverUrl;	
	@DatabaseField
	public String gender;
	@DatabaseField
	public double birthday;
	@DatabaseField
	public String place;
	public boolean isActivated =false;
	public double createdAt;
	public String country; 
	@DatabaseField
	public String status;
	public String googlePlus;
	public String facebook;
	public ArrayList<Integer> badges;
	public HashMap<String,Integer> stats;
	public HashMap<String, Integer[]>winsLosses;
	private int userType = 0;
	@DatabaseField
	private String jsonDump;
	
	public String getFacebookAuthToken(){
		return facebook;
	}
	public String getGooglePlusAuthToken(){
		return googlePlus;
	}

	public static User getDummyUser(QuizApp quizApp) {
		return quizApp.getConfig().getGson().fromJson("{\"emailId\": \"ramasolipuram@gmail.com\", \"uid\": \"110040773460941325994\", \"isActivated\": true, \"googlePlus\": \"ya29.aACYqyIWDi39LksAAADNOtMCHgeTwAr1HzPWinCQtAq_6cjPmrtbqpwHnfwnK9GJDm4Df6I5_Bgwm8j_H7_m0czGX90AfjVtfPyvSbAp86y5y_DgUWffbXg_9RoF4g\", \"pictureUrl\": \"https://lh3.googleusercontent.com/-TyulralhJFw/AAAAAAAAAAI/AAAAAAAAA9o/8KyUnpS-j_Y/photo.jpg?sz=200\", \"deviceId\": \"31e7d9178c3ca41f\", \"winsLosses\": {}, \"stats\": {}, \"name\": \"Rama Reddy\", \"gender\": \"female\", \"birthday\": 0, \"newDeviceId\": \"31e7d9178c3ca41f\", \"badges\": [], \"activationKey\": \"\"}", User.class);
	}
	public int getLevel(Quiz quiz) {
		return 0;
	}
	
	public double getPoints(Quiz quiz){
		return 0;
	}
	
	public boolean isBotUser(){
		return uid.startsWith("0");
	}
	
	public void save(QuizApp quizApp){
		this.jsonDump = quizApp.getConfig().getGson().toJson(this);
		quizApp.getDataBaseHelper().saveUser(this);
	}
	
}

