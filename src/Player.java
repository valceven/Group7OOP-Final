import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    private final BufferedImage[] spriteUp = new BufferedImage[8];
    private final BufferedImage[] spriteLeft = new BufferedImage[8];
    private final BufferedImage[] spriteRight = new BufferedImage[8];

    public Player(GamePanel gamePanel,KeyHandler keyH){
        this.gamePanel = gamePanel;
        this.keyH = keyH;
        screenX = gamePanel.screenWidth/2 - (gamePanel.tileSize/2);
        screenY = gamePanel.screenWidth/2 - (gamePanel.tileSize/2);
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        setX(gamePanel.tileSize*16);
        setY(gamePanel.tileSize*18);
        setSpeed(4);
        setDirection(0);
    }

    public void getPlayerImage(){
        try{
            for(int i = 0; i < 8; i++){
                addSpriteDefault(i, ImageIO.read(getClass().getResourceAsStream("/player/player_down" + i + ".png")));
                spriteUp[i] = ImageIO.read(getClass().getResourceAsStream("/player/player_up" + i + ".png"));
                spriteLeft[i] = ImageIO.read(getClass().getResourceAsStream("/player/player_left" + i + ".png"));
                spriteRight[i] = ImageIO.read(getClass().getResourceAsStream("/player/player_right" + i + ".png"));
            }
        }catch(IOException e){
            e.printStackTrace();
        }


    }
    public void update() {
        if(keyH.up || keyH.down || keyH.left || keyH.right) {
            if (keyH.down) {
                setDirection(0);
            } else if (keyH.up) {
                setDirection(1);
            } else if (keyH.left) {
                setDirection(2);
            } else {
                setDirection(3);
            }

            setSpriteCounter(getSpriteCounter()+7.5);

            if (getSpriteCounter() == 60) {
                setSpriteNum(getSpriteNum()+1);
                if (getSpriteNum() >= 8) {
                    setSpriteNum(1);
                }
                setSpriteCounter(0);
            }
            setCollide(false);
            gamePanel.collision.checkTile(this);

            if (!getCollide()) {
                switch (getDirection()) {
                    case 2:
                        setX(getX()-(getSpeed()));
                        if(keyH.up){
                            setY(getY()+getSpeed());
                        }
                        else if(keyH.down){
                            setY(getY()-getSpeed());
                        }
                        break;
                    case 3:
                        setX(getX()+(getSpeed()));
                        if(keyH.up){
                            setY(getY()+getSpeed());
                        }
                        else if(keyH.down){
                            setY(getY()-getSpeed());
                        }
                        break;
                    case 0:
                        setY(getY()+getSpeed());
                        if(keyH.right){
                            setX(getX()+(getSpeed()));
                        }
                        else if(keyH.left){
                            setX(getX()-(getSpeed()));
                        }
                        break;
                    case 1:
                        setY(getY()-getSpeed());
                        if(keyH.right){
                            setX(getX()+(getSpeed()));
                        }
                        else if(keyH.left){
                            setX(getX()-(getSpeed()));
                        }
                        break;
                }
            }
        }
    }
    public void draw(Graphics2D graphics) {

        BufferedImage image = switch (getDirection()) {
            case 1 -> spriteUp[getSpriteNum()];
            case 2 -> spriteLeft[getSpriteNum()];
            case 3 -> spriteRight[getSpriteNum()];
            default -> getSpriteDefault()[getSpriteNum()];
        };
        graphics.drawImage(image, screenX, screenY, gamePanel.tileSize,gamePanel.tileSize, null);
    }
}