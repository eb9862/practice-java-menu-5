package menu.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<String> parseNames(String namesInput) {
        String[] coachNames = namesInput.split(",");
        return removeBlank(coachNames);
    }

    public static List<String> parseFoodsCannotEat(String foodsInput) {
        String[] foodsCannotEat = foodsInput.split(",");
        return removeBlank(foodsCannotEat);
    }

    static List<String> removeBlank(String[] elements) {
        List<String> names = new ArrayList<>();
        for (String element : elements) {
            String strippedElement = element.strip();
            names.add(strippedElement);
        }
        return names;
    }
}
