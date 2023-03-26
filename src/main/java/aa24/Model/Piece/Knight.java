package aa24.Model.Piece;

import aa24.Model.Model;
import aa24.View.View;

public class Knight extends JumpingPiece {


    public Knight(int row, int col) {
        super(PieceType.KNIGHT, row, col);
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
