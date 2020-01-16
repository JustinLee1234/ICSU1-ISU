import java.util.Scanner; //Import functions
import java.io.File;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Main{ // Main Class
  
  public static void main(String[] args) throws Exception{  
    int lineCount = 0;    // Setting variables
    Scanner mapReader;
    int height = 15;
    int width = 15;
    int numMaps = 5;
    char[][][] mapArray = new char[numMaps][height][width];
    String line;
    boolean inPlay = true;
    Player player = new Player();
    TilePanel p = new TilePanel(mapArray[4], width, height, player);
    TileMap t = new TileMap(p);
    p.loadImages();
    
    while (inPlay){ 
      
      for (int map = 0;  map < numMaps; map++){ //Goes through the different maps/ level layouts
        mapReader = new Scanner(new File("assets/maps/map" + (map+1) + ".txt"));
        for(int i = 0; i < height; i++) {
          line = mapReader.next();
          for(int j = 0; j < width; j++){
            mapArray[map][i][j] = line.charAt(j);
          }
        }
        mapReader.close();
      }
      //if (p.colliding()){
        player.move(); //Moves player
      
    }
  }
}
