package menu;

import static java.util.Collections.frequency;
import static menu.util.Parser.parseFoodsCannotEat;
import static menu.util.Parser.parseNames;
import static menu.util.Validator.validateFoodsCannotEat;
import static menu.util.Validator.validateNamesNumber;
import static menu.view.InputView.readCoachNames;
import static menu.view.InputView.readFoodsCannotEat;
import static menu.view.OutputView.displayCoachAndMenu;
import static menu.view.OutputView.displayErrorMessage;
import static menu.view.OutputView.displayHeader;
import static menu.view.OutputView.displayStartMessage;
import static menu.view.View.printNewLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        displayStartMessage();

        List<Coach> coaches = inputCoachNames();
        printNewLine();
        inputFoodsCannotEat(coaches);

        // 확인용
//        for (Coach coach : coaches) {
//            System.out.println(coach.getName());
//            System.out.println(coach.getFoodsCannotEat());
//        }

        runRecommendService(coaches);
    }

    private static void runRecommendService(List<Coach> coaches) {
        List<String> categories = recommendCategory();
        displayHeader(categories);
        for (Coach coach : coaches) {
            List<String> coachAndMenu = recommendMenu(coach, categories);
            displayCoachAndMenu(coachAndMenu);
        }
    }

    private static List<String> recommendMenu(Coach coach, List<String> categories) {
        List<String> coachAndMenu = new ArrayList<>();
        coachAndMenu.add(coach.getName());
        while (coachAndMenu.size() < 6) {
            for (String category : categories) {
                String menu;
                do {
                    menu = pickMenu(coach, category);
                } while (coachAndMenu.contains(menu));
                coachAndMenu.add(menu);
            }
        }
        return coachAndMenu;
    }

    private static String pickMenu(Coach coach, String category) {
        List<String> menus = changeCategoryToMenus(category);
        while (true) {
            String menu = Randoms.shuffle(menus).getFirst();
            List<String> foodsCannotEat = coach.getFoodsCannotEat();
            if (!foodsCannotEat.contains(menu)) {
                return menu;
            }
        }
    }

    private static List<String> changeCategoryToMenus(String category) {
        for (MenuInfo menuInfo : MenuInfo.values()) {
            if (menuInfo.getCategory().equals(category)) {
                return menuInfo.getMenus();
            }
        }
        return null;
    }

    private static List<String> recommendCategory() {
        List<String> categories = new ArrayList<>();
        while (categories.size() < 5) {
            int categoryNumber = Randoms.pickNumberInRange(1, 5);
            String category = changeNumberToCategory(categoryNumber);
            if (frequency(categories, category) <= 2) {
                categories.add(category);
            }
        }
        return categories;
    }

    private static String changeNumberToCategory(int number) {
        for (MenuInfo menuInfo : MenuInfo.values()) {
            if (menuInfo.getNumber() == number) {
                return menuInfo.getCategory();
            }
        }
        return null;
    }

    private static void inputFoodsCannotEat(List<Coach> coaches) {
        for (Coach coach : coaches) {
            while (true) {
                try {
                    String foodsInput = readFoodsCannotEat(coach.getName());
                    validateFoodsCannotEat(foodsInput);
                    List<String> foodsCannotEat = parseFoodsCannotEat(foodsInput);
                    coach.addFoodsCannotEat(foodsCannotEat);
                    break;
                } catch (IllegalArgumentException e) {
                    displayErrorMessage(e.getMessage());
                }
            }
            printNewLine();
        }
    }

    private static List<Coach> inputCoachNames() {
        while (true) {
            try {
                String namesInput = readCoachNames();
                validateNamesNumber(namesInput);
                List<String> names = parseNames(namesInput);
                List<Coach> coaches = new ArrayList<>();
                for (String name : names) {
                    coaches.add(new Coach(name));
                }
                return coaches;
            } catch(IllegalArgumentException e) {
                displayErrorMessage(e.getMessage());
            }
        }
    }


}



