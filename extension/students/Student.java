package students;

import building.Building;

public interface Student {

    public int getLevel();          // It will return the level of the student
    public int upgradeCost();      // Points to upgrade the student to next level
    int defence(Building b);      //the knowledge points gained by removing the bug
    public void upgradeLevel();  // Upgrades the students +1

    }

