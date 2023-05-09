import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CalcTest {
    MainFrame mainFrame;

    @BeforeEach                     // ehhez importalni kellett  ket junit filet settings.jsonban látni
    public void initEach() {
        this.mainFrame = new MainFrame();
    }

    @Test
    public void testCalcBodyIndex() {
        double current = this.mainFrame.calcBodyIndex(100, 1.8);
        double expected = 30.86;
        assertEquals(expected, current, 0.1);
    }

    @Test
    public void testCalcBodyIndexSecond() {
        double current = this.mainFrame.calcBodyIndex(130, 1.7);
        double expected = 44.98;
        assertEquals(expected, current, 0.1);
    }

    @Test
    public void testCalcBodyIndexThird() {
        double current = this.mainFrame.calcBodyIndex(1, 1.7);
        double expected = 0.34;
        assertEquals(expected, current, 0.1);
    }

    @Test
    public void testCalcBodyIndexFourth() {
        double current = this.mainFrame.calcBodyIndex(600, 2.5);
        double expected = 96.0;
        assertEquals(expected, current, 0.1);
    }

}
