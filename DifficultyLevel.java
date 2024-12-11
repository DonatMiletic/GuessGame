import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DifficultyLevel {
    EASY(1,50),
    MEDIUM(1,100),
    HARD(1,200);

    private final int minRange;
    private final int maxRange;


    DifficultyLevel(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getMinRange() {
        return minRange;
    }
    public List<Integer> getAllOrdinals(){
        List<Integer> ordinals = new ArrayList<>();
        for (DifficultyLevel level : DifficultyLevel.values()) {
            ordinals.add(level.ordinal());
        }
        return ordinals;
    }
}
