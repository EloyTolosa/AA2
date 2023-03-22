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
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import aa24.Controller.Comunicable;
import aa24.Controller.Controller;
import aa24.Controller.Action;
import aa24.Model.Model;
import aa24.Model.Board.Board;
import aa24.Model.Piece.PieceType;

public class View implements Comunicable {

    /** GUI COMPONENTS */
    private JFrame window;

    private JToolBar toolBar;

    private JPanel panel;

    private JButton startButton, queenButton, rookButton, knightButton, clearButton;

    public static Cell[] BOARD;

    /** PROGRAM VARIABLES */
    public static int DIMENSION = 6;

    public Controller controller = new Controller(this);

    private PieceType selectedPiece;

    public PieceType getSelectedPiece() {
        return selectedPiece;
    }

    /** STATIC VARIABLES */
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 1000;

    public static int START_X = 0;
    public static int START_Y = 0;

    public static int PANEL_WIDHT = WINDOW_WIDTH;
    public static int PANEL_HEIGHT = (int) ( 0.92 * WINDOW_HEIGHT);

    public static int TOOL_BAR_WIDTH = WINDOW_WIDTH;
    public static int TOOL_BAR_HEIGHT = (int) (0.08 * WINDOW_HEIGHT);

    public static int START_BUTTON_WIDTH = TOOL_BAR_WIDTH / 6;
    public static int START_BUTTON_HEIGHT = TOOL_BAR_HEIGHT;

    public static int PIECE_BUTTON_WIDTH = TOOL_BAR_HEIGHT;
    public static int PIECE_BUTTON_HEIGHT = TOOL_BAR_HEIGHT;

    public View(String title) {

        window = new JFrame(title);
        window.setLayout(null);
        window.setLocationRelativeTo(null);

        window.getContentPane().setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(null);
        panel.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        toolBar = new JToolBar(JToolBar.HORIZONTAL);
        toolBar.setLayout(null);
        toolBar.setBounds(0,0, TOOL_BAR_WIDTH, TOOL_BAR_HEIGHT);
        toolBar.setFloatable(false);

        
        makeToolBarButtons();

        toolBar.add(startButton);
        toolBar.add(knightButton);
        toolBar.add(clearButton);

        panel.add(toolBar);

        BOARD = new Cell[DIMENSION*DIMENSION];
        for (int i = 0; i < BOARD.length; i++) {
            BOARD[i] = new Cell(i, this);
            panel.add(BOARD[i]);
        }

        /*************************************** */
        /** ONLY FOR TEST PURPOSES. REMOVE LATER */

        /** ADD KNIGHT INTO BOARD */
        /* int position = 12;
        BOARD[position].addPiece(PieceType.KNIGHT);
        controller.comunicate(Action.ADD_PIECE, PieceType.KNIGHT, position);

        position = 10;
        BOARD[position].addPiece(PieceType.KNIGHT);
        controller.comunicate(Action.ADD_PIECE, PieceType.KNIGHT, position);

        position = 4;
        BOARD[position].addPiece(PieceType.KNIGHT);
        controller.comunicate(Action.ADD_PIECE, PieceType.KNIGHT, position); */
        /** ADD PIECE INTO PIECES LIST */
/*         PIECES.add(BOARD[3].getPiece());
 */        /*************************************** */

        window.getContentPane().add(panel);

        window.revalidate();
        window.pack();
        
        window.setVisible(true);
        window.setResizable(false);

    }

    public void addPieceToBoard(int row, int col) {
        int position = row*DIMENSION+col;
        BOARD[position].addPiece(this.selectedPiece);
        controller.comunicate(Action.ADD_PIECE, this.selectedPiece, position);

        this.selectedPiece = null;
    }

    public void makeToolBarButtons() {

        clearButton = new JButton("Clear Board");
        clearButton.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        clearButton.setBounds(START_X + PIECE_BUTTON_WIDTH*6, START_Y, PIECE_BUTTON_WIDTH, PIECE_BUTTON_HEIGHT);
        clearButton.addActionListener((al) -> {

            /** Clear board */
            for (int i = 0; i < BOARD.length; i++) {
                BOARD[i].clear();
            }

            /** Clear model pieces list */
            controller.comunicate(Action.CLEAR);

            /** Repaint */
            window.repaint();
        });

        startButton = new JButton("Run");
        startButton.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        startButton.setBounds(START_X + PIECE_BUTTON_WIDTH*0, START_Y, PIECE_BUTTON_WIDTH, PIECE_BUTTON_HEIGHT);
        startButton.addActionListener((al) -> {
            controller.comunicate(Action.START);
        });

        knightButton = new JButton();
        knightButton.setHorizontalAlignment(SwingConstants.CENTER);
        knightButton.setBounds(START_X + PIECE_BUTTON_WIDTH*2, START_Y, PIECE_BUTTON_WIDTH, PIECE_BUTTON_HEIGHT);
        System.out.println(knightButton.getBounds());
    /*         knightButton.setPreferredSize(new Dimension(PIECE_BUTTON_WIDTH, PIECE_BUTTON_HEIGHT));
 */        try {
            knightButton.setIcon(new ImageIcon(ImageIO.read(new File(PieceType.KNIGHT.path())).
                getScaledInstance(
                    (int) (0.8 * knightButton.getWidth()),
                    (int) (0.8 * knightButton.getHeight()),
                    Image.SCALE_DEFAULT)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        knightButton.addActionListener((al) -> {

            this.selectedPiece = PieceType.KNIGHT;

            /* int position = 0;
            controller.comunicate(Action.ADD_PIECE, PieceType.KNIGHT, position); */
        });


    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(this.window, message);
    }

    private void paintSolution(Board board) {

        for (int i = 0; i < BOARD.length; i++) {
            int row = i / DIMENSION;
            int col = i % DIMENSION;
            BOARD[i].setId(board.at(row, col).getId());
            BOARD[i].setOrder(board.at(row, col).getOrder());
            BOARD[i].repaint();
        }

    }

    @Override
    public void comunicate(Object... data) {

        Action action = (Action) data[0];

        switch (action) {
            case ALERT:

                alert(data[1].toString());
                break;

            case PAINT_SOLUTION:

                Board board = (Board) data[1];
                paintSolution(board);

                break;
            
            default:

                break;
        }
        
    }
    
}

