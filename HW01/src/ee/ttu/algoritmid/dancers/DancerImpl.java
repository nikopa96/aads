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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DancerImpl dancer = (DancerImpl) o;

        if (id != dancer.id) return false;
        if (height != dancer.height) return false;
        return gender == dancer.gender;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "{gender=" + gender +
                ", height=" + height + ", " +
                "id=" + id + "}";
    }
}
