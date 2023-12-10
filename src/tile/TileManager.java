package tile;

import main.GamePanel;
import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gamePanel;
    public Tile[] tile;
    public int mapTileNum[][];


    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tile = new Tile[55];
        mapTileNum = new int[gamePanel.maxWorldColumn][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("/worldMap/worldd_map.txt");
    }

    public void getTileImage() {
        try {
            for (int i = 1; i <= 54; i++) {
                String fileName = String.format("/tiles/tile (%d).png", i);
                tile[i] = new Tile();
                tile[i].image = ImageIO.read(getClass().getResourceAsStream(fileName));

                if (i != 2 && i != 3 && i != 24 && i != 25 && i != 26 && i != 27 && i != 28 && i != 29 &&
                        i != 30 && i != 31 && i != 32 && i != 33 && i != 34 && i != 35 && i != 36 && i != 37 &&
                        i != 38 && i != 39 && i != 40 && i != 41 && i != 43 && i != 44 && i != 45 && i != 48 && i != 49 && i != 52) {
                    tile[i].collision = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadMap(String s){
        try {
            InputStream is = getClass().getResourceAsStream(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gamePanel.maxWorldColumn && row < gamePanel.maxWorldRow){

                String line = br.readLine();

                while(col < gamePanel.maxWorldColumn){

                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gamePanel.maxWorldColumn){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(IOException e){
                e.printStackTrace();
            }
    }
    public void draw(Graphics2D graphics){

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gamePanel.maxWorldColumn && worldRow < gamePanel.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;

            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                    worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                    worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                    worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY){
            graphics.drawImage(tile[tileNum].image,screenX,screenY,gamePanel.tileSize, gamePanel.tileSize ,null);
            }
            worldCol++;

            if (worldCol == gamePanel.maxWorldColumn) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
