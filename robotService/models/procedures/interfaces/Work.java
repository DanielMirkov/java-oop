package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.ALREADY_REPAIRED;
import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public class Work<R> extends BaseProcedure<Robot> {


    //•	Work class
    //o	doSerice() – removes 6 energy and adds 12 happiness

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }


        robot.setEnergy(robot.getEnergy() - 6);
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        this.getRobots().add(robot);
    }

}
