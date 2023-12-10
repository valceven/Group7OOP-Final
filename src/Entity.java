import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    private int x;
    private int y;
    private int speed;
    private int direction = 0;
    /// d, u, l, r
    private int spriteNum = 0;
    private double spriteCounter = 0;
    private boolean collide = false;
    private final BufferedImage[] spriteDefault = new BufferedImage[8];
    private final Rectangle solidArea = new Rectangle(8,16,32,32);
    public Entity() {
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public BufferedImage[] getSpriteDefault() {
        return spriteDefault;
    }

    public void addSpriteDefault(int i, BufferedImage img) {
        spriteDefault[i] = img;
    }

    public double getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(double spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public boolean getCollide() {
        return collide;
    }
    public void setCollide(boolean collide) {
        this.collide = collide;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }
}
