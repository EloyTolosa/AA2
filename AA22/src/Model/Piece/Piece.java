package Model.Piece;

public abstract class Piece implements Movable {

    public PieceType pt;
    public int row, col;
    public Movement[] movements;

    public Piece() {}

    public Piece(int row, int col) { 
        this.row = row;
        this.col = col;
    }

    public static Piece New(PieceType pt) {
        switch (pt) {
            case KNIGHT:
                return new Knight();
            case QUEEN:
                return new Queen();
            case ROOK:
                return new Rook();
            case default:
                return null;
        }
    }
    
}
