package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        currentRow = indexRow;
        currentCol = indexCol;
        this.brett = brett;
    }

    private boolean movesOut() {
        Feld[][] b = brett.getBrett();
        int dim = brett.getDim();

        switch (b[currentRow][currentCol].getDirection()) {
            case 'U':
                return currentRow == 0;
            case 'D':
                return currentRow == dim - 1;
            case 'L':
                return currentCol == 0;
            case 'R':
                return currentCol == dim - 1;
            default:
                return false;
        }
    }

    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld f = brett.getBrett()[currentRow][currentCol];
            if (f.isBoese()) {
                continue;
            }
            if (movesOut()) {
                continue;
            }
            switch (f.getDirection()) {
                case 'U':
                    currentRow--;
                    break;
                case 'D':
                    currentRow++;
                    break;
                case 'L':
                    currentCol--;
                    break;
                case 'R':
                    currentCol++;
                    break;
            }
        }
    }


}