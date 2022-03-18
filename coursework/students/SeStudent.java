package students;

import bugs.Bug;
import building.Building;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class SeStudent implements Student{

    int level;
    int baseAtk;
    int delay;
    int count;

    public SeStudent(int level) {
        this.level = level;
        this.baseAtk = 5;
        this.delay = 6;
        this.count = 0;
    }
/**
*Special ability of Group working
* and slow down the first 5 bugs by 2 steps
 */

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int upgradeCost() {
        return (int)((100)* pow(2, level));
    }

    @Override
    public String toString() {
        return "SeStudent{" +
                "level=" + level +
                ", baseAtk=" + baseAtk +
                ", delay=" + delay +
                ", count=" + count +
                '}';
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
            if (count % delay == 0) {
                ArrayList<Bug> tempArray = new ArrayList<Bug>();
                for (Bug temp : b.getAllBugs()) {
                    tempArray.add(temp);
                }
                if (tempArray.size() >= 5) {
                    System.out.println("Using group work SpecialAbility");
                    tempArray.get(0).slowDown(2);
                    tempArray.get(1).slowDown(2);
                    tempArray.get(2).slowDown(2);
                    tempArray.get(3).slowDown(2);
                    tempArray.get(4).slowDown(2);

                    b.clearbugs();
                    for (Bug temp2 : tempArray) {
                        b.addinbugs(temp2);
                    }
                } else if (tempArray.size() == 4) {
                    tempArray.get(0).slowDown(2);
                    tempArray.get(1).slowDown(2);
                    tempArray.get(2).slowDown(2);
                    tempArray.get(3).slowDown(2);
                } else if (tempArray.size() == 3) {
                    tempArray.get(0).slowDown(2);
                    tempArray.get(1).slowDown(2);
                    tempArray.get(2).slowDown(2);
                } else if (tempArray.size() == 2) {
                    tempArray.get(0).slowDown(2);
                    tempArray.get(1).slowDown(2);
                } else if (tempArray.size() == 1) {
                    tempArray.get(0).slowDown(2);
                }
            } else if (b.getAllBugs().length != 0) {
                firstBug.damage((int) Math.round(baseAtk * pow(level, 1.2)));
            } else {
                System.out.println("No bugs in the building to attack");
            }
            if (firstBug.getCurrentHp() <= 0) {
                points += firstBug.getLevel() * 20;
                b.removeBug(firstBug);
                return points;
            }
        }
        return points;
    }

}
