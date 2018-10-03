package com.xebia.assignment;

public class RobotFactory {
    
    public static Robot getRobot(String type) {
        if ("advanced".equals(type)) {
            return new AdvancedRobot();
        } else {
            return new SimpleRobot();
        }
    }
}
