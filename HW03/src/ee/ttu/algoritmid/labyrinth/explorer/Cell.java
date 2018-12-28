package ee.ttu.algoritmid.labyrinth.explorer;

public class Cell {

    private int x;
    private int y;
    private String cost;

    public Cell(int x, int y, String cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        if (y != cell.y) return false;
        return cost != null ? cost.equals(cell.cost) : cell.cost == null;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
