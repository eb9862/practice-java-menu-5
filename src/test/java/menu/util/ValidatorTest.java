package menu.util;

import static menu.util.Validator.validateFoodsCannotEat;
import static menu.util.Validator.validateNamesNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("코치 이름의 개수에 대한 기능 테스트")
    @Test
    void testNameForNormalFunction() {
        String nameInput = "포비, 그레이스, 이2, 오이, 그리잉";
        assertDoesNotThrow(() -> validateNamesNumber(nameInput));
    }

    @DisplayName("코치 이름의 개수 범위(2~5)를 벗어나면 예외 발생")
    @Test
    void testForValidateNameNumber() {
        String nameInput = "포비, 그레이스, 이2, 오이, 그리잉, 오리";

        assertThatThrownBy(() -> validateNamesNumber(nameInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 메뉴의 개수에 대한 기능 테스트")
    @Test
    void testFoodForNormalFunction() {
        String foodInput = "김치찌개, 가지볶음";

        assertDoesNotThrow(() -> validateFoodsCannotEat(foodInput));
    }

    @DisplayName("못 먹는 메뉴의 개수 범위(0~2)를 벗어나면 예외 발생")
    @Test
    void testForValidateFood() {
        String foodInput = "김치찌개, 가지볶음, 피클";

        assertThatThrownBy(() -> validateFoodsCannotEat(foodInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치 이름의 중복에 대한 기능 테스트")
    @Test
    void testDuplicatedForNormalFunction() {
        String nameInput = "포비, 그레이스, 이2";
        assertDoesNotThrow(() -> validateNamesNumber(nameInput));
    }

    @DisplayName("코치 이름의 중복되면 예외 발생")
    @Test
    void testForValidateNameDuplicated() {
        String nameInput = "포비, 그레이스, 이2, 오이, 포비";

        assertThatThrownBy(() -> validateNamesNumber(nameInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}