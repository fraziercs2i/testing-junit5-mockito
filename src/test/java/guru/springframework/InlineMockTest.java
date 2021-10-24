package guru.springframework;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class InlineMockTest {
    @Test
    void TestInlineMock() {

        Map mapMoCK = mock(Map.class);

        assertEquals(mapMoCK.size(), 0);

    }
}
