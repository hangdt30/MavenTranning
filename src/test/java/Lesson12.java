import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Lesson12 {
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
