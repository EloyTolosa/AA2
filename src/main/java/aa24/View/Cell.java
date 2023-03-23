/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa24.View;

/**
 *
 * @author toloy
 */

import aa24.Model.Piece.*;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Cell extends JPanel implements MouseListener {

    private static int CELL_WIDTH = Math.floorDiv(View.PANEL_WIDHT, View.DIMENSION);
    private static int CELL_HEIGHT = Math.floorDiv(View.PANEL_HEIGHT,View.DIMENSION);

    private static int CELL_INIT_X = 0;
    private static int CELL_INIT_Y = View.TOOL_BAR_HEIGHT;

    private int row, col;
    private PieceType pt;

    /** Order to keep piece order */
    private int order;
    /** ID to keep track of the piece order between distincs pieces */
    private int id;
    
    public View view;
    
    public Cell(View view) {
        super();

        addMouseListener(this);

        this.view = view;
    }

    public Cell(int number, View view) {
        super();

        this.row = number / View.DIMENSION;
        this.col = number % View.DIMENSION;
        this.setBounds(this.col*CELL_WIDTH + CELL_INIT_X, this.row*CELL_HEIGHT + CELL_INIT_Y, CELL_WIDTH, CELL_HEIGHT);
        
        addMouseListener(this);

        this.view = view;
    }
    
    public void addPiece(PieceType pt) {
        this.pt = pt; 
    }

    public void clear() {
        this.pt = null;
        this.id = 0;
        this.order = 0;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected void paintComponent(Graphics gg) {
        // TODO Auto-generated method stub
        super.paintComponent(gg);

        /** PAINT GRID */
        if ((this.row+this.col) % 2 == 0) {
            this.setBackground(new Color(245,224,174));
        } else {
            this.setBackground(new Color(162,112,70));
        }

        /** PAINT ORDER WITH ID COLOR */
        if (this.id != 0) { /** We do not paint the number where there is a piece */
            
            String orderString = String.valueOf(this.order);
            Graphics2D g2d = (Graphics2D) gg;


            FontRenderContext context = g2d.getFontRenderContext();
            Font font = new Font("TimesRoman", Font.BOLD, (int) (0.6*CELL_HEIGHT));
            g2d.setFont(font);
            TextLayout txt = new TextLayout(orderString, font, context);

            Rectangle2D bounds = txt.getBounds();
            int x = (int) ((getWidth() - (int) bounds.getWidth()) / 2);
            int y = (int) ((getHeight() - (bounds.getHeight() - txt.getDescent())) / 2);
            y += txt.getAscent() - txt.getDescent();

           /*  int x = (this.getWidth() - g2d.getFontMetrics().stringWidth(orderString)) / 2;
            int y = (this.getHeight() - g2d.getFontMetrics().getHeight()) / 2; */

            /** Set color depending on the id */
            Random rand = new Random(this.id);

            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();

            /** Paint the number transparent so we can follow the pieces order */
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));


            g2d.setColor(new Color(r,g,b));
            g2d.drawString(orderString, x, y);
            g2d.setColor(Color.BLACK);
        }

        /** PAINT PIECE IMAGE */
        if (this.pt != null) {
            try {
                Image image;
                image = ImageIO.read(new File(this.pt.path())).
                    getScaledInstance(
                        (int) (0.8*CELL_WIDTH),
                        (int) (0.8*CELL_HEIGHT),
                        Image.SCALE_DEFAULT);

                Graphics2D g2d = (Graphics2D) gg;
                int x = (this.getWidth() - image.getWidth(null)) / 2;
                int y = (this.getHeight() - image.getHeight(null)) / 2;

                if ( this.id != 0 ) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                }

                g2d.drawImage(image, x, y, null);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
        }
        
    }

    private void drawPieceImageTransparent(Graphics g, PieceType pt) throws IOException {

        Image image = ImageIO.read(new File(pt.path())).
            getScaledInstance(
                (int) (0.8*CELL_WIDTH),
                (int) (0.8*CELL_HEIGHT),
                Image.SCALE_DEFAULT);

        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2d.drawImage(image, x, y, null);

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

        if (this.view.getSelectedPiece() == null) {
            return;
        }
        
        addPiece(this.view.getSelectedPiece());

        revalidate();
        repaint();

        view.addPieceToBoard(this.row, this.col);

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

        if (this.view.getSelectedPiece() == null) {
            return;
        } 

        try {
            drawPieceImageTransparent(getGraphics(), this.view.getSelectedPiece());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        revalidate();
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if ( this.view.getSelectedPiece() == null ) {
            return;
        } else {
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {}

    @Override
    public void mouseReleased(MouseEvent arg0) {}

}
