package aa24.Model.Piece;

public abstract class JumpingPiece extends Piece {

    public JumpingPiece(PieceType pt) {
        super(pt);
        //TODO Auto-generated constructor stub
    }

    public JumpingPiece(PieceType pt, int row, int col) {
        super(pt, row, col);
    }

    @Override
    public boolean isValid(Movement m) {
        if (outOfBounds(m)) {
            return false;
        }

        return !visited(m);
    }
    
}
