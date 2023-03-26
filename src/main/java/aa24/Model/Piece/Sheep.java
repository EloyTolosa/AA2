package aa24.Model.Piece;

public class Sheep extends JumpingPiece {

    public Sheep(int row, int col) {
        super(PieceType.SHEEP, row, col);
    }

    @Override
    public Movement[] getMovements() {
        return new Movement[] {
            new Movement(-2,-2),
            new Movement(2,-2),
            new Movement(-2,2),
            new Movement(-2,2),

            new Movement(0,-1),
        };
    }
    
}
