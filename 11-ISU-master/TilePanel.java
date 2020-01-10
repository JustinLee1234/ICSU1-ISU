import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TilePanel extends JPanel{
  private char map[][];
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
  public void paintComponent(Graphics g){
    super.repaint();
    setDoubleBuffered(true);
    for(int i = 0; i<15;i++)  { 
        for(int j = 0; j<15;j++)  {
          if (map[i][j] == 'x')
            g.setColor(Color.DARK_GRAY);
          else if (map[i][j] == '0')
            g.setColor(Color.CYAN);
          else if (map[i][j] == 's')
            g.setColor(Color.GREEN);
          else if (map[i][j] == 'g')
            g.setColor(Color.RED);
          
          x = j*TILE_SIZE;
          y = i*TILE_SIZE;

          g.fillRect(x, y, 50, 50);
          g.setColor(Color.DARK_GRAY);
          g.drawRect(x, y, 50, 50);
        }
    }
  }
}
