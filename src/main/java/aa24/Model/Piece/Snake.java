package aa24.Model.Piece;

public class Snake extends UnjumpingPiece {

    public Snake(int row, int col) {
        super(PieceType.SNAKE, row, col);
    }

    @Override
    public Movement[] getMovements() {
        return new Movement[] {
            new Movement(0,1),
            new Movement(0,-1),
            new Movement(-1,0),
            new Movement(1,0),

            new Movement(-1,-1),
            new Movement(1,1),
        };
    }
    
}
