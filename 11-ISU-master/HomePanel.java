import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import javax.imageio.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * [HomePanel.java]
 * Creates and draws all aspects of the end game screen
 */

public class HomePanel extends JPanel{ //class for end screen panel
  private static BufferedImage homeBg; //initialize images
  private static BufferedImage endTxt;
  private static BufferedImage titleTxt;
  private final int TILE_SIZE = 50;
  
  public HomePanel(){
    this.setPreferredSize(new Dimension(15 * this.TILE_SIZE,15*this.TILE_SIZE)); //set dimensions
  }
  
  /**
 * loadImages()
 * using imageIO, reads png files stored in the master folder
 */

  public static void loadImages(){ //load images
    try{ 
      
      homeBg = ImageIO.read(new File(".\\assets\\sprites\\homeScreen.png"));
      endTxt = ImageIO.read(new File(".\\assets\\sprites\\endTxt.png"));
      titleTxt = ImageIO.read(new File(".\\assets\\sprites\\titleTxt.png"));
    }
    catch(Exception e){ //if exception is caught, return message
      System.out.println("Image file not found");
    }
  }
  /**
 * paintComponent()
 * draws the images onto the panel
 */
  
  @Override //overrides any other paint components
  public void paintComponent(Graphics g){ //draws everything on the panel
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    super.repaint();
    setDoubleBuffered(true);
    
    g2d.drawImage(homeBg,0,0, null);
    
    g2d.drawImage(endTxt,-40,250, null);
    g2d.drawImage(titleTxt,0,25, null);
  }
  

  
}
