package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;

public class Repair<R> extends BaseProcedure<Robot> {

    //•	Repair class
    //o	doSerice()– removes 5 happiness and repairs current robot. Robot can be repaired once.
    // If robot is already repaired throw an IllegalArgumentException with message "{robotName} is already repaired"
    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }

        if (robot.isRepaired()) {
            throw new IllegalArgumentException(String.format(ALREADY_REPAIRED, robot.getName()));
        }
        robot.setRepaired(true);
        robot.setHappiness(robot.getHappiness() - 5);
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        this.getRobots().add(robot);
    }
    //o	doSerice()– removes 5 happiness and repairs current robot. Robot can be repaired once.
    // If robot is already repaired throw an IllegalArgumentException with message "{robotName} is already repaired"
}
