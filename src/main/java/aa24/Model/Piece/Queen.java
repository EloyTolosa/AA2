package aa24.Model.Piece;

public class Queen extends Piece {

    public Queen() {
        super();
        setPieceType(PieceType.QUEEN);
    }

    public Queen(int row, int col) {
        super(row, col);
        setPieceType(PieceType.QUEEN);
    }

    @Override
    public Movement[] getMovements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMovements'");
    }
    
}
