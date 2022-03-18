package students;

import bugs.Bug;
import building.Building;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class AiStudent implements Student{

    int level;
    int baseAtk;
    int delay;
    int count;

    public AiStudent(int level) {
        this.level = level;
        this.baseAtk = 7;
        this.delay = 7;
        this.count = 0;
    }
    /**
    * Special Ability using machine learning.
    * Damage first 3 bugs.
     */
    @Override
    public String toString() {
        return "AiStudent{" +
                "level=" + level +
                ", baseAtk=" + baseAtk +
                ", delay=" + delay +
                ", count=" + count +
                '}';
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int upgradeCost() {
        return (int)((100)* pow(2, level));
    }

    @Override
    public void upgradeLevel() {
        level +=1;
    }

/**
 * Students attacks the bug which is nearest to the top floor.
 * @return the points earned by the students after defeating the bug.
 */
    @Override
    public int defence(Building b) {
        count += 1;
        int points =0;
        if(b.getAllBugs().length != 0) {
            final Bug firstBug = b.getAllBugs()[0];
            if (count % delay == 0) {            // Checking if it is a special Attack
                if (b.getAllBugs().length >= 3) {
                    System.out.println("(Students)Using machine learning SpecialAbility");
                    firstBug.damage((int) Math.round(baseAtk * pow(level, 1.2)));
                    b.getAllBugs()[1].damage((int) Math.round(baseAtk * pow(level, 1.2)));
                    b.getAllBugs()[2].damage((int) Math.round(baseAtk * pow(level, 1.2)));
                } else if (b.getAllBugs().length == 2) {
                    System.out.println("(Students)Using machine learning SpecialAbility on 2 bugs");
                    firstBug.damage((int) Math.round(baseAtk * pow(level, 1.2)));
                    b.getAllBugs()[1].damage((int) Math.round(baseAtk * pow(level, 1.2)));
                } else if (b.getAllBugs().length == 1) {
                    System.out.println("(Students)Using machine learning SpecialAbility on 1 bug");
                    firstBug.damage((int) Math.round(baseAtk * pow(level, 1.2)));
                }
            } else {
                firstBug.damage((int) Math.round(baseAtk * pow(level, 1.2)));
            }
            if (firstBug.getCurrentHp() <= 0) {      // Adds the points if the bug is dead
                points = firstBug.getLevel() * 20;
                b.removeBug(firstBug);
                return points;
            }
        }
        return points;
    }
}
