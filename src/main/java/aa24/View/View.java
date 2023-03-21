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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import aa24.Controller.Comunicable;
import aa24.Controller.Controller;
import aa24.Controller.Action;
import aa24.Model.Piece.PieceType;

public class View implements Comunicable {

    /** GUI COMPONENTS */
    private JFrame window;

    private JToolBar toolBar;

    private JPanel panel;

    private JButton startButton;

    public static Cell[] BOARD;

    /** PROGRAM VARIABLES */
    public static int DIMENSION = 5;

    public Controller controller = new Controller(this);

    /** STATIC VARIABLES */
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 1000;

    public static int START_X = 0;
    public static int START_Y = 0;

    public static int PANEL_WIDHT = WINDOW_WIDTH;
    public static int PANEL_HEIGHT = (int) ( 0.93 * WINDOW_HEIGHT);

    public static int TOOL_BAR_WIDTH = WINDOW_WIDTH;
    public static int TOOL_BAR_HEIGHT = (int) (0.07 * WINDOW_HEIGHT);

    public static int START_BUTTON_WIDTH = TOOL_BAR_WIDTH / 6;
    public static int START_BUTTON_HEIGHT = TOOL_BAR_HEIGHT;

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

        startButton = new JButton("Run");
        startButton.setBounds(START_X + START_BUTTON_WIDTH*5, START_Y, START_BUTTON_WIDTH, START_BUTTON_WIDTH);
        startButton.addActionListener((al) -> {
            controller.comunicate(Action.START);
        });

        toolBar.add(startButton);

        panel.add(toolBar);

        BOARD = new Cell[DIMENSION*DIMENSION];
        for (int i = 0; i < BOARD.length; i++) {
            BOARD[i] = new Cell(i);
            panel.add(BOARD[i]);
        }

        /*************************************** */
        /** ONLY FOR TEST PURPOSES. REMOVE LATER */

        /** ADD KNIGHT INTO BOARD */
        int position = 12;
        BOARD[position].addPiece(PieceType.KNIGHT);
        controller.comunicate(Action.ADD_PIECE, PieceType.KNIGHT, position);

        position = 10;
        BOARD[position].addPiece(PieceType.KNIGHT);
        controller.comunicate(Action.ADD_PIECE, PieceType.KNIGHT, position);

        position = 4;
        BOARD[position].addPiece(PieceType.KNIGHT);
        controller.comunicate(Action.ADD_PIECE, PieceType.KNIGHT, position);
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
        
    }
    
}

