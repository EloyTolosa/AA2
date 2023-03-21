package aa24.Model.Piece;

public class Knight extends Piece {

    public Knight() {
        super();
        setPieceType(PieceType.KNIGHT);
    }

    public Knight(int row, int col) {
        super(row, col);
        setPieceType(PieceType.KNIGHT);
    }

    @Override
    public Movement[] getMovements() {
        return new Movement[] {
            new Movement(-1, -2),
            new Movement(1, -2),
            new Movement(-2, -1),
            new Movement(-2, 1),
            new Movement(2, -1),
            new Movement(2, 1),
            new Movement(1, 2),
            new Movement(-1, 2),
        };
    }
    
}
