import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    //AssertNotEquals: compare 2 objects. If the actual result is not the same with the unexpected one, return true
    //AssertEquals: compare 2 objects. If the actual result is the same with the expected one, return true
    @Test
    public void testMethodSub() {
        assertNotEquals(5, calculator.sub(1,2));
        assertEquals(5, calculator.sub(10,5));
    }
    @Test
    public  void testMethodSum(){
        assertEquals(10,calculator.sum(2,5));
        assertNotEquals(3,calculator.mul(1,3));
    }
    @Test
    public void testMethodMul(){
        assertNotEquals(4,calculator.mul(1,4));
        assertEquals(5,calculator.mul(1,5));
    }
    @Test
    public  void testMethodDiv(){
        assertNotEquals(5, calculator.div(5,1));
        assertEquals(3,calculator.div(5,1));
    }

    //assertArrayEquals: compare 2 arrays. If the actual array is the same with the expected one, return true
    String[] str1 = {"Java","Python","C#"};
    String[] str2= {"Python","C#","Ruby"};
    String[] str3= {"Java","Python","C#"};
    String str = "This is a string";
    String strNull = null;
    @Test
    public  void compareString(){
        assertArrayEquals(str1,str2);
        assertArrayEquals(str1,str3);
    }
    @Test
    public  void checkNullString(){
        assertNotNull(str);
        assertNull(strNull);
        assertNotNull(strNull, "This string shouldn't be null");
    }
    @Test
    public void checkTrueFalse(){
        assertTrue(calculator.isPrimeNumber(10));
        assertFalse(calculator.isPrimeNumber(10));
    }
    @Test
    public void checkSame(){
        String expStr="This is an apple";
        String actualStr="This is an pineapple";
        assertSame(expStr,actualStr);
        assertNotSame(expStr,actualStr);
    }



    


}
