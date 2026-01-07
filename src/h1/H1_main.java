package h1;

public class H1_main {
    public static void main(String[] args) {
        Grid g = new Grid(new Cell[] {new Cell(0, 4), new Cell(1, 1, true),new Cell(2, 2, true), new Cell(2, 3), new Cell(3, 1, true), new Cell(3, 2, true)}, 4, 5);
        //g.print();
        g.computeGeneration(2);
        //g.print();
    }
}
