package bugs;

/**
 * A type of Bug part of Extension
 */

public class IllegalStateBug extends Bug{
    public IllegalStateBug(String name, int level, int initialSteps) {
        super(name, 35, 7, level, initialSteps);
    }
}
