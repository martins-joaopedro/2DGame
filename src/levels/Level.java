package levels;

public class Level {
    
    private static int[][] lvlData;

    public Level(int[][] lvlData) {
        this.lvlData = lvlData; 
    }

    public int GetSpriteIndex(int x, int y) {
        return lvlData[y][x];
    }

    public static int[][] getLevelData() {
        return lvlData;
    }
}
