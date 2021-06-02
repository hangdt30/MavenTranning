import org.assertj.core.data.Offset;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    //AssertNotEquals: compare 2 objects. If the actual result is not the same with the unexpected one, return true
    //AssertEquals: compare 2 objects. If the actual result is the same with the expected one, return true
    @Test
    public void testMethodSub() {
        assertNotEquals(5, calculator.sub(1, 2));
        assertEquals(5, calculator.sub(10, 5));
    }

    @Test
    public void testMethodSum() {
        assertEquals(10, calculator.sum(2, 5));
        assertNotEquals(3, calculator.mul(1, 3));
    }

    @Test
    public void testMethodMul() {
        assertNotEquals(4, calculator.mul(1, 4));
        assertEquals(5, calculator.mul(1, 5));
    }

    @Test
    public void testMethodDiv() {
        assertNotEquals(5, calculator.div(5, 1));
        assertEquals(3, calculator.div(5, 1));
    }

    //assertArrayEquals: compare 2 arrays. If the actual array is the same with the expected one, return true
    String[] str1 = {"Java", "Python", "C#"};
    String[] str2 = {"Python", "C#", "Ruby"};
    String[] str3 = {"Java", "Python", "C#"};
    String str = "This is a string";
    String strNull = null;

    @Test
    public void compareString() {
        assertArrayEquals(str1, str2);
        assertArrayEquals(str1, str3);
    }

    @Test
    public void checkNullString() {
        assertNotNull(str);
        assertNull(strNull);
        assertNotNull(strNull, "This string shouldn't be null");
    }

    @Test
    public void checkTrueFalse() {
        assertTrue(calculator.isPrimeNumber(10));
        assertFalse(calculator.isPrimeNumber(10));
    }

    @Test
    public void checkSame() {
        String expStr = "This is an apple";
        String actualStr = "This is an pineapple";
        assertSame(expStr, actualStr);
        assertNotSame(expStr, actualStr);
    }

    @Test
    @DisplayName("StringArray")
    public void assertString() {
        String[] countries = new String[]{"Việt Nam", "Hoa Kỳ", "Thái Lan", "Nhật Bản"};
        assertThat(countries).contains("Việt Nam");
        assertThat(countries).isNotEmpty();
        assertThat(countries).startsWith("Hoa Kỳ");
        assertThat(countries).contains("Việt Nam")
                .isNotEmpty().hasSize(6)
                .containsSequence("Hoa Kỳ")
                .containsOnlyOnce("Thái Lan")
                .endsWith("Nhật Bản")
                .doesNotContain("Hàn Quốc");
    }

    @Test
    public void stringMethod() {
        String str = "Chị không muốn nhiều bug, nhưng có bug thì chị phải fix";
        String strClone = str;
        assertThat(str).isEqualTo(strClone);
        assertThat(str).isNotNull()
                .isNotEmpty()
                .startsWith("không")
                .endsWith("phải")
                .doesNotContain("bug");

    }

    @Test
    public void doubletMethod() {
        double value = 12.0;
        assertThat(value).isEqualTo(12.2, withPrecision(0.3));
        assertThat(value).isCloseTo(15.0, Offset.offset(4d));
        assertThat(value).isBetween(10.0, 15.0);//>=10,<=15
        assertThat(value).isStrictlyBetween(10.0, 15.0);//>10,<15
        assertThat(value).isNotZero();//thực hiện ktra với phép chia có mẫu khác 0
    }

    //Viết testcase để kiểm tra số điện thoại, số điện thoại bắt đầu từ 0, có 10 số, không có chữ
    @Test
    public void checkPhone() {
        String phone = "0987654321";
        assertThat(phone).isNotNull()
                .startsWith("0")
                .hasSize(10)
                .containsOnlyDigits();
    }

    //Viết testcase để kiểm tra định dạng email
    @Test
    public void checkMail() {
        String str = "hang@gmail.com";
        String email = "^[A-Za-z0-9+_.-]+@(.+)$";
        assertThat(str).containsPattern(email);
    }

    //Viết test case kiểm tra cân nặng của người - không được null, không là chữ cái, khác 0, nằm trong khoảng 0-700
    @Test
    public void checkWeight() {
        double weight = 50;
        assertThat(weight).isNotNull()
                .isNotNegative()
                .isNotNaN()
                .isNotZero();

    }

    //Tạo 1 mảng gồm 5 phần tử là CMND của khách hàng. Kiểm tra mảng và các phần tử của mảng có hợp lệ hay không?
    //Mảng không có phần tử rỗng, các phần tử trong mảng có 9 số và không có chữ
    @Test
    public void checkArrayIdentityNumber() {
        String arr[] = new String[]{"123456789", "123456678", "123456678", "198776543", "123445678"};

        for (int i = 0; i < arr.length; i++) {
            assertThat(arr[i]).isNotEmpty()
                    .isNotNull()
                    .hasSize(9)
                    .containsOnlyDigits();
        }
    }
}
