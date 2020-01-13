import java.awt.Color; // Import the nessasary functions
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TilePanel extends JPanel{
  private char map[][]; //Create the variables
  private final int TILE_SIZE = 50;
  private final int MAP_WIDTH;
  private final int MAP_HEIGHT;
  private int x;
  private int y;
  
  public TilePanel(char[][] map, int width, int height){ 
    this.map = map;
    this.setPreferredSize(new Dimension(width * this.TILE_SIZE,height*this.TILE_SIZE)); //requests to be a certain size
    this.MAP_WIDTH = width;
    this.MAP_HEIGHT = height;
    
  }
  public void setMap(char[][] map){
    this.map = map;
  }
  public void paintComponent(Graphics g){ // paint the blocks in the background layout to the desired color
    super.repaint(); // paint the frame
    setDoubleBuffered(true); 
    for(int i = 0; i<15;i++)  {  // Loop through each row of characters
        for(int j = 0; j<15;j++)  { // Loop through each colomn of characters
          if (map[i][j] == 'x') // if the following coordinates of the map equal the character 'x', colour the block dark grey
            g.setColor(Color.DARK_GRAY);
          else if (map[i][j] == '0') // if the the coordinates of the map equal the character '0', colour the block cyan
            g.setColor(Color.CYAN);
          else if (map[i][j] == 's')// if the the coordinates of the map equal the character 's', colour the block green
            g.setColor(Color.GREEN);
          else if (map[i][j] == 'g')// if the the coordinates of the map equal the character 'g', colour the block red
            g.setColor(Color.RED);
          
          x = j*TILE_SIZE; // The x coordinate of the location of each tile is the # of tiles in a colomn multiplied with the size of one tile
          y = i*TILE_SIZE; // The y coordinate of the location of each tile is the # of tiles in a row multiplied with the size of one tile

          g.fillRect(x, y, 50, 50); // Fill the tile with colour depending on tile size and location
          g.setColor(Color.DARK_GRAY); // Set the colour for a tile border
          g.drawRect(x, y, 50, 50); // The tile border coordinates
        }
    }
  }
}
