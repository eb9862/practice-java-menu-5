package menu.util;

import static menu.util.Parser.removeBlank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateNamesNumber(String namesInput) {
        String[] coachNames = namesInput.split(",");
        List<String> names = removeBlank(coachNames);
        if (!isValidNamesNumber(names)) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 입력할 수 있습니다");
        }
        if (hasDuplicatedElements(names)) {
            throw new IllegalArgumentException("코치의 이름이 중복됩니다");
        }
    }

    private static boolean isValidNamesNumber(List<String> names) {
        return 2 <= names.size() && names.size() <= 5;
    }

    public static void validateFoodsCannotEat(String foodsInput) {
        String[] foods = foodsInput.split(",");
        List<String> foodsCannotEat = removeBlank(foods);
        if (!isValidFoodsNumber(foodsCannotEat)) {
            throw new IllegalArgumentException("못 먹는 메뉴의 개수는 최소 0개, 최대 2개까지 입력할 수 있습니다");
        }
        if (hasDuplicatedElements(foodsCannotEat)) {
            throw new IllegalArgumentException("못 먹는 메뉴가 중복됩니다");
        }
    }

    private static boolean isValidFoodsNumber(List<String> foodsCannotEat) {
        return foodsCannotEat.size() <= 2;
    }

    private static boolean hasDuplicatedElements(List<String> elements) {
        Set<String> nonDuplicatedElements = new HashSet<>(elements);
        return nonDuplicatedElements.size() != elements.size();
    }
}
