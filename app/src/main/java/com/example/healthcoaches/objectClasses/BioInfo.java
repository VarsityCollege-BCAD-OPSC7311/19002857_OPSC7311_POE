package com.example.healthcoaches.objectClasses;

public class BioInfo {
   public String weight;
   public String height;
   public String age;
   public String weightGoal;
   public String foodPreference;
   public String bioUsername;

   public BioInfo() {

   }

   public BioInfo(String Weight, String Height, String Age, String WeightGoal, String FoodPreference, String Username) {
       this.weight = Weight;
       this.height = Height;
       this.age = Age;
       this.weightGoal = WeightGoal;
       this.foodPreference = FoodPreference;
       this.bioUsername = Username;
   }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(String weightGoal) {
        this.weightGoal = weightGoal;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public String getBioUsername() {
        return bioUsername;
    }

    public void setBioUsername(String bioUsername) {
        this.bioUsername = bioUsername;
    }
}
