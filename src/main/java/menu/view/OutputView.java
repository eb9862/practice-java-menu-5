package menu.view;

import java.util.List;
import menu.MenuInfo;

public class OutputView extends View {

    private static final String SERVICE_START = "점심 메뉴 추천을 시작합니다.";

    public static void displayStartMessage() {
        printMessage(SERVICE_START);
        printNewLine();
    }

    public static void displayErrorMessage(String errorMessage) {
        printNewLine();
        printMessage("[ERROR] " + errorMessage);
    }

    public static void displayHeader(List<String> categories) {
        displayDivision();
        displayCategories(categories);
    }

    private static void displayDivision() {
        printMessage("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    private static void displayCategories(List<String> categories) {
        categories.addFirst("카테고리");
        String category = String.join(" | ", categories);
        printMessage("[ " + category + " ]");
        categories.removeFirst();
    }

    public static void displayCoachAndMenu(List<String> coachAndMenu) {
        String recommendResult = String.join(" | ", coachAndMenu);
        printMessage("[ " + recommendResult + " ]");
    }
}
