import bugs.Bug;
import building.Building;
import students.Student;
import students.Team;

public class Battle {
    private Team t;
    public Building b;
    private Student s;
    private int a;


    public Battle(Team t, Building b) {
        this.t = t;
        this.b= b;
    }
/**
 * This is the main brain of the game.
 * It gives priority towards adding recruiting a new student
 * If the Points are insufficient to add it will try to Upgrade the existing Students
 */
    public void manageTeam() throws Exception{
        System.out.println("This method makes decisions to upgrade the Team.");
        if(t.getKnowledgePoints() >= t.getNewStudent()){
            t.recruitNewStudent();
        }else if(t.getKnowledgePoints() >= t.upgradeCost()) {
            for (int i = 0; i >= t.getStudents().length; i++) {
                try {
                    t.upgrade(t.getStudents()[a]);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        else {
            System.out.println("(Students)There is insufficient cost to do anything");
        }
    }
/**
 * 0.5sec break
 */
    public void sleep(){
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
        }
    }

    public void step() throws Exception {
        System.out.println("Thinking of stuff to benefit the student team.....");
        sleep();
        manageTeam();

        sleep();
        sleep();
        sleep();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("The bugs are trying to move....");
        sleep();

        for(int i=0; i <= 5;i++){
            b.bugsMove();
        }

        sleep();
        sleep();
        sleep();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("The students are trying to attack the bugs....");
        sleep();
        t.studentAct(b);
        sleep();
        sleep();
        sleep();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(t.getKnowledgePoints());
        System.out.println(t.getNewStudent());
        for (Student s : t.getStudents()) {
            System.out.println(s);
        }
        System.out.println("Health of the Building:");
        System.out.println(b.getConstructionPoints());

        for(Bug bg: b.getAllBugs()){
            System.out.println("Active bug in the Building:  "+bg);
        }

    }
}
