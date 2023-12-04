import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Dec2HexTest {

    @Test
    public void testConvertToHex() {
        assertEquals("FF", Dec2Hex.convertToHex(255));
        assertEquals("64", Dec2Hex.convertToHex(100));
        assertEquals("7D2", Dec2Hex.convertToHex(2002));
    }
}
