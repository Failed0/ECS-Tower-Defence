package students;

import bugs.Bug;
import building.Building;
import static java.lang.Math.pow;

public class CyberStudent implements Student {

    int level;
    int baseAtk;
    int delay;
    int count;

    public CyberStudent(int level) {
        this.level = level;
        this.baseAtk = 7;
        this.delay = 8;
        this.count = 0;
    }

    /**
     * SettingUp an antivirus software with a change of instance removal of the first bug. (Personally my favorite)
     * probability of instance removal is "level +20", but the level cannot be more than 50.
     * if the bug can't be remover directly then do damage into 2.
     */

    @Override
    public String toString() {
        return "CyberStudent{" +
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
        return (int) ((100) * pow(2, level));
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
        int points  = 0;
        if (b.getAllBugs().length != 0) {
            final Bug firstBug = b.getAllBugs()[0];
            if (count % delay == 0) {
                System.out.println("Setting Up an antivirus with a chance of instantly removing the bug.");
                if (level <= 30) {
                    if (Math.random() <= (level * 0.01) + 0.2 || b.getAllBugs().length != 0) {
                        points += firstBug.getLevel() * 20;
                        b.removeBug(firstBug);
                    } else if (b.getAllBugs().length != 0) {
                        firstBug.damage((int) Math.round(2 * baseAtk * pow(level, 1.2)));
                    } else {
                        System.out.println("No bugs in the building to attack");
                    }
                }
                if (level > 30) {
                    if (Math.random() <= (0.5) || b.getAllBugs().length != 0) {
                        points += firstBug.getLevel() * 20;
                        b.removeBug(firstBug);
                    } else if (b.getAllBugs().length != 0) {
                        firstBug.damage((int) Math.round(2 * baseAtk * pow(level, 1.2)));
                    } else {
                        System.out.println("No bugs in the building to attack");
                    }
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
