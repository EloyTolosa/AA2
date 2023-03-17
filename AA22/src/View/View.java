package View;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import Model.Piece.Piece;
import Model.Piece.PieceType;

public class View {

    /** GUI COMPONENTS */
    private JFrame window;

    private JToolBar toolBar;

    private JPanel panel;

    public Cell[] board;
    public ArrayList<Piece> pieces = new ArrayList<Piece>();


    /** PROGRAM VARIABLES */
    public static int DIMENSION = 8;

    /** STATIC VARIABLES */
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 1000;

    public static int PANEL_WIDHT = WINDOW_WIDTH;
    public static int PANEL_HEIGHT = (int) ( 0.92 * WINDOW_HEIGHT);

    public static int TOOL_BAR_WIDTH = WINDOW_WIDTH;
    public static int TOOL_BAR_HEIGHT = (int) (0.08 * WINDOW_HEIGHT);

    public View(String title) {

        window = new JFrame(title);
        window.setLayout(null);
        window.setLocationRelativeTo(null);

        window.getContentPane().setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(null);
        panel.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        toolBar = new JToolBar(JToolBar.HORIZONTAL);
        toolBar.setBounds(0,0, TOOL_BAR_WIDTH, TOOL_BAR_HEIGHT);
        toolBar.setFloatable(false);

        panel.add(toolBar);

        board = new Cell[DIMENSION*DIMENSION];
        for (int i = 0; i < board.length; i++) {
            board[i] = new Cell(i);
            panel.add(board[i]);
        }

        /*************************************** */
        /** ONLY FOR TEST PURPOSES. REMOVE LATER */

        /** ADD KNIGHT INTO BOARD */
        board[3].setPiece(Piece.New(PieceType.KNIGHT));
        /** ADD PIECE INTO PIECES LIST */
        pieces.add(board[3].getPiece());
        /*************************************** */

        window.getContentPane().add(panel);

        window.revalidate();
        window.pack();
        
        window.setVisible(true);
        window.setResizable(false);

    }
    
}
