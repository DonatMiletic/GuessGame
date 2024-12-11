package util;

public class NumberUtil {
    public static int genRandNum(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
