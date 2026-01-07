package h1;

public class Grid {
    private Cell[][] gridArray;

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        gridArray = new Cell[gridRows][gridCols];
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j] = new Cell(i, j);
            }
        }
        for (int k = 0; k < cells.length; k++) {
            Cell c = cells[k];
            int i = c.getIndexRow();
            int j = c.getIndexCol();
            if (i < 0 || i >= gridRows || j < 0 || j >= gridCols) {
                continue;
            }
            gridArray[i][j].setAlive(true);
        }
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen() {
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[i].length; j++) {
                Cell c = gridArray[i][j];
                c.setAlive(c.getIsAliveNextGen());
            }
        }
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[i].length; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }

    public void print() {
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[i].length; j++) {
                System.out.print(gridArray[i][j].isAlive() ? '1' : '0');
            }
            System.out.println();
        }
    }


}