package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends View {

    private static final String INPUT_MESSAGE_FOR_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_MESSAGE_FOR_FOODS_CANNOT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static String readFoodsCannotEat(String name) {
        printMessage(name + INPUT_MESSAGE_FOR_FOODS_CANNOT_EAT);
        return Console.readLine();
    }

    public static String readCoachNames() {
        printMessage(INPUT_MESSAGE_FOR_COACH_NAMES);
        return Console.readLine();
    }
}
