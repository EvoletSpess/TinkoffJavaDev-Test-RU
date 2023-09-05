import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        // Инициализация сканнера и пустых ArrayList
        Scanner input = new Scanner(System.in);
        List<Integer> revolverNumberAndMoneyAmount = convertInput(input.nextLine());
        List<Integer> revolverPrices = convertInput(input.nextLine());

        // Так как число револьверов и кол-во денег на руках поступает одной строкой, вызываю индекс, ответственный за хранение кол-ва денег
        int moneyAmount = revolverNumberAndMoneyAmount.get(1);

        // Сортируем ArrayList цен на револьверы
        Collections.sort(revolverPrices);

        // Вызываем отдельный метод buyRevolver, чтобы понять, какой цены револьвер может купить шериф
        buyRevolver(moneyAmount, revolverPrices);
    }

    private static List<Integer> convertInput(String input) {
        // Данный метод поможет мне в конвертации строкового ввода в целочисленный ArrayList формат в этом и последующем упражнениях
        String[] splitInput = input.split(" ");
        List<Integer> convertedInput = new ArrayList<>();
        for (String s : splitInput) {
            convertedInput.add(Integer.parseInt(s));
        }
        return convertedInput;
    }

    private static void buyRevolver(int moneyAmount, List<Integer> revolverPrices) {
        // Объявление начальной переменной, на которую придётся агрегация
        int maxPrice = 0;

        // Итерируем через ArrayList цен на револьверы с помощью for-each цикла и постоянно обновляем переменную maxPrice
        for (var price : revolverPrices) {
            if (price <= moneyAmount && maxPrice != price) {
                maxPrice = price;
            }
        }

        // Затем следует печать переменной maxPrice
        System.out.println(maxPrice);
    }
}
