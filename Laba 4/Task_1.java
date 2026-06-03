public class Task_1 {
    public static void main(String[] args) {
        String[] arr = {"10", "20", "текст", "40"};
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            try {
                int number = Integer.parseInt(arr[i]);
                sum += number;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("ПЕРЕХВАТ 1: Элемент \"" + arr[i] + "\" под индексом " + i + " не является числом.");
            }

        }
        try {
            String errorElement = arr[arr.length];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ПЕРЕХВАТ 2: Произошла попытка обращения к элементу за границами массива (индекс " + arr.length + ")!");
        }
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Сумма валидных чисел: " + sum);
            System.out.println("Количество валидных чисел: " + count);
            System.out.println(String.format("Среднее арифметическое: %.4f", average));
        } else {

            System.out.println("Нет корректных данных для расчета.");
        }
    }
}