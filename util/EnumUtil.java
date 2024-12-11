package util;

import java.util.ArrayList;
import java.util.List;

public class EnumUtil {
    public static List<Integer> getAllOrdinals(Class<? extends Enum<?>> enumClass) {
        List<Integer> ordinals = new ArrayList<>();
        for (Enum<?> constant : enumClass.getEnumConstants()) {
            ordinals.add(constant.ordinal() + 1);
        }
        return ordinals;
    }
}
