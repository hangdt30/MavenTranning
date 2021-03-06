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
        String[] countries = new String[]{"Vi???t Nam", "Hoa K???", "Th??i Lan", "Nh???t B???n"};
        assertThat(countries).contains("Vi???t Nam");
        assertThat(countries).isNotEmpty();
        assertThat(countries).startsWith("Hoa K???");
        assertThat(countries).contains("Vi???t Nam")
                .isNotEmpty().hasSize(6)
                .containsSequence("Hoa K???")
                .containsOnlyOnce("Th??i Lan")
                .endsWith("Nh???t B???n")
                .doesNotContain("H??n Qu???c");
    }

    @Test
    public void stringMethod() {
        String str = "Ch??? kh??ng mu???n nhi???u bug, nh??ng c?? bug th?? ch??? ph???i fix";
        String strClone = str;
        assertThat(str).isEqualTo(strClone);
        assertThat(str).isNotNull()
                .isNotEmpty()
                .startsWith("kh??ng")
                .endsWith("ph???i")
                .doesNotContain("bug");

    }

    @Test
    public void doubletMethod() {
        double value = 12.0;
        assertThat(value).isEqualTo(12.2, withPrecision(0.3));
        assertThat(value).isCloseTo(15.0, Offset.offset(4d));
        assertThat(value).isBetween(10.0, 15.0);//>=10,<=15
        assertThat(value).isStrictlyBetween(10.0, 15.0);//>10,<15
        assertThat(value).isNotZero();//th???c hi???n ktra v???i ph??p chia c?? m???u kh??c 0
    }

    //Vi???t testcase ????? ki???m tra s??? ??i???n tho???i, s??? ??i???n tho???i b???t ?????u t??? 0, c?? 10 s???, kh??ng c?? ch???
    @Test
    public void checkPhone() {
        String phone = "0987654321";
        assertThat(phone).isNotNull()
                .startsWith("0")
                .hasSize(10)
                .containsOnlyDigits();
    }

    //Vi???t testcase ????? ki???m tra ?????nh d???ng email
    @Test
    public void checkMail() {
        String str = "hang@gmail.com";
        String email = "^[A-Za-z0-9+_.-]+@(.+)$";
        assertThat(str).containsPattern(email);
    }

    //Vi???t test case ki???m tra c??n n???ng c???a ng?????i - kh??ng ???????c null, kh??ng l?? ch??? c??i, kh??c 0, n???m trong kho???ng 0-700
    @Test
    public void checkWeight() {
        double weight = 50;
        assertThat(weight).isNotNull()
                .isNotNegative()
                .isNotNaN()
                .isNotZero();

    }

    //T???o 1 m???ng g???m 5 ph???n t??? l?? CMND c???a kh??ch h??ng. Ki???m tra m???ng v?? c??c ph???n t??? c???a m???ng c?? h???p l??? hay kh??ng?
    //M???ng kh??ng c?? ph???n t??? r???ng, c??c ph???n t??? trong m???ng c?? 9 s??? v?? kh??ng c?? ch???
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
