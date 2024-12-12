package menu.util;

import static menu.util.Parser.removeBlank;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @DisplayName("공백 제거 테스트")
    @Test
    void testForRemoveBlank() {
        String elementsInput = "김치찌개,  숯불갈비, 돼지김치찜";

        List<String> result = removeBlank(elementsInput.split(","));

        assertThat(result).contains("김치찌개", "숯불갈비", "돼지김치찜");
    }
}