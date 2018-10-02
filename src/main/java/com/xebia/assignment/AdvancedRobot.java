package com.xebia.assignment;

import java.util.Random;

public class AdvancedRobot implements Robot {

    private float currentCharge=100.00f;
    private static final int MAX_DISTANCE_PER_CHARGE =10000;
    private static final float PER_METRE_CHARGE_WITHOUT_WEIGHT =0.01f;
    private static final float PER_METRE_CHARGE_WITH_UNIT_WEIGHT =0.0102f;
    private static final int MAX_WEIGHT_CAP =10;
    private boolean batteryLowIndicator;

    public float getCurrentCharge() {
        return currentCharge;
    }

    public void setCurrentCharge(float currentCharge) {
        this.currentCharge = currentCharge;
    }

    public static int getMaxDistancePerCharge() {
        return MAX_DISTANCE_PER_CHARGE;
    }

    public static float getPerMetreChargeWithoutWeight() {
        return PER_METRE_CHARGE_WITHOUT_WEIGHT;
    }

    public static float getPerMetreChargeWithUnitWeight() {
        return PER_METRE_CHARGE_WITH_UNIT_WEIGHT;
    }

    public boolean isBatteryLowIndicator() {
        return batteryLowIndicator;
    }

    public void setBatteryLowIndicator(boolean batteryLowIndicator) {
        this.batteryLowIndicator = batteryLowIndicator;
    }

    public static int getMaxWeightCap() {
        return MAX_WEIGHT_CAP;
    }


    @Override
    public float walkDistance(int distance) {
        if(distance>= MAX_DISTANCE_PER_CHARGE){
            System.out.print("Max limit reached.Decrease distance.");
        }else {
            if ((currentCharge - (distance * PER_METRE_CHARGE_WITHOUT_WEIGHT)) >= 0.00f) {
                currentCharge -= distance * PER_METRE_CHARGE_WITHOUT_WEIGHT;
                if (currentCharge <= 15.00f) {
                    batteryLowIndicator = true;
                }
                System.out.print("Robot has moved " + distance + " metres distance and battery status is " + (batteryLowIndicator ? "low." : "adequate."));
            }else{
                System.out.print("Battery running at "+currentCharge+"%.\nCharge reqd to fulfill request: "+(distance* PER_METRE_CHARGE_WITH_UNIT_WEIGHT)+"%. Please decrease distance.");
            }
        }
        return currentCharge;
    }

    @Override
    public float walkWithWeight(int weight,int distance) {
        if(distance>= MAX_DISTANCE_PER_CHARGE ||weight> MAX_WEIGHT_CAP){
            System.out.print("Max limit reached.Decrease distance.");
        }else {
            if (((currentCharge - (distance * PER_METRE_CHARGE_WITH_UNIT_WEIGHT *weight)) >= 0.00f)) {
                currentCharge -= distance * PER_METRE_CHARGE_WITH_UNIT_WEIGHT * weight;
                if (currentCharge <= 15.00f) {
                    batteryLowIndicator = true;
                }
                System.out.print("Robot has moved " + distance + " metres distance with weight "+weight+" kgs and battery status is " + (batteryLowIndicator ? "low." : "adequate."));
            }else{
                System.out.print("Battery running at "+currentCharge+"%.\nCharge reqd to fulfill request: "+(distance* PER_METRE_CHARGE_WITH_UNIT_WEIGHT *weight)+"%. Please decrease distance/weight.");
            }
        }
        return currentCharge;
    }

    @Override
    public void scanItem() {
        //Simulating Third party API call
        Random random=new Random();
        if(random.nextBoolean()){
            System.out.println("Item scanned successfully");
        }else{
            System.out.println("Scan Failure!");
        }


    }
}