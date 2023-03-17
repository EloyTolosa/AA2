package View;

import Model.Piece.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Cell extends JPanel {

    private static int CELL_WIDTH = Math.floorDiv(View.PANEL_WIDHT, View.DIMENSION);
    private static int CELL_HEIGHT = Math.floorDiv(View.PANEL_HEIGHT,View.DIMENSION);

    private static int CELL_INIT_X = 0;
    private static int CELL_INIT_Y = View.TOOL_BAR_HEIGHT;

    private Piece piece;
    private int row, col;
    private int order;
    
    public Cell() {
        super();
    }

    public Cell(int number) {
        super();
        this.order = 0;

        this.row = number / View.DIMENSION;
        this.col = number % View.DIMENSION;
        this.setBounds(this.col*CELL_WIDTH + CELL_INIT_X, this.row*CELL_HEIGHT + CELL_INIT_Y, CELL_WIDTH, CELL_HEIGHT);
    }

    public void setPiece(Piece p) { this.piece = p; }
    public Piece getPiece() { return this.piece; }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        /** PAINT GRID */
        if ((this.row+this.col) % 2 == 0) {
            this.setBackground(new Color(245,224,174));
        } else {
            this.setBackground(new Color(162,112,70));
        }

        /** PAINT PIECE IMAGE */
        if (piece != null) {
            try {
                Image image;
                image = ImageIO.read(new File(this.piece.pt.toString())).
                    getScaledInstance(
                        (int) (0.8*CELL_WIDTH),
                        (int) (0.8*CELL_HEIGHT),
                        Image.SCALE_DEFAULT);

                Graphics2D g2d = (Graphics2D) g;
                int x = (this.getWidth() - image.getWidth(null)) / 2;
                int y = (this.getHeight() - image.getHeight(null)) / 2;
                g2d.drawImage(image, x, y, null);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
        }
        
    }

}
