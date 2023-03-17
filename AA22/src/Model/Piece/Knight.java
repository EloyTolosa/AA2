package Model.Piece;

public class Knight extends Piece {

    public Knight() {
        super();
        this.pt = PieceType.KNIGHT;
        this.movements = new Movement[] {
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

    public Knight(int row, int col) {
        super(row, col);
        this.pt = PieceType.KNIGHT;
        this.movements = new Movement[] {
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

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
