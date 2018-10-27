package ee.ttu.algoritmid.dancers;

public class DancerImpl implements Dancer {

    private int id;
    private Gender gender;
    private int height;

    public DancerImpl(int id, Gender gender, int height) {
        this.id = id;
        this.gender = gender;
        this.height = height;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.valueOf(height);
    }
}
