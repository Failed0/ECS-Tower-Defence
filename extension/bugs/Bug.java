package bugs;

import static java.lang.Math.pow;
import java.lang.Comparable;
import java.lang.*;

public class Bug {
    public String name;
    int baseHp, baseSteps;
    public int level;
    public int currentHp;

    public int getBaseSteps() {
        return baseSteps;
    }

    public int getLevel() {
        return level;
    }


    public Bug(String name, int baseHp, int baseSteps, int level) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSteps = baseSteps;
        this.level = level;
        this.currentHp = (int) Math.round(baseHp * pow(level, 1.5));
    }

/**
Using toString to print out
 the values at the end
 */
    @Override
    public String toString() {
        return "Bug{" +
                "name='" + name + '\'' +
                ", baseHp=" + baseHp +
                ", baseSteps=" + baseSteps +
                ", level=" + level +
                ", currentHp=" + currentHp +
                ", currentSteps=" + currentSteps +
                ", currentFloor=" + currentFloor +
                '}';
    }

    int currentSteps;
    public int currentFloor = -1;

    public int getCurrentHp() {
        return currentHp;
    }


    public int getCurrentSteps() {
        return currentSteps;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String getName() {
        return name;
    }

    public Bug(String name, int baseHp, int baseSteps, int level, int initialSteps) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSteps = baseSteps;
        this.level = level;
        this.currentSteps = initialSteps;
        this.currentHp = (int) Math.round(baseHp * pow(level, 1.5));
    }
/**
This method will move only one bug at a time
*/
    public void move() {
        if (currentSteps > 0) {
            currentSteps -= 1;
        } else {
            currentFloor += 1;
            currentSteps = baseSteps - 1;
        }
    }
/**
method to decrease the health of a single bug
    */
    public void damage(int amount) {
        if (currentHp - amount <= 0) {
            currentHp = 0;
            System.out.println("The Bug is dead ");
        }else {
            currentHp -= amount;
        }
    }
  /**
    it increases the number of steps required to move to the next floor
    */
    public void slowDown(int steps) {
        currentSteps += steps;
    }
}



