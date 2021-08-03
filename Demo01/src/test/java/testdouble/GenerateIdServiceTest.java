package testdouble;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GenerateIdServiceTest {
    /*
    Good Unit Testing (FIRST)
        - Fast
        - Isolated/Independent (Not OK)
        - Repeat (Not Ok)
     */


    @Test
    @DisplayName("Demo Stub Random: ID = XYZ7")
    public void case01() {
        GenerateIdService service = new GenerateIdService();
        Random random = new Random(){
            @Override
            public int nextInt(int bound) {
                return 7;
            }
        };
        service.setRandom(random);
        String id = service.get();
        assertEquals("XYZ7", id);
    }

    @Test
    @DisplayName("Demo Spy Random: Called nextInt(int bound)")
    public void case02() {
        GenerateIdService service = new GenerateIdService();
        SpyRandom random = new SpyRandom();
        service.setRandom(random);
        String id = service.get();
        random.verify(1);
    }
}

class SpyRandom extends Random {
    private int count = 0;
    @Override
    public int nextInt(int bound) {
        this.count++;
        return super.nextInt(bound);
    }

    public void verify(int expectedCount) {
        if(expectedCount != count) {
            fail("จำนวนการเรียกใช้งาน method nextInt() ไม่ถูกต้อง");
        }
    }
}