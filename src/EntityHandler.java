import java.util.ArrayList;

public class EntityHandler {
    GamePanel gamePanel;
    private static EntityHandler instance;
    Player player;
    ArrayList<Enemy> enemyList;

    KeyHandler keyH;
    private EntityHandler(GamePanel gamePanel) {
        keyH = new KeyHandler();
        player = new Player(gamePanel, keyH);
    }
    public static synchronized EntityHandler getInstance(GamePanel gamePanel){
        if (instance == null) {
            instance = new EntityHandler(gamePanel);
        }
        return instance;
    }


}
