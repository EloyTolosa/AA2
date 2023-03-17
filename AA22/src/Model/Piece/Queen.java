package Model.Piece;

public class Queen extends Piece {

    public Queen() {}

    public Queen(int row, int col) {
        super(row, col);
        this.pt = PieceType.QUEEN;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    
    
}
