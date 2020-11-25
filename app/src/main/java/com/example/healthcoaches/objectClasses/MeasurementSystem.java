package com.example.healthcoaches.objectClasses;

public class MeasurementSystem {

    public MeasurementSystem() {

    }

    public static boolean getSelectedSystem(boolean selectedSystem) {
        boolean input;
        if(selectedSystem == true){
            input = true;
        }
        else {
            input = false;
        }
        return input;
    }


}
