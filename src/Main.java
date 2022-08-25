import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        list.add("one"); //тестовый список
        list.add("two");
        list.add("three two");
        list.add("one three");
        list.add("three");
        list.add("two three");
        list.add("three");
        list.add("three one");

        while (true) {
            System.out.println("""
                    1. Добавить
                    2. Показать
                    3. Удалить
                    4. Найти
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
                    deleteListItem(del, list); //удаление покупки метод
                    shopList(list); //список покупок метод
                    separator(); //разделитель метод
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String item = scanner.nextLine(); //сканер
                    System.out.println("Найдено:");
                    searchListItem(item, list); //поиск покупки метод
                    separator(); //разделитель метод
                    break;
                default:
                    System.out.println("Такой операции нет");
                    separator(); //разделитель метод
            }
        }
    }

    static void searchListItem(String item, List<String> list) {
        String queryLower = item.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            String itemLower = list.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + ". " + list.get(i));
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

    static void deleteListItem(String del, List<String> list) {
        if (tryParseInt(del)) {
            int num = Integer.parseInt(del) - 1; //переводим в число
            String removedStrNum = list.remove(num); //удаляем
            removedStr(removedStrNum); //покупка удалена метод
        } else if (!tryParseInt(del)) {
            String removedStrName = list.remove(list.indexOf(del));
            removedStr(removedStrName); //покупка удалена метод
        }
    }

    static void separator() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    static void shopList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1)
                    + ". " + list.get(i));
        }
    }

    static void removedStr(String removedStr) {
        System.out.println("Покупка '"
                + removedStr
                + "' удалена, список покупок:");
    }
}
