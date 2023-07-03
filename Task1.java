import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try {
            int a = getInt("Введите число a:");
            int b = getInt("Введите число b:");
            long c = getStepen(a, b);
            System.out.println(a + " в " + b + " степени = " + c);
            System.out.println(c + " / " + b + " = " + divide(c, b));
        } catch (DivisionByZeroException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static double divide(long a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Деление на 0");
        }
        return (double) a / b;
    }

    public static int getInt(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка: Введено некорректное число. Повторите ввод.");
                scanner.next(); // Очистка буфера сканера
            }
        }
    }

    public static long getStepen(int a, int b){
        for (int i = 1; i < b; i++) {
            a += a;
        }
        return a;
    }

    static class DivisionByZeroException extends Exception {
        public DivisionByZeroException(String message) {
            super(message);
        }
    }
}