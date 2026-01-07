package h1;

public class Cell {
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;



    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean aliveNextGen) {
        isAliveNextGen = aliveNextGen;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public boolean getIsAliveNextGen() {
        return isAliveNextGen;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public void setIsAliveNextGen(boolean isAliveNextGen) {
        this.isAliveNextGen = isAliveNextGen;
    }

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexCol = indexCol;
        this.indexRow = indexRow;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        numLivingNeighbors = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                int x1 = indexRow + x;
                int y1 = indexCol + y;
                if (x1 < 0 || x1 >= gridArray.length || y1 < 0 || y1 >= gridArray[0].length) {
                    continue;
                }
                if (gridArray[x1][y1].isAlive()) {
                    numLivingNeighbors++;
                }
            }
        }
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (alive) {
            isAliveNextGen = numLivingNeighbors == 2 || numLivingNeighbors == 3;
        } else {
            isAliveNextGen = numLivingNeighbors == 3;
        }
    }
}