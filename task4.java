import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Объявление переменных и перенос введенных со сканера данных в них
        Scanner input = new Scanner(System.in);
        int requiredMoney = input.nextInt();
        int denominationsNumber = input.nextInt();

        // Засовываем номинал купюр в целочисленный массив с помощью for-цикла
        int[] denominations = new int[denominationsNumber];
        for (int i = 0; i < denominationsNumber; i++) {
            denominations[i] = input.nextInt();
        }

        // Сортируем массив в возрастающем порядке, на всякий случай
        Arrays.sort(denominations);

        // Инициализация переменных кражи
        int amount = requiredMoney;
        List<Integer> stolenBanknotes = new ArrayList<>();

        // Итерация по номиналам купюр
        for (int i = denominationsNumber - 1; i >= 0; i--) {
            int denomination = denominations[i];
            while (denomination <= amount) {
                amount -= denomination;
                stolenBanknotes.add(denomination);
            }
        }

        // Проверить, удалось ли украсть нужную сумму
        if (amount == 0) {
            // Печать количества и номинала украденных купюр
            System.out.println(stolenBanknotes.size());
            for (int banknote : stolenBanknotes) {
                System.out.print(banknote + " ");
            }
        } else {
            // Печать -1 если план не выполнен
            System.out.println(-1);
        }
    }
}
