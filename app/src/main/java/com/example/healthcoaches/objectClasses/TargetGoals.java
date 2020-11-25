package com.example.healthcoaches.objectClasses;

public class TargetGoals {
    public String weightGoal;
    public String calorieGoal;
    public String usernameGoal;

    public TargetGoals() {

    }

    public TargetGoals(String WeightGoal, String CalorieGoal, String Username) {
        this.weightGoal = WeightGoal;
        this.calorieGoal = CalorieGoal;
        this.usernameGoal = Username;
    }

    public String getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(String weightGoal) {
        this.weightGoal = weightGoal;
    }

    public String getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(String calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public String getUsernameGoal() {
        return usernameGoal;
    }

    public void setUsernameGoal(String usernameGoal) {
        this.usernameGoal = usernameGoal;
    }
}
