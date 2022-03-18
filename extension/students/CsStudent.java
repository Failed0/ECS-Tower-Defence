package students;

import bugs.Bug;
import building.Building;

import static java.lang.Math.pow;

public class CsStudent implements Student {

    int level;
    int baseAtk;
    int delay;
    int count;

    public CsStudent(int level) {
        this.level = level;
        this.baseAtk = 6;
        this.delay =6;
        this.count =0;
    }
    /**
     *Special Ability Paired Programming
     * 4 times the normal damage
     */

    @Override
    public String toString() {
        return "CsStudent{" +
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
/**
 * Students attacks the bug which is nearest to the top floor.
 * @return the points earned by the students after defeating the bug.
 */
    @Override
    public int defence(Building b) {
//        System.out.println("The knowledge points gained by removing the bug ");
        count += 1;
        int points=0;
        if(b.getAllBugs().length != 0) {
            final Bug firstBug = b.getAllBugs()[0];
            if (count % delay == 0) {           // Checks if it is a special ability
                System.out.println("(Students)Using pair programming SpecialAbility");
                firstBug.damage((int) Math.round(4 * baseAtk * pow(level, 1.2)));
            } else {
                firstBug.damage((int) Math.round(baseAtk * pow(level, 1.2)));
            }
            if (firstBug.getCurrentHp() <= 0) {
                points += firstBug.getLevel() * 20;
                b.removeBug(firstBug);
                return points;
            }
        }
        return points;
    }
/**
 * Increases the level of Student by 1
 */
    @Override
    public void upgradeLevel() {
        level +=1;
    }
}
