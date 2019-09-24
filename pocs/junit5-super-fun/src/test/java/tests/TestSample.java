package tests;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TestSample {

    @RepeatedTest(value = 2)
    public void test2x(){
        System.out.println("ok");
    }

    @DisplayName("This is a very important test, I need to becareful here!")
    @Test
    public void simpleTest(){
        String myVar = "1";
        assertSame(myVar, myVar);
    }

    @Test
    @Timeout(value = 2)
    public void shouldBeQuickOrBeDead(){
        System.out.println("almost got me");
        assertSame(1, 1);
    }

}