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
  private int coinX;
  private int coinY;
  private int obstacleX;
  private int obstacleY;
  private static BufferedImage playerSprite;
  private static BufferedImage heartCanister;
  private static BufferedImage emptyCanister;
  private static BufferedImage obstacle;
  private static BufferedImage coin;
  public boolean collidable;

  
  
  
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
  ///***************MAKE INTO 1 METHOD*************///
  public void checkTileCollision(){
    for(int i = 0; i<15;i++)  { 
      for(int j = 0; j<15;j++)  {
        if (map[i][j] == 'x'){
          if (player.getCurrentX() < j+1 && player.getCurrentX()+1 > j && player.getCurrentY()+1 > i && player.getCurrentY() < i+1){
            if (player.getCurrentX() < j+1 && player.getCurrentX() > j){
              player.setX((player.getX()+1));
            }
            else if (player.getCurrentX()+1 < j+1 && player.getCurrentX()+1 > j){
              player.setX(player.getX()-1);
            }
            if (player.getCurrentY() < i+1 && player.getCurrentY() > i){
              player.setY(player.getY()+1);
            }
            else if (player.getCurrentY()+1 < j+i && player.getCurrentY()+1 >i){
              player.setY(player.getY()-1);
            } 
          }
        }
      }
    }
  }
  public void checkGoalCollision(){
    for(int i = 0; i<15;i++)  { 
      for(int j = 0; j<15;j++)  {
        if (map[i][j] == 'g'){
          if (player.getCurrentX() < j+1 && player.getCurrentX()+1 > j && player.getCurrentY()+1 > i && player.getCurrentY() < i+1){
           // System.out.println("goal reached"); //move onto next level
          }
        }
      }
    }
  }
  public void checkObstacleCollision(){
    for(int i = 0; i<15;i++)  { 
      for(int j = 0; j<15;j++)  {
        if (map[i][j] == 'b'){
          if (player.getCurrentX() < j+1 && player.getCurrentX()+1 > j && player.getCurrentY()+1 > i && player.getCurrentY() < i+1){
           player.setX((int)spawnX/50);
           player.setY((int)spawnY/50);
          }
        }
      }
    }
  }
  public void checkCoinCollision(){
    for(int i = 0; i<15;i++)  { 
      for(int j = 0; j<15;j++)  {
        if (map[i][j] == 'c'){
          if (player.getCurrentX() < j+1 && player.getCurrentX()+1 > j && player.getCurrentY()+1 > i && player.getCurrentY() < i+1){
          }
        }
      }
    }
  }
  //***********************************// 
    
  public static void loadImages(){
    try{ 
      playerSprite = ImageIO.read(new File(".\\assets\\sprites\\playerSprite.png")); 
      heartCanister = ImageIO.read(new File(".\\assets\\sprites\\heart.png"));
      emptyCanister = ImageIO.read(new File(".\\assets\\sprites\\heartLost.png"));
      obstacle = ImageIO.read(new File (".\\assets\\sprites\\obstacle.png"));
      coin = ImageIO.read(new File(".\\assets\\sprites\\coin.png"));
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
        else if (map[i][j] == 'z')
          g.setColor(Color.PINK);
        else if (map[i][j] == 'b'){
          g.setColor(Color.CYAN);
          obstacleX = j* TILE_SIZE;
          obstacleY = i * TILE_SIZE;
        }
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
        else if (map[i][j] == 'n')
          g.setColor(Color.RED);
        else if (map[i][j] == 'g')
          g.setColor(Color.RED);
        
        tileX = j*TILE_SIZE;
        tileY = i*TILE_SIZE;

        g.fillRect(tileX, tileY, 50, 50);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(tileX, tileY, 50, 50);
        //g.drawImage(coin, coinX, coinY, null);
        g.drawImage(obstacle, obstacleX, obstacleY, null);
      } 
    }
    player.setCurrentX((spawnX + player.getX())/50.0);
    player.setCurrentY((spawnY + player.getY())/50.0);
    g.drawImage(playerSprite, (int)(player.getCurrentX()*50), (int)(player.getCurrentY()*50), null);
    
    for (int i = 1; i <= player.getLives(); i++){
      g.drawImage(heartCanister, 105 - i*15, 5, null);
    }
  }
}