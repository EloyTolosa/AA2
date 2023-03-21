package aa24.Model.Piece;

import aa24.Model.Model;
import aa24.View.View;

public abstract class Piece {

    private PieceType pt;
    private int row, col;

    public Piece() {}

    public Piece(int row, int col) { 
        this.row = row;
        this.col = col;
    }

    /**
     * Returns if a movement is valid for a given piece
     * @param m
     * @return
     */
    public boolean isValid(Movement m) {
        int newRow = this.row + m.x;
        int newCol = this.col + m.y;
        return ( newRow < View.DIMENSION - 1 ) &&
            ( newRow > 0) &&
            ( newCol < View.DIMENSION -1 ) &&
            ( newCol > 0) &&
            ( !Model.BOARD.at(newRow, newCol).visited() );
    }

    public void setPieceType(PieceType pt) {
        this.pt = pt;
    }

    public PieceType getPieceType() {
        return this.pt;
    }

    public abstract Movement[] getMovements();

    // Generic move function. It works for all piece types
    public void move(Movement m) {
        this.row = this.row + m.y;
        this.col = this.col + m.x;
    }

    public static Piece New(PieceType pt) {
        switch (pt) {
            case KNIGHT:
                return new Knight();
            case QUEEN:
                return new Queen();
            case ROOK:
                return new Rook();
        }
        return null;
    }
    
}
