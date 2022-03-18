package students;

import building.Building;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Team implements Student {
    private int knowledgePoints;
    AiStudent ai;
    CsStudent cs;
    CyberStudent cyber;
    SeStudent se;
     ArrayList<Student> std;
     private int recruitingCost;

    public Team(int knowledgePoints) {
        this.knowledgePoints = knowledgePoints;
        this.ai = new AiStudent(1);
        this.cs = new CsStudent(1);
        this.cyber = new CyberStudent(1);
        this.se = new SeStudent(1);
        this.recruitingCost =100;
        std = new ArrayList<Student>();
    }

    public int getKnowledgePoints() {
        return knowledgePoints;
    }

/**
 * @return the array of students in the building to protect it
 */
    public Student[] getStudents(){
        std.add(ai);
        std.add(cs);
        std.add(cyber);
        std.add(se);

        Student[] array = new Student[std.size()];
        for(int i=0;i < std.size();i++){
            array[i] =std.get(i);
        }
        return array;
    }
    public void studentAct(Building building){
        for(Student s: getStudents()){
          int acknowledgementsGain = s.defence(building);
           knowledgePoints += acknowledgementsGain;
        }
    }
    public int getNewStudent(){
        return recruitingCost;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int upgradeCost() {
        return (int)((100)* pow(2, getLevel()));
    }

    @Override
    public int defence(Building b) {
        return 0;
    }

    @Override
    public void upgradeLevel() {

    }
/**
 * Adds a new student in the student array.(Just for testing purpose)
 */
    public void addStudents(){
        System.out.println("Select the number and add the student for free:");
        System.out.println("1. AIStudent");
        System.out.println("2. CSStudent");
        System.out.println("3. CyberStudent");
        System.out.println("4. SEStudent");
        Scanner sc = new Scanner(System.in);
        String sc2 = sc.next();
        int sc1 = Integer.valueOf(sc2);
        if(sc1 ==1){
            std.add(ai);
        }else if(sc1 == 2){
            std.add(cs);
        }else if(sc1 == 3){
            std.add(cyber);
        }else if(sc1 == 4){
            std.add(se);
        }
    }
 /**
  * adds new to the student array bases on the probability.
  */
    public void recruitNewStudent() throws Exception {
        if (knowledgePoints >= recruitingCost) {
            try {
                int randomNumber = (int) Math.random();
                if (randomNumber <= 0.25){
                    std.add(this.cyber);
                    knowledgePoints -= recruitingCost;
                    recruitingCost += 10;

                } else if (randomNumber <= 0.50) {
                    std.add(this.se);
                    knowledgePoints -= recruitingCost;
                    recruitingCost += 10;

                } else if (randomNumber <= 0.75) {
                    std.add(this.cs);
                    knowledgePoints -= recruitingCost;
                    recruitingCost += 10;

                } else if (randomNumber <= 1) {
                    std.add(this.ai);
                    knowledgePoints -= recruitingCost;
                    recruitingCost += 10;
                }
            }
            catch (Exception e){
                System.out.println("(Students)The upgrade was not completed due to insufficient knowledge points");
            }
        }
    }

/**
 * Upgrades the student if the knowledge points are sufficient
 */
    public void upgrade(Student s) throws Exception{
        try {
            if (knowledgePoints >= s.upgradeCost()) {
                knowledgePoints -= s.upgradeCost();
                s.upgradeLevel();
            }
        }
        catch (Exception e){
            System.out.println("(Students)Insufficient Knowledge points");
        }
    }
}
