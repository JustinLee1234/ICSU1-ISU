//Main
//Justin Lee and Marian Wong
//Program execution start point

import java.util.Scanner;
import java.io.File;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Main{
  
  public static void main(String[] args) throws Exception{ //initialise and declare all variables
    ///TIME VARIABLES///
    long startTime = 0;
    long endTime = 0;
    long elapsedSeconds;
    long elapsedMinutes;
    ///MAP READER VARIABLES///
    int lineCount = 0;    
    Scanner mapReader;
    int height = 15;
    int width = 15;
    int numMaps = 5;
    int mapNum = 0;
    char[][][] mapArray = new char[numMaps][height][width];
    String line;
    ///GAME LOOP///
    boolean inPlay = true;
    boolean gameOver = false;
    boolean mainMenu = true;
    ///OBJECTS///
    Player player = new Player();
    boolean gameVisible = true;
    TilePanel p = new TilePanel(mapArray[mapNum], width, height, player);
    GameFrame g = new GameFrame(p, gameVisible);
    p.loadImages();
    //print out controls in console
    System.out.println("Controls: \n W -> Up \n A -> Left \n S -> Down \n D -> Right \n Collect 30 pokeballs in the shortest amount of time.\n Watch out for spikes as they will delay your progress");

    //start the game timer
    startTime = System.currentTimeMillis(); 
    while (inPlay){
      //read from the text file specified and get each character for TilePanel to draw the map
      for (int map = 0;  map < numMaps; map++){
        mapReader = new Scanner(new File("assets/maps/map" + (map+1) + ".txt"));
        for(int i = 0; i < height; i++) {
          line = mapReader.next();
          for(int j = 0; j < width; j++){
            mapArray[map][i][j] = line.charAt(j);
          }
        }
        mapReader.close(); //close map reader
      }
      p.checkCollision();//constantly check for collision (inside tilePanel class)
      player.move();//constantly check for movement (inside player class)
      if (p.coinCount == 30){//if win condition is reached, then leave game loop
        inPlay= false;
        gameOver = true; //begin gameOver phase
        endTime = System.currentTimeMillis(); //end the game timer
      }
    }
    if (gameOver){
      g.dispose(); //dispose of the game frame
      gameVisible = false; 
      HomePanel h = new HomePanel(); //create new frame and panel
      HomeFrame home = new HomeFrame(h, true);
      h.loadImages(); //load images
      int seconds = (int)(endTime - startTime)/1000;//calculate how long the player took and display in console
      int minutes = seconds/60;
      int displaySeconds = seconds%60;
      System.out.println("That took " + minutes + " minutes and " + displaySeconds + " seconds");
    }
  } 
}


