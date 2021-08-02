package unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {
    @Test
    @DisplayName("test 1")
    public void case01() {
        Hello hello = new Hello();
        String actualResult = hello.hi("chai");
        assertEquals("Hello, chai", actualResult);
    }

}