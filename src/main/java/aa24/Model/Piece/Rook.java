package aa24.Model.Piece;

public class Rook extends Piece {

    public Rook() {}

    public Rook(int row, int col) {
        super(row, col);
        this.pt = PieceType.ROOK;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
