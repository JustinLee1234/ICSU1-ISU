import java.util.Scanner;
import java.io.File;
public class Main{
  
  public static void main(String[] args) throws Exception{ 
    
    int lineCount = 0;
    
    Scanner mapReader;
    int height = 15;
    int width = 15;
    int numMaps = 5;
    char[][][] mapArray = new char[numMaps][height][width];
    String line;
    for (int map = 0;  map < numMaps; map++){
      mapReader = new Scanner(new File("assets/maps/map" + (map+1) + ".txt"));
      for(int i = 0; i < height; i++) {
        line = mapReader.next();
        for(int j = 0; j < width; j++){
          mapArray[map][i][j] = line.charAt(j);
        }
      }
      mapReader.close();
    }
    TilePanel p = new TilePanel(mapArray[4], width, height);
    TileMap t = new TileMap(p);
      
      
    }
  }