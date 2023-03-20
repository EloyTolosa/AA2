package aa24.Model.Piece;

public enum PieceType {
    KNIGHT {
        @Override
        public String toString() {
            return "img/bkn.png";
        }
    }, 
    QUEEN {
        @Override
        public String toString() {
            return "img/bq.png";
        }
    }, 
    ROOK {
        @Override
        public String toString() {
            return "img/brk.png";
        }
    }
}
