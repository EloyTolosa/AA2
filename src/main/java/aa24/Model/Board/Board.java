package aa24.Model.Board;

public class Board {

    public Cell[] cells;
    public int availableCells;
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cells = new Cell[dimension*dimension];
        for (int i = 0; i < cells.length; i++) {
            this.cells[i] = new Cell();
        }
        this.availableCells = dimension*dimension;
    }

    public Cell at(int row, int col) {
        return cells[row*dimension + col];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s += cells[i*dimension+j];
            }
            s += "\n";
        }
        return s;
    }
    
}
