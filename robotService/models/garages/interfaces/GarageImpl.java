package robotService.models.garages.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.HashMap;
import java.util.Map;


import static robotService.common.ExceptionMessages.*;

public class GarageImpl implements Garage {
    private final static int CAPACITY = 10;

    Map<String, Robot> robots;

    public GarageImpl() {
        robots = new HashMap<>(CAPACITY);
    }
    @Override
    public Map<String, Robot> getRobots() {
        return this.robots;
    }

    @Override
    public void manufacture(Robot robot) {


        if (robots.size() > CAPACITY) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        } else {
            robots.put(robot.getName(), robot);
        }

    }

    @Override
    public void sell(String robotName, String ownerName) {
        if(!robots.containsKey(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
        robots.get(robotName).setOwner(ownerName);
        robots.get(robotName).setBought(true);
        robots.remove(robotName);
        //If the provided robot name does not exist in the garage, throw an IllegalArgumentException with the message "Robot {robot name} does not exist"
        //If a robot with that name exists, change its owner, its bought status and remove the robot from the garage.
    }
}
