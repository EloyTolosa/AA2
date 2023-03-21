package aa24.Model.Board;

import aa24.Model.Piece.Piece;

public class Cell {

    private Piece piece;

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    private int order;
    private boolean visited;

    public Cell() {
    }

    public Cell(Piece piece, int order, boolean visited) {
        this.piece = piece;
        this.order = order;
        this.visited = visited;
    }

    public int getOrder() {
        return order;
    }

    public void set(Piece p, int order) {
        this.piece = p;
        this.visited = true;
        this.order = order;
    }

    public void empty() {
        this.piece = null;
        this.visited = false;
        this.order = 0;
    }

    public boolean visited() {
        return visited;
    }

    @Override
    public String toString() {
        return "("+piece.toString()+","+this.order+")";
    }
    
}
