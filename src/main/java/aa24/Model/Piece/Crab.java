package aa24.Model.Piece;

public class Crab extends JumpingPiece {

    public Crab(int row, int col) {
        super(PieceType.CRAB, row, col);
    }

    @Override
    public Movement[] getMovements() {
        return new Movement[] {
            new Movement(0, -3),
            new Movement(0, 2),
            new Movement(1,0),
            new Movement(-1,0),
        };
    }

}
