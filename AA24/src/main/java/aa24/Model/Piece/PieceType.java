package aa24.Model.Piece;

public enum PieceType {
    KNIGHT {
        @Override
        public String toString() {
            return "./src/images/bkn.png";
        }
    }, 
    QUEEN {
        @Override
        public String toString() {
            return "./src/images/bq.png";
        }
    }, 
    ROOK {
        @Override
        public String toString() {
            return "./src/images/brk.png";
        }
    }
}
