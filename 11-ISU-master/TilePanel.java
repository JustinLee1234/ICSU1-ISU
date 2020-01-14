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

public class TilePanel extends JPanel{
  private char map[][];
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
  
   
  public TilePanel(char[][] map, int width, int height, Player p){
    this.map = map;
    this.setPreferredSize(new Dimension(width * this.TILE_SIZE,height*this.TILE_SIZE)); //requests to be a certain size
    this.MAP_WIDTH = width;
    this.MAP_HEIGHT = height;
    this.addKeyListener(p);
    this.setFocusable(true); //
    this.grabFocus();
    this.player = p;
 
  }
  public void setMap(char[][] map){
    this.map = map;
  }

  public static void loadImages(){
    try{ 
      playerSprite = ImageIO.read(new File(".\\assets\\sprites\\playerSprite.png"));
      heartCanister = ImageIO.read(new File(".\\assets\\sprites\\heart.png"));
      emptyCanister = ImageIO.read(new File(".\\assets\\sprites\\heartLost.png"));
    }
    catch(Exception e){
      System.out.println("Image file not found");
    }
  }
  
  public void paintComponent(Graphics g){
    
    super.repaint();
    setDoubleBuffered(true);
    
    for(int i = 0; i<15;i++)  { 
      for(int j = 0; j<15;j++)  {
        if (map[i][j] == 'x')
          g.setColor(Color.DARK_GRAY);
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
        
        tileX = j*TILE_SIZE;
        tileY = i*TILE_SIZE;
        
        g.fillRect(tileX, tileY, 50, 50);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(tileX, tileY, 50, 50);
      } 
    }
    g.drawImage(playerSprite, spawnX +player.getX(), spawnY + player.getY(), null);
    for (int i = 1; i <= 5; i++){
      g.drawImage(heartCanister, 105 - i*15, 5, null);
      
    }
}
}
