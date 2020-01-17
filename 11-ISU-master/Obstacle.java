import java.awt.Graphics; //import classes
import java.awt.Color;

public class Obstacle extends Entity {

  private String direction;  
  private int obstacleSpawnX;
  private int obstacleSpawnY;
  private int distance;
  
  public Obstacle(String direction, int obstacleSpawnX, int obstacleSpawnY, int distance){ 
    this.direction = direction;
    this.obstacleSpawnX = obstacleSpawnX;
    this.obstacleSpawnY = obstacleSpawnY;
    this.distance = distance;
  }
  
 
}