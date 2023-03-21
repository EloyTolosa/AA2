package aa24.Model.Board;

public class Board {

    public Cell[] cells;
    public int availableCells;
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cells = new Cell[dimension*dimension];
        this.availableCells = dimension*dimension;
    }

    public Cell at(int row, int col) {
        return cells[row*dimension + col];
    }
    
}
