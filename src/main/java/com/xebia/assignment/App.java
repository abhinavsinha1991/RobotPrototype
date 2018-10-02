package com.xebia.assignment;

/**
 * @author abhinav sinha
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Robot simpleRobot=RobotFactory.getRobot("");
        System.out.println("Battery %age:"+simpleRobot.walkDistance(500));
        simpleRobot.scanItem();
        System.out.println("Battery %age:"+simpleRobot.walkWithWeight(5,100));
        System.out.println("Battery %age:"+simpleRobot.walkWithWeight(5,100));
        System.out.println("Battery %age:"+simpleRobot.walkDistance(500));
        System.out.println("Battery %age:"+simpleRobot.walkDistance(500));
        System.out.println("Battery %age:"+simpleRobot.walkWithWeight(5,100));
        System.out.println("Battery %age:"+simpleRobot.walkWithWeight(18,100));
    }
}
