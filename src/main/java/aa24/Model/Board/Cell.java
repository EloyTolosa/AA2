package aa24.Model.Board;

import aa24.Model.Piece.Piece;

public class Cell {

    private Piece piece;
    private int order;
    private boolean visited;

    public Cell(Piece piece, int order, boolean visited) {
        this.piece = piece;
        this.order = order;
        this.visited = visited;
    }

    public boolean visited() {
        return visited;
    }
    
}
