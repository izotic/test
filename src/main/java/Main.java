import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        boolean checkMoreOne = true;
        boolean checkInt;
        int numberGuests = 0;
        // проверка правильности количества человек
        while (checkMoreOne) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    checkInt = false;
                    numberGuests = scanner.nextInt();
                } catch (Exception e) {
                    checkInt = true;
                    System.out.println("Ошибка! Введите целочисленное значение!\nНа скольких человек необходимо разделить счёт?");
                }
            } while (checkInt);
            if(numberGuests > 1){
                checkMoreOne = false;
                calculator.calculation(numberGuests);
            }else if(numberGuests == 1){
                System.out.println("Это некорректное значение для подсчёта.\n Введите число больше 1!");
            }else if (numberGuests == 0){
                System.out.println("Это некорректное значение для подсчёта.\n Введите число больше 1!");
            }else if (numberGuests < 0){
                System.out.println("Это некорректное значение для подсчёта.\n Введите число больше 1!");
            }
        }
        // вывод всех товаров которые мы добавили
        System.out.println("Добавленные товары:");
        for (int i = 0; i < calculator.nameOrders.size(); i++){
            System.out.println(calculator.nameOrders.get(i));
        }

        System.out.println(String.format("Общая стоимость товаров: %.2f рублей",calculator.total));
        System.out.println("Всего людей добавлено: " + numberGuests);
        calculator.divide(numberGuests);
    }
}
