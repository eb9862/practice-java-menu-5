package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> foodsCannotEat;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        this.foodsCannotEat = new ArrayList<>();
    }

    private void validateName(String name) {
        if (!isValidNameLength(name)) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자까지 입력할 수 있습니다");
        }
    }

    private boolean isValidNameLength(String name) {
        return 2 <= name.length() && name.length() <= 4;
    }

    public void addFoodsCannotEat(List<String> foods) {
        foodsCannotEat.addAll(foods);
    }

    public String getName() {
        return name;
    }

    public List<String> getFoodsCannotEat() {
        return Collections.unmodifiableList(foodsCannotEat);
    }
}
