package objects;

import main.GamePanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class objectParent {

    public BufferedImage image;
    public BufferedImage imageArr[] = new BufferedImage[12];
    public String name;
    public boolean collision = false;
    public int worldX,worldY;

    public void draw(Graphics2D graphics, GamePanel gamePanel){

        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY){
            graphics.drawImage(image,screenX,screenY,gamePanel.tileSize*5, gamePanel.tileSize*5 ,null);
        }
    }
}
