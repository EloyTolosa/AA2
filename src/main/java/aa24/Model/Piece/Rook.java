package aa24.Model.Piece;

public class Rook extends Piece {

    public Rook() {
        super();
        setPieceType(PieceType.ROOK);
    }

    public Rook(int row, int col) {
        super(row, col);
        setPieceType(PieceType.ROOK);
    }

    @Override
    public Movement[] getMovements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMovements'");
    }
    
}
