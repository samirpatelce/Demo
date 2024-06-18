package TestNG;

public class OopsLogicTest {

    public static void main(String[] args) throws InterruptedException {
        //1
        //12
        //123
        //1234
        //12345
        int rows = 5; // Number of rows for the pattern

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();

        //12345
        //1234
        //123
        //12
        //1

        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();

        //1 2 3 4
        //5 6 7
        //8 9
        //10

        int num = 1;
        int max = 4;

        for (int row = max; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
        System.out.println();

        //    1
        //   2 2
        //  3 3 3
        // 4 4 4 4
        int row = 4;

        for (int i = 1; i <= row; i++) {
            for (int j = row; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
