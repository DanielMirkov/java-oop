package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.stream.IntStream;

import static robotService.common.ExceptionMessages.ALREADY_REPAIRED;
import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public class Charge<T extends Robot> extends BaseProcedure<Robot> {
    //•	Charge class
    //o	doSerice() – adds 12 happiness and 10 energy

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }


        robot.setEnergy(robot.getEnergy() + 10);
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        this.getRobots().add(robot);
    }
//        boolean robotExists =  getRobots().stream().anyMatch(robot1 -> robot1.getClass().equals(robot));
//        if (robotExists) {
//            robot.setEnergy(getRobots().stream().mapToInt(r1 -> {
//                if (r1 == robot) {
//                robot.setEnergy(robot.getEnergy() + 10);
//                return robot.getEnergy();
//                }
//                return r1.getEnergy();
//            }).findAny().getAsInt());
//        robot.setHappiness(robot.getHappiness() + 12);
//        }
//        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);



}
