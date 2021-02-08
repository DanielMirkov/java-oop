package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseProcedure<T extends Robot> implements Procedure {

    private Collection<Robot> robots;


    public BaseProcedure() {
        this.robots = new ArrayList<>();
    }

    public Collection<Robot> getRobots() {
        return robots;
    }


    @Override
    public String history() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s", this.getClass().getSimpleName())).append(System.lineSeparator());
        for (Robot robot : robots) {

            stringBuilder.append(robot.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }



    //Returns a String with information about current procedure type and its robots. The returned string must be in the following format:
    //"{procedureType}"
    // " Robot type: {robotType} - {robotName} - Happiness: {happiness} - Energy: {energy}"
    //void doService(Robot robot, int procedureTime)

    //Each procedure must check if the robot procedure time is more than or equal
    // to the time each procedure will take. If robot procedure time is lower than
    // the time for the current procedure throw IllegalArgumentException with message
    // "Robot doesn't have enough procedure time"

    //NOTE: Every time when doService() method has called, current robot is added
    // to the robot's collection and the time the procedure took is subtracted from
    // the robot’s allowed procedure time.
}
