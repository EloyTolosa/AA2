package aa24.Model.Piece;

public enum PieceType {
    KNIGHT {
        @Override
        public String path() {
            return "./src/images/bkn.png";
        } 
    }, 
    QUEEN {
        @Override
        public String path() {
            return "./src/images/bq.png";
        }
    }, 
    ROOK {
        @Override
        public String path() {
            return "./src/images/brk.png";
        }
    },
    CRAB {
        @Override
        public String path() {
            return "./src/images/crab.png";
        }
    },
    SHEEP {
        @Override
        public String path() {
            return "./src/images/sheep.png";
        }
    },
    SNAKE {
        @Override
        public String path() {
            return "./src/images/snake.png";
        }
    };

    public abstract String path();

    @Override
    public String toString() {
        return super.toString().substring(0, 1);
    }
}
