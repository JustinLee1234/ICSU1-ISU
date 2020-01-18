//Main
//Justin Lee and Marian Wong
//program execution start point 

import java.util.Scanner; //import classes
import java.io.File;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Main{
  
  public static void main(String[] args) throws Exception{ 
    int lineCount = 0;    //Create and call variables and classes
    Scanner mapReader;
    int height = 15;
    int width = 15;
    int numMaps = 5;
    boolean outOfBounds = false;
    char[][][] mapArray = new char[numMaps][height][width];
    String line;
    boolean inPlay = true;
    Player player = new Player();
    TilePanel p = new TilePanel(mapArray[0], width, height, player);
    TileMap t = new TileMap(p);
    p.loadImages();
    player.setLives(5);
    
    while (inPlay){ //while in play is true, the game activates
      
      for (int map = 0;  map < numMaps; map++){ //Goes through each map level
        mapReader = new Scanner(new File("assets/maps/map" + (map+1) + ".txt"));
        for(int i = 0; i < height; i++) { 
          line = mapReader.next();
          for(int j = 0; j < width; j++){
            mapArray[map][i][j] = line.charAt(j);
          }
        }
        mapReader.close();
      }
      p.checkTileCollision(); //tracks the player movement and collisions
      p.checkGoalCollision();
      p.checkObstacleCollision();
      p.checkCoinCollision();
      player.move();
    } 
  }
}


