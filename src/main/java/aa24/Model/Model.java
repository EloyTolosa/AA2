package aa24.Model;

import java.util.ArrayList;

import aa24.Controller.Action;
import aa24.Controller.Comunicable;
import aa24.Controller.Controller;
import aa24.Model.Board.Board;
import aa24.Model.Piece.Movement;
import aa24.Model.Piece.Piece;
import aa24.Model.Piece.PieceType;
import aa24.View.View;

public class Model implements Comunicable, Runnable {

    public static Board BOARD;

    private ArrayList<Piece> pieces = new ArrayList<Piece>();
    private static int AVAILABLE_CELLS = View.DIMENSION*View.DIMENSION;
    private final static int MAX_CELLS = AVAILABLE_CELLS;

    private Controller controller;

    public Model(Controller controller) {
        this.controller = controller;
        BOARD = new Board(View.DIMENSION);
    }

    private void addPiece(PieceType pt, int position) {
        Piece p = Piece.New(pt, position);
        pieces.add(p);
        p.setId(pieces.size());
        BOARD.at(p.row, p.col).set(p, pieces.size());
        AVAILABLE_CELLS--;
    }

    private static void move(Piece p, Movement m) {
        
        /** This is to maintain coherence when more than one
         * piece is in the board
        */
        int previousOrder = MAX_CELLS - AVAILABLE_CELLS;/** BOARD.at(p.row, p.col).getOrder(); */
        p.move(m);
        AVAILABLE_CELLS--;
        BOARD.at(p.row, p.col).set(p, previousOrder+1);

    }

    private void remove(Piece p, Movement m) {

        BOARD.at(p.row, p.col).empty();
        p.undo(m);
        AVAILABLE_CELLS++;
        BOARD.at(p.row, p.col).setPiece(p);

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
     * @return an integer indicating if the board had a solution. If the function returns 1
     * it means that the board had a solution. If the function returns -1, 
     * it means the contrary.
     */
    private int backtrack(int pieceNumber) {

        Piece p = pieces.get(pieceNumber);
        Movement[] movements = p.getMovements();

        /** Check if board has available cells first
         * If not, finish Backtrack
         * Else, check movements
         */
        if ( AVAILABLE_CELLS == 0 ) {
            return 1;
        }

        for (Movement m : movements) {
            
            /** if movement is valid, move the piece and continue with next one */
            if (p.isValid(m)) {
                
                move(p, m);

                /** Check following piece solution.
                 * If the following piece has finished backtracking, this means we
                 * had a correct solution. Otherwise, not.
                 */
                int pn = (pieceNumber+1)%pieces.size();
                int sol = backtrack(pn); // modulo operator to go around the clock

                /** If the following backtrack did not have a good solution, we need to follow with the
                 * next movement.
                 * On the contraty, if the following backtrack did have a good solution, this means that the
                 * backtrack had a good solution.
                 */
                if ( sol == -1 ) {

                    /** We have to remove the last movement if the backtrag did not find any
                     * good solutions and continue */
                    remove(p, m);
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

        Action a = (Action) data[0];
        switch (a) {
            case ADD_PIECE:
                
                PieceType pt = (PieceType) data[1];
                int position = (int) data[2];
                addPiece(pt, position);

                break;

            case CLEAR:

                pieces = new ArrayList<Piece>();
                BOARD = new Board(View.DIMENSION);
                AVAILABLE_CELLS = MAX_CELLS;

                break;
        
            default:
                break;
        }
        
    }

    @Override
    public void run() {

        if (pieces.size() == 0) {
            controller.comunicate(Action.ALERT, "You cannot run before adding a piece first.");
            return;
        }

        int b = backtrack(0);
        if ( b == 1 ) {
            controller.comunicate(Action.PAINT_SOLUTION, BOARD);
        } else {
            controller.comunicate(Action.ALERT, "This board configuration has no solution");
        }

    }
    
}
