package utils;

public class Constants {

    public static class PlayerConstants {

        public static final int UP_WALKING = 0;
        public static final int RIGHT_WALKING = 1;
        public static final int DOWN_WALKING = 2;
        public static final int LEFT_WALKING = 3;

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
}
