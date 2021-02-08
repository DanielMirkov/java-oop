package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.models.garages.interfaces.Garage;
import robotService.models.garages.interfaces.GarageImpl;
import robotService.models.procedures.interfaces.Charge;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.procedures.interfaces.Repair;
import robotService.models.procedures.interfaces.Work;
import robotService.models.robots.interfaces.Cleaner;
import robotService.models.robots.interfaces.Housekeeper;
import robotService.models.robots.interfaces.Robot;

import javax.swing.*;

import static robotService.common.ExceptionMessages.*;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Garage garage;
    private Charge<Robot> charge;
    private Work<Robot> work;
    private Repair<Robot> repair;
    private String robotType;
    private String name;
    private int energy;
    private int happiness;
    private int procedureTime;


    public ControllerImpl() {
        garage = new GarageImpl();
        charge = new Charge<>();
        work = new Work<>();
        repair = new Repair<>();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {

        if (garage.getRobots().containsKey(name)) {
            throw new IllegalArgumentException(String.format(EXISTING_ROBOT, name));
        }
        Robot robot;
        if (robotType.equals("Housekeeper")) {
            robot = new Housekeeper(name, energy, happiness, procedureTime);
        } else if (robotType.equals("Cleaner")) {
            robot = new Cleaner(name, energy, happiness, procedureTime);
        } else {
            throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE, robotType));
        }

        garage.manufacture(robot);
        return String.format(ROBOT_MANUFACTURED, name);
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        if (!robotExists(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }

        repair.doService(garage.getRobots().get(robotName), procedureTime);
        garage.getRobots().get(robotName).setRepaired(true);
        return String.format(REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        if (!robotExists(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
        work.doService(garage.getRobots().get(robotName), procedureTime);
        return String.format(WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        if (!robotExists(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
        charge.doService(garage.getRobots().get(robotName), procedureTime);
        return String.format(CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        if (!robotExists(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
        garage.sell(robotName, ownerName);


        return String.format(SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
        StringBuilder stringBuilder = new StringBuilder();
        ;
        if (procedureType.equals("Repair")) {
            stringBuilder.append(repair.history());
        } else if (procedureType.equals("Work")) {
            stringBuilder.append(work.history());
        } else if (procedureType.equals("Charge")) {
            stringBuilder.append(charge.history());
        }

        return stringBuilder.toString().trim();
    }

    private boolean robotExists(String robot) {
        if (garage.getRobots().containsKey(robot)) {
           return true;
        }
        return false;
    }
}
