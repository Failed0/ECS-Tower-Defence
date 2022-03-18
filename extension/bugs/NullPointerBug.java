package bugs;

/**
A type of bug
*/
public class NullPointerBug extends Bug{
    public NullPointerBug(String name, int level, int initialSteps) {
        super(name, 10, 2, level, initialSteps);
    }
}
