package building;

import bugs.Bug;
import bugs.ConcurrentModificationBug;
import bugs.NoneTerminationBug;
import bugs.NullPointerBug;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Building{
    int constructionPoints;   // More points More tolerant
    int topFloor;            // CMB 2, NTB 4, NPB 1
    ArrayList<Bug> bugs;   // Collection of bugs attacking
    ArrayList<Bug> bugArrayList;


    public void setConstructionPoints(int constructionPoints) {
        this.constructionPoints = constructionPoints;
    }

    public void setTopFloor(int topFloor) {
        this.topFloor = topFloor;
    }


/**
*Constructor to initialise the building object
*/
    public Building(int topFloor, int constructionPoints) {
        this.constructionPoints = constructionPoints;
        this.topFloor = topFloor;
        bugs = new ArrayList<Bug>();
        bugArrayList = new ArrayList<Bug>();
    }

    public int getConstructionPoints() {
        return constructionPoints;
    }

    public int getTopFloor() {
        return topFloor;
    }

/**
* Orders the bugs according to currentFloor and currentSteps.
 * @return the array of ordered bugs
*/
    public Bug[] getAllBugs() {

        ArrayList<Bug> bugArrayList = new ArrayList<>();   // Dummy ArrayList

        for (Bug bug : bugs) {                              // Adding the main ArrayList into the dummy ArrayList
            if ((bug.getCurrentFloor() > -1) && bug.getCurrentHp() > 0 ){
                bugArrayList.add(bug);
            }
        }
        Collections.sort(bugArrayList, new Comparator<Bug>() {
            @Override
            public int compare(Bug o1, Bug o2) {
                if (o1.getCurrentFloor() > o2.getCurrentFloor()) {
                    return -1;
                } else if (o1.getCurrentFloor() < o2.getCurrentFloor()) {
                    return 1;
                }
                else {
                    if (o1.getCurrentSteps() > o2.getCurrentSteps()) {
                        return 1;
                    } else if (o1.getCurrentSteps() < o2.getCurrentSteps()) {
                        return -1;
                    }

                }
                return 0;
            }
        });

        Bug[] array = new Bug[bugArrayList.size()];         // Array which is returned
        int c = 0;
        for (Bug bug : bugArrayList) {               // Coping the dummy ArrayList into the Array
            array[c] = bug;
            c += 1;
        }
        return array;
    }

/**
* Clears the main "bugs" ArrayList at once (For further programming, not a part of the game)
*/
    public void clearbugs() {

        bugs.clear();
    }

/**
* Adds into the main "bugs" ArrayList (For further programming, not a part of game)
*/
    public void addinbugs(Bug b) {

        bugs.add(b);
    }


/**
*It adds new bugs to the list
*@returns size of the "bugs" ArrayList
*/
    public int addBug(Bug bug) {
        if (bugs.contains(bug)) {
            return -1;
        } else {
            bugs.add(bug);
            return bugs.size();
        }
    }
/**
Removing the bugs from the list
*/
    public void removeBug(Bug bug) {
        bugs.remove(bug);
    }

/**
* Makes all the bugs to move by 1 Step
*/
    public void bugsMove() {
        ArrayList<Bug> bugMove = new ArrayList<Bug>();

        for (Bug bug : bugs) {
                bugMove.add(bug);
            }

        for (Bug b : bugMove) {
            b.move();
            if (b.getCurrentFloor() == topFloor && b instanceof NullPointerBug) {
                constructionPoints -= 1;
                bugs.remove(b);
                if (constructionPoints <= 0 || bugMove.isEmpty()) {
                    System.out.println("Game Over!!!");
                    break;
                }
            }
            if (b.getCurrentFloor() == topFloor && b instanceof ConcurrentModificationBug) {
                constructionPoints -= 2;
                bugs.remove(b);
                if (constructionPoints <= 0 || bugMove.isEmpty()) {
                    System.out.println("Game Over!!!");
                    break;
                }
            }
            if (b.getCurrentFloor() == topFloor && b instanceof NoneTerminationBug) {
                constructionPoints -= 4;
                bugs.remove(b);
                if (constructionPoints <= 0 || bugMove.isEmpty()) {
                    System.out.println("Game Over!!!");
                    break;
                }
            }
        }
    }

}











