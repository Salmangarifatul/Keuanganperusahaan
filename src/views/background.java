package views;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class background extends JPanel{
    private Image image;
    public background(){
        image = new ImageIcon(getClass().getResource("/images/SAFETY INSURANCE TRANSP (1).png")).getImage();
    }
    @Override
    protected void paintComponent(Graphics graph){
        super.paintComponents(graph);
        Graphics2D gd = (Graphics2D) graph.create();
        gd.drawImage(image,0,0, getWidth(), getHeight(), null);
        gd.dispose();
    }    
}
