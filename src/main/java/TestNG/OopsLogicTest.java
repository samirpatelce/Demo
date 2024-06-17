package TestNG;

public class OopsLogicTest {

    public static void main(String[] args) throws InterruptedException {
        int rows = 5; // Number of rows for the pattern

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }git st
            System.out.println();
        }
        System.out.println();
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
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
