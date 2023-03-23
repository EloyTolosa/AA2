package aa24.Model.Piece;

public class Rook extends UnjumpingPiece {

    public Rook() {
        super(PieceType.ROOK);
    }

    public Rook(int row, int col) {
        super(PieceType.ROOK, row, col);
    }

    @Override
    public Movement[] getMovements() {
        return new Movement[] {
            new Movement(0, -8),
            new Movement(0, -7),
            new Movement(0, -6),
            new Movement(0, -5),
            new Movement(0, -4),
            new Movement(0, -3),
            new Movement(0, -2),
            new Movement(0, -1),

            new Movement(0,8),
            new Movement(0,7),
            new Movement(0,6),
            new Movement(0,5),
            new Movement(0,4),
            new Movement(0,3),
            new Movement(0,2),
            new Movement(0,1),

            new Movement(8,0),
            new Movement(7,0),
            new Movement(6,0),
            new Movement(5,0),
            new Movement(4,0),
            new Movement(3,0),
            new Movement(2,0),
            new Movement(1,0),

            new Movement(-8,0),
            new Movement(-7,0),
            new Movement(-6,0),
            new Movement(-5,0),
            new Movement(-4,0),
            new Movement(-3,0),
            new Movement(-2,0),
            new Movement(-1,0),
        };
    }
}