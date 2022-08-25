import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        while (true) {
            System.out.println("""
                    1. Добавить
                    2. Показать
                    3. Удалить
                    Выберите операцию или 'end'""");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена");
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String name = scanner.nextLine(); //сканер
                    list.add(name);
                    int size = list.size();
                    System.out.println("Итого в списке покупок: " + size);
                    separator(); //разделитель метод
                    break;
                case 2:
                    System.out.println("Список покупок:");
                    shopList(list); //список покупок метод
                    separator(); //разделитель метод
                    break;
                case 3:
                    System.out.println("Список покупок:");
                    shopList(list); //список покупок метод
                    System.out.println("Какую хотите удалить? Введите номер или название");

                    String del = scanner.nextLine(); //сканер
                    if (tryParseInt(del)) {
                        int num = Integer.parseInt(del) - 1; //переводим в число
                        String removedStrNum = list.remove(num); //удаляем
                        removedStr(removedStrNum); //покупка удалена метод
                    } else if (!tryParseInt(del)) {
                        String removedStrName = list.remove(list.indexOf(del));
                        removedStr(removedStrName); //покупка удалена метод
                    }

                    shopList(list); //список покупок метод
                    separator(); //разделитель метод
                    break;
                default:
                    System.out.println("Такой операции нет");
                    separator(); //разделитель метод
            }
        }
    }

    static boolean tryParseInt(String del) {
        try {
            Integer.parseInt(del);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void separator() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public static void shopList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((list.indexOf(list.get(i)) + 1)
                    + ". " + list.get(i));
        }
    }

    public static void removedStr(String removedStr) {
        System.out.println("Покупка '"
                + removedStr
                + "' удалена, список покупок:");
    }
}
