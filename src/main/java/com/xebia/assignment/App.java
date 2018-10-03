package com.xebia.assignment;

/*
 * @author abhinav sinha
 */
public class App {
    public static void main(String[] args) {
        
        Robot simpleRobot = RobotFactory.getRobot("");
        System.out.println("Battery %age:" + simpleRobot.walkDistance(3500));
        simpleRobot.scanItem();
        System.out.println("Battery %age:" + simpleRobot.walkWithWeight(3, 2000));
        System.out.println("Battery %age:" + simpleRobot.walkWithWeight(12, 0));
    }
}
