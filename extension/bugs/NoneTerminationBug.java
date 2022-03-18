package bugs;

/**
The strongest type of bug
*/
public class NoneTerminationBug extends Bug{
    public NoneTerminationBug(String name, int level, int initialSteps) {
        super(name, 200, 6, level, initialSteps);
    }
}
