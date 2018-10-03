package com.xebia.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

/**
 * Unit test for Robot prototype.
 */
public class AppTest {
  Robot robot;
  
  @Before
  public void setUp() {
    robot = RobotFactory.getRobot("");
  }
  
  @After
  public void tearDown() {
    robot = null;
  }
  
  @Test
  public void moveDistanceMaxAllowed() {
    assertEquals(robot.walkDistance(5000), 0.00f, 0.00f);
  }
  
  @Test
  public void moveWeightMaxAllowed() {
    assertTrue(robot.walkWithWeight(10, 50) <= 100.00f);
  }
  
  @Test
  public void moveDistanceMoreThanMaxAllowed() {
    assertEquals(robot.walkDistance(5001), 100.00f, 0.00f);
  }
  
  @Test
  public void moveWeightMoreThanMaxAllowed() {
    assertEquals(robot.walkWithWeight(11, 5000), 100.00f, 0.00f);
  }
  
  @Test
  public void moveSomeDistance() {
    assertEquals(robot.walkDistance(1000), 80.00f, 0.00f);
  }
  
  @Test
  public void moveSomeWeight() {
    assertEquals(robot.walkWithWeight(8, 500), 74.0f, 0.0f);
  }
}
