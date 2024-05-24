package entities.player;

public class PlayerConstants {

    public final static String ATLAS = "dodo.png";
    public final static float xDrawOffset = 0;
    public final static float yDrawOffset = -5;
    public final static int UP_WALKING = 0;
    public final static int RIGHT_WALKING = 1;
    public final static int DOWN_WALKING = 2;
    public final static int LEFT_WALKING = 3;
    public final static int JUMP = 0;

    public static int GetSprintAmount(int player_action) {
        switch (player_action) {
            case UP_WALKING:
                return 3;
            
            case RIGHT_WALKING:
                return 3;
                
            case DOWN_WALKING:
                return 3;
        
            case LEFT_WALKING:
                return 3;
                
            default:
                return 1;
        }
    }
}
