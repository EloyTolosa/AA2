/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa24.View;

/**
 *
 * @author toloy
 */

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import aa24.Controller.Comunicable;
import aa24.Model.Piece.Piece;
import aa24.Model.Piece.PieceType;

public class View implements Comunicable {

    /** GUI COMPONENTS */
    private JFrame window;

    private JToolBar toolBar;

    private JPanel panel;

    public static Cell[] BOARD;

    /** PROGRAM VARIABLES */
    public static int DIMENSION = 8;
    public static int AVAILABLE_CELLS = DIMENSION*DIMENSION;

    /** STATIC VARIABLES */
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 1000;

    public static int PANEL_WIDHT = WINDOW_WIDTH;
    public static int PANEL_HEIGHT = (int) ( 0.93 * WINDOW_HEIGHT);

    public static int TOOL_BAR_WIDTH = WINDOW_WIDTH;
    public static int TOOL_BAR_HEIGHT = (int) (0.07 * WINDOW_HEIGHT);

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

        BOARD = new Cell[DIMENSION*DIMENSION];
        for (int i = 0; i < BOARD.length; i++) {
            BOARD[i] = new Cell(i);
            panel.add(BOARD[i]);
        }

        /*************************************** */
        /** ONLY FOR TEST PURPOSES. REMOVE LATER */

        /** ADD KNIGHT INTO BOARD */
        BOARD[3].addPiece(PieceType.KNIGHT);
        /** ADD PIECE INTO PIECES LIST */
/*         PIECES.add(BOARD[3].getPiece());
 */        /*************************************** */

        window.getContentPane().add(panel);

        window.revalidate();
        window.pack();
        
        window.setVisible(true);
        window.setResizable(false);

    }

    @Override
    public void comunicate(Object... data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comunicate'");
    }
    
}

