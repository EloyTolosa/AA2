package aa24.Model;

import java.util.ArrayList;

import aa24.Controller.Comunicable;
import aa24.Controller.Controller;
import aa24.Model.Board.Board;
import aa24.Model.Piece.Movement;
import aa24.Model.Piece.Piece;
import aa24.View.View;

public class Model implements Comunicable, Runnable {

    public static Board BOARD;

    private static ArrayList<Piece> PIECES = new ArrayList<Piece>();

    private Controller controller;

    public Model(Controller controller) {
        this.controller = controller;
        BOARD = new Board(View.DIMENSION);
    }

    private static void move(Piece p, Movement m) {
        
        p.move(m);

    }

    /**
     * Backtrack function executes backtrack generalizing to
     * N pieces.
     * 
     * It first runs backtrack for the starting piece, and
     * aftet that piece moves, it executes backtracking algorithm
     * for the following piece. 
     * If the following piece does not encounter 
     * any possible movement, the given piece tries another movement.
     * If this piece does not encounter any movement, the same will ocurr
     * with the previous one, recursively.
     * If the following piece encounters a solution, Backtracking will
     * be executed for the next piece, recursively.
     * @param start The starting point. 0 means the first piece, 1 the second, 
     * and so on.
     * @return
     */
    private static int Backtrack(int start) {

        Piece p = PIECES.get(start);
        Movement[] movements = p.getMovements();

        /** Check if board has available cells first
         * If not, finish Backtrack
         * Else, check movements
         */
        if ( View.AVAILABLE_CELLS == 0 ) {
            return 1;
        }

        for (Movement m : movements) {
            
            /** if movement is valid, move the piece and continue with next one */
            if (p.isValid(m)) {
                p.move(m);

                /** Check following piece solution.
                 * If the following piece has finished backtracking, this means we
                 * had a correct solution. Otherwise, not.
                 */
                int sol = Backtrack((start+1)%PIECES.size()); // modulo operator to go around the clock

                /** If the following backtrack did not have a good solution, we need to follow with the
                 * next movement.
                 * On the contraty, if the following backtrack did have a good solution, this means that the
                 * backtrack had a good solution.
                 */
                if ( sol == -1 ) {
                    continue;
                } else {
                    return 1;
                }
            } 
            /** if movement is not valid, continue with next movement */
            else {
                continue;
            }

        }

        /** If we reached the end of the movements and we have not
         * find any good movement, this means there is no solution 
         * to this board configuration
         */
        return -1;
    }


    @Override
    public void comunicate(Object... data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comunicate'");
    }

    @Override
    public void run() {

        Backtrack(0);

    }
    
}
