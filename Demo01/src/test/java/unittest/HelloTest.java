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

    @Test
    @DisplayName("test database independant")
    public void case02() {
        Hello hello = new Hello();
        hello.userDB = new UserDB(){
            @Override
            public String getNameByID(int id) {
                return "chai";
            }
        };
        String name = hello.workWithDb(1);
        assertEquals("chai", name);
    }

    @Test
    @DisplayName("เกิด exception เมื่อค้นหาผู้ใช้งาน id=2 ไม่เจอ")
    public void case03() {
        Hello hello = new Hello();
        hello.userDB = new UserDB(){
            @Override
            public String getNameByID(int id){
                throw new UserNotFoundException("Id=" + id + " not found");
            }
        };
        // Junit 5 + Exception
        Exception exception = assertThrows(UserNotFoundException.class, () ->
                hello.workWithDb(2));
        assertEquals("Id=2 not found", exception.getMessage());
    }

}