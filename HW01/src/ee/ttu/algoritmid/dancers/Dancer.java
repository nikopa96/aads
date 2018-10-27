package ee.ttu.algoritmid.dancers;

/**
 * API specification for the objects
 * representing various dancer.
 */
public interface Dancer {
    public enum Gender {
        MALE, FEMALE
    }

    public int getID();
    public Gender getGender();
    public int getHeight();
}
