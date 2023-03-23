package aa24.Model.Piece;

public abstract class UnjumpingPiece extends Piece {

    public UnjumpingPiece(PieceType pt) {
        super(pt);
    }

    public UnjumpingPiece(PieceType pt, int row, int col) {
        super(pt, row, col);
    }

    @Override
    public boolean isValid(Movement m) {

        /** If the movement is out of bounds we dont
         * analyze anything, we just ignore the movement
         */
        if (outOfBounds(m)) {
            return false;
        }
    
        int newRow = this.row + m.y;
        int newCol = this.col + m.x;

        /** For the queen, we need to check if there's any
         * piece in his way, because she cannot jump
         * pieces.
         */

        /** Moves up and down */
        if (m.x == 0) {
            /** If we encounter a non-empty cell in the way
             * we directly return false. This is faster
             */
            int increment = (newRow < this.row) ? 1 : -1;
            int cmpResult = (newRow < this.row) ? 1 : -1;
            for (int i = newRow; Integer.compare(this.row, i) == cmpResult; i+=increment) {

                /** If the movement is out of bounds 
                 * we continue the loop. Like this
                 * we avoid the ArrayIndexOutOfBounds exception
                 */
                Movement mov = new Movement(m.x, i);
                if (outOfBounds(mov)) {
                    continue;
                }

                /** If the movement is not out of bounds, we can check
                 * if is visited
                */
                if (visited(mov)) {
                    return false;
                }
            }
        } 
        /** Moves sideways */
        else if ( m.y == 0 ) {
            /** If we encounter a non-empty cell in the way
             * we directly return false. This is faster
             */
            int increment = (newCol < this.row) ? 1 : -1;
            int cmpResult = (newCol < this.row) ? 1 : -1;
            for (int i = newCol; Integer.compare(this.col, i) == cmpResult; i+=increment) {

                /** If the movement is out of bounds 
                 * we continue the loop. Like this
                 * we avoid the ArrayIndexOutOfBounds exception
                 */
                Movement mov = new Movement(i, m.y);
                if (outOfBounds(mov)) {
                    continue;
                }

                /** If the movement is not out of bounds, we can check
                 * if is visited
                */
                if (visited(mov)) {
                    return false;
                }
            }
        }
        /** Moves diagonally */
        else {
            /** If we encounter a non-empty cell in the way
             * we directly return false. This is faster
             */
            int increment = (newCol < this.row) ? 1 : -1;
            int cmpResult = (newCol < this.row) ? 1 : -1;
            for (int i = newCol; Integer.compare(this.col, i) == cmpResult; i+=increment) {

                /** If the movement is out of bounds 
                 * we continue the loop. Like this
                 * we avoid the ArrayIndexOutOfBounds exception
                 */
                Movement mov = new Movement(i, i);
                if (outOfBounds(mov)) {
                    continue;
                }

                /** If the movement is not out of bounds, we can check
                 * if is visited
                */
                if (visited(mov)) {
                    return false;
                }
            }
        }

        /** If we did not found any piece in the way of the
         * movement, we just need to check if the cell is
         * visited or outofbounds
         * */
        if (outOfBounds(m)) { 
            return false; 
        }
         
        return !visited(m);
    }
    
}
