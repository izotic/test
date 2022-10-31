import java.util.ArrayList;
import java.util.Scanner;
public class Calculator {
    Scanner scannerOrdersName = new Scanner(System.in);
    int numberGuests;
    ArrayList<String> nameOrders = new ArrayList<>();
    double total = 0;
    boolean checkOrders = true;
    boolean checkOrdersToDouble;
    double dividedCheck;
    double numberRound;
    //Добавление товаров и стоимости
    public void calculation(int numberGuests) {
        this.numberGuests = numberGuests;

        while (checkOrders) {
            System.out.println("Введите название товара:\nДля выхода напишите \"Завершить\"");

            //Временная переменная для проверки
            String b = scannerOrdersName.nextLine();

            if ("Завершить".equalsIgnoreCase(b)) {
                return;
            } else {
                nameOrders.add(b);
                System.out.println("Товар успешно добавлен!");
            }

            //Проверка на тип данных double
            do {
                try {
                    System.out.println("Введите стоимость товара:");
                    Scanner scanner = new Scanner(System.in);

                    //Временная переменная для проверки переменное ниже ноля
                    double i = scanner.nextDouble();
                    checkOrdersToDouble = false;
                    if(i<0){
                        checkOrdersToDouble = true;
                        System.out.println("Ошибка! Стоимость товара не может быть ниже 0!");
                    }else total += i;

                } catch (Exception e) {
                    checkOrdersToDouble = true;
                    System.out.println("Ошибка! Введите числовое значение!");
                }
            } while (checkOrdersToDouble);
        }
    }

    //Вывод информации сколько должен человек
    public void divide(int numberGuests){

        dividedCheck = total/numberGuests;

        //Округляем число до сотых
        numberRound =  Math.ceil(dividedCheck * Math.pow(10,2))/Math.pow(10,2);

        //Берем числа после зяпятой
        String numberAfterPoint = String.valueOf(numberRound).substring(String.valueOf(numberRound).indexOf(".") + 1);

        //Округляем сумму
        int roundAmount = (int)Math.floor(numberRound);
        //Берем предпоследнюю цифру
        String penultimateNum = String.valueOf(roundAmount).substring(String.valueOf(roundAmount).length() - 2, String.valueOf(roundAmount).length() - 1);
        int penultimateNumInt = Integer.parseInt(penultimateNum);

        if(penultimateNumInt==1) {
            System.out.println("Каждый должен заплатить: " + numberRound + " рублей!");
        }
        else {
            switch (roundAmount % 10) {
                case 1:
System.out.println("Каждый должен заплатить: " + numberRound + " рубль!");
break;
case 2:
case 3:
case 4:
System.out.println("Каждый должен заплатить: " + numberRound + " рубля!");
break;
 case 5:
case 6:
case 7:
case 8:
case 9:
case 0:
System.out.println("Каждый должен заплатить: " + numberRound + " рублей!");
break;
}
}
}
}

