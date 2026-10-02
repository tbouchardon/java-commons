package fr.ksuto.commons.awt;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

@EqualsAndHashCode(callSuper = true)
public class Painter extends JFrame {
    
    private static final Dimension  dim_D         = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    private static final int        SCREEN_HEIGHT = (int) dim_D.getHeight();
    private static final int        SCREEN_WIDTH  = (int) dim_D.getWidth();
    private              Rectangle  zone          = new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    private              boolean    hasBorders    = true;
    private              WhiteBoard whiteBoard;
    private              String     title         = "";
    
    public Painter(boolean hasBorders) {
        
        this.hasBorders = hasBorders;
        init(zone);
    }
    
    public Painter(Rectangle zone, String title, boolean hasBorders) {
        
        this.hasBorders = hasBorders;
        this.title = title;
        init(zone);
    }
    
    public Painter(String title) {
        
        this.title = title;
        init(zone);
    }
    
    public void repaintWhiteBoard() {
        
        whiteBoard.repaint();
    }
    
    private void init(Rectangle zone) throws HeadlessException {
        
        this.zone = zone;
        
        setAlwaysOnTop(true);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        whiteBoard = new WhiteBoard();
        add(whiteBoard);
        pack();
        setVisible(true);
    }
    
    public Graphics getWhiteBoardGraphics() {
        
        return whiteBoard.getImage().getGraphics();
    }
    
    @Data
    @EqualsAndHashCode(callSuper = true)
    public class WhiteBoard extends JPanel {
        
        BufferedImage image = new BufferedImage(zone.width, zone.height, BufferedImage.TYPE_INT_ARGB);
        
        public WhiteBoard() {
            
            setOpaque(false);
        }
        
        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            Graphics2D g2d = (Graphics2D) g.create();
            //            g2d.drawRect(0, 0, 250, getHeight() - 1);
            
            g2d.setColor(Color.MAGENTA);
            g2d.setStroke(new BasicStroke(4f));
            if (hasBorders) {g2d.drawRect(zone.x, zone.y, zone.width, zone.height);}
            
            g2d.drawString(title,
                           zone.x + 5,
                           zone.y - 20 < 0 ? zone.y + 15 : zone.y - 10);
            
            g2d.drawImage(image, 0, 0, this);
            
            g2d.dispose();
        }
        
        @Override
        public Dimension getPreferredSize() {
            
            return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        }
        
        public void clear() {
            
            dispose();
        }
    }
}
