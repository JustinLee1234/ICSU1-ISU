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
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent; 

public class TilePanel extends JPanel{
  ///MAP VARIABLES///
  private char map[][];
  private final int TILE_SIZE = 50;
  private final int MAP_WIDTH;
  private final int MAP_HEIGHT;
  ///TILE VARIABLES///
  private int tileX;
  private int tileY;
  ///PLAYER VARIABLES///
  private Player player;
  private int spawnX;
  private int spawnY;
  ///OBSTACLE VARIABLES///
  private int obstacleX;
  private int obstacleY;
  ///BOOLEANS///
  public boolean home;
  public boolean instructions;
  public boolean levels;
  ///IMAGES///
  private static BufferedImage playerSprite;
  private static BufferedImage heartCanister;
  private static BufferedImage emptyCanister;
  private static BufferedImage obstacle;
  private static BufferedImage coin;
  ///COIN VARIABLES///
  public int coinX;
  public int coinY;
  public int coinCount = 0;
  public boolean validLocation = true;
  public boolean visibleCoin = true;
  public boolean gameVisible = false;
  
  
  public TilePanel(char[][] map, int width, int height, Player p){
    this.map = map;
    this.setPreferredSize(new Dimension(width * this.TILE_SIZE,height*this.TILE_SIZE)); //requests to be a certain size
    this.MAP_WIDTH = width;
    this.MAP_HEIGHT = height;
    this.addKeyListener(p);
    this.setFocusable(true); 
    this.grabFocus();
    this.player = p;
  }
  
  public void setMap(char[][] map){
    this.map = map;
  }
  ///GENERATE COIN CORDINATES///
  public int generateCoinX() {
    int r = (int) (Math.random()*15); //take a random number between 0 and 15 
    coinX = r;
    return coinX;
  }
  public int generateCoinY(){
    int r = (int) (Math.random()*15);
    coinY = r;
    return coinY;
  }
  
  public void checkCollision(){
    for(int i = 0; i<15;i++)  { 
      for(int j = 0; j<15;j++)  {
        if (map[i][j] == 'x'){ //check each character in the map to see if it is an x
          if (player.getCurrentX() < j+1 && player.getCurrentX()+1 > j && player.getCurrentY()+1 > i && player.getCurrentY() < i+1){ //check to see if the players x and y are the same as the obstacles x and y
            //check each condition to see which side the player is colliding on, and move the player the oposite way
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
    for(int i = 0; i<15;i++)  { 
      for(int j = 0; j<15;j++)  {
        if (map[i][j] == 'b'){ //check the collision the same way
          if (player.getCurrentX() < j+1 && player.getCurrentX()+1 > j && player.getCurrentY()+1 > i && player.getCurrentY() < i+1){
            player.setX((int)spawnX/50); //if collision is detected, return to spawn point
            player.setY((int)spawnY/50);
          }
        }
      }
    }  
  }
  
  
  public static void loadImages(){//load images for usage
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
    
    for(int i = 0; i<15;i++)  { //for each element inside the 2D array, find the corresponding character and draw the appropriate tile
      for(int j = 0; j<15;j++)  {
        if (map[i][j] == 'x')
          g.setColor(Color.DARK_GRAY);
        else if (map[i][j] == 'b'){ //if the character is a b, save the cordinates of the tile and assign them to obstacle x and y
          g.setColor(Color.CYAN);
          obstacleX = j* TILE_SIZE;
          obstacleY = i * TILE_SIZE;
        }
        else if (map[i][j] == '0')
          g.setColor(Color.CYAN);
        else if (map[i][j] == 'p')
        {
          g.setColor(Color.GREEN); //similar to obstacle, save these cordinates for the spawnpoints
          spawnX = j*TILE_SIZE;
          spawnY = i*TILE_SIZE;
        }
        else if (map[i][j] == 's')
          g.setColor(Color.GREEN);
        else if (map[i][j] == 'g')
          g.setColor(Color.RED);
        
        tileX = j*TILE_SIZE;
        tileY = i*TILE_SIZE;
        
        g.fillRect(tileX, tileY, 50, 50); //draw the tile at the corresponding cordinate
        g.setColor(Color.DARK_GRAY);
        g.drawRect(tileX, tileY, 50, 50);
        g.drawImage(obstacle, obstacleX, obstacleY, null);
      } 
    }
    player.setCurrentX((spawnX + player.getX())/50.0); //set the current X and Y of the player to the spawnpoint + or - the players displacement
    player.setCurrentY((spawnY + player.getY())/50.0);
    g.drawImage(playerSprite, (int)(player.getCurrentX()*50), (int)(player.getCurrentY()*50), null); //draw the player at currentX andY
    
    
    while (visibleCoin){ //generate coins
      generateCoinX();
      generateCoinY(); 
      validLocation = false; //create a flag to prevent spawning in walls and obstacles
      do{
        validLocation = true;
        for(int i = 0; i<15;i++)  { 
          for(int j = 0; j<15;j++)  {
            if (map[i][j] == 'x' || map[i][j] == 'b'){
              if (coinX == j && coinY == i){ //if coin x and y are ever the same as i or j, it is not a valid location
                validLocation = false;
                generateCoinX(); //generate coinX and Y again and go through the do-while again 
                generateCoinY();
              }
              else //if it never returns false, the exit the loop
                visibleCoin = false;
            }
          }
        }           
      }
      while(!validLocation);
    }
    
    g.drawImage(coin, coinX*50, coinY*50, null);//draw the coin
    if (player.getCurrentX() < coinX+1 && player.getCurrentX()+1 > coinX && player.getCurrentY()+1 > coinY && player.getCurrentY() < coinY+1){
      visibleCoin = true; //check collision with the coin, if they colide then 
      coinCount++;
      System.out.println(coinCount + " pokeball(s) collected"); //print each time a coin is collected
    }
    
  }
}
