package com.example.healthcoaches.objectClasses;

public class DailyLog {
    public String date;
    public String weightLog;
    public String usernameLog;

    public DailyLog() {

    }

    public DailyLog(String Date, String WeightLog, String Username) {
        this.date = Date;
        this.weightLog = WeightLog;
        this.usernameLog = Username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeightLog() {
        return weightLog;
    }

    public void setWeightLog(String weightLog) {
        this.weightLog = weightLog;
    }

    public String getUsernameLog() {
        return usernameLog;
    }

    public void setUsernameLog(String usernameLog) {
        this.usernameLog = usernameLog;
    }
}
