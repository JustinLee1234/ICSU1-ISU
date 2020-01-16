import java.awt.Color; // import functions
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
import java.awt.Rectangle;

public class TilePanel extends JPanel{ 
  private char map[][]; //Create private and public variables
  private final int TILE_SIZE = 50;
  private final int MAP_WIDTH;
  private final int MAP_HEIGHT;
  private int tileX;
  private int tileY;
  private Player player;
  private int spawnX;
  private int spawnY;
  private static BufferedImage playerSprite;
  private static BufferedImage heartCanister;
  private static BufferedImage emptyCanister;
  private static BufferedImage obstacle;
  public boolean collidable;
  public Rectangle playerRect;
  public Rectangle tileRect;
  
  
  public TilePanel(char[][] map, int width, int height, Player p){ // Constructor creates tile panel 
    this.map = map;
    this.setPreferredSize(new Dimension(width * this.TILE_SIZE,height*this.TILE_SIZE)); //requests to be a certain size
    this.MAP_WIDTH = width;
    this.MAP_HEIGHT = height;
    this.addKeyListener(p);
    this.setFocusable(true); //
    this.grabFocus();
    this.player = p;
    
  }
//public boolean colliding(){
//    for(int i = 0; i<15;i++)  { 
//      for(int j = 0; j<15;j++)  {
//        if(map[i][j] == 'x'){ 
//          if ((j*TILE_SIZE || (player.getY()/50) == i)
//            return true;
//          
//        }
//      }
//    }
//    return false;
//  }

  public void setMap(char[][] map){ //calls the map
    this.map = map;
  }
  public static void loadImages(){ //Load all images and visuals
    try{ 
      playerSprite = ImageIO.read(new File(".\\assets\\sprites\\playerSprite.png"));
      heartCanister = ImageIO.read(new File(".\\assets\\sprites\\heart.png"));
      emptyCanister = ImageIO.read(new File(".\\assets\\sprites\\heartLost.png"));
      obstacle = ImageIO.read(new File (".\\assets\\sprites\\obstacle.png"));
    }
    catch(Exception e){ //If image is not found, let programmer know
      System.out.println("Image file not found");
    }
  }
  
  public void paintComponent(Graphics g){ //Paint everything
    
    super.repaint();
    setDoubleBuffered(true);
    
    for(int i = 0; i<15;i++)  { // Go through the 15 columns 
      for(int j = 0; j<15;j++)  { // Go through the 15 rows in each column
        if (map[i][j] == 'x'){ // Depending on the character in the location identified, colour the tile block the set colour
          //isCollidable(); 
          g.setColor(Color.DARK_GRAY);
        }
        else if (map[i][j] == 'z')
          g.setColor(Color.PINK);
        else if (map[i][j] == '0')
          g.setColor(Color.CYAN);
        else if (map[i][j] == 'p')
        {
          g.setColor(Color.GREEN);
          spawnX = j*TILE_SIZE;
          spawnY = i*TILE_SIZE;
        }
        else if (map[i][j] == 's')
          g.setColor(Color.GREEN);
        else if (map[i][j] == 'g')
          g.setColor(Color.RED);
        
        tileX = j*TILE_SIZE; //The block coordinates
        tileY = i*TILE_SIZE; //The coordinates change as more tiles are created
        
        
        g.fillRect(tileX, tileY, 50, 50); //create the rectangle blocks
        g.setColor(Color.DARK_GRAY);
        g.drawRect(tileX, tileY, 50, 50);
      } 
    }
    g.drawImage(playerSprite, spawnX +player.getX(), spawnY + player.getY(), null); // Draw the image of the player with the following coordinates
    g.drawImage(obstacle,100,100,null);
    
    for (int i = 1; i <= player.getLives(); i++){ // Draw the images for the # lives left with the following coordinates
      g.drawImage(heartCanister, 105 - i*15, 5, null);
      
    }
  }
}
