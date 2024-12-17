import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }

    public static String calc(String input) {

        String regex = "([1-9]|10)\\s*([+\\-*/])\\s*([1-9]|10)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    "Нужно было ввести 2 числа из диапазона от 1 до 10" +
                    " и между ними один из 4 знаков арифметической операции +, -, * или /.");
        }

        int num1 = Integer.parseInt(matcher.group(1));
        String operation = matcher.group(2);
        int num2 = Integer.parseInt(matcher.group(3));

        int result = switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };

        return String.valueOf(result);
    }
}

