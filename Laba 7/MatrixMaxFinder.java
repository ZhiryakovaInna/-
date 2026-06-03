package Laba_7.Task_2;

public class MatrixMaxFinder {

    private static class RowMaxWorker extends Thread {
        private final int[] row;
        private int maxInRow;

        public RowMaxWorker(int[] row) {
            this.row = row;   // Присваиваем переданную строку полю класса
            this.maxInRow = Integer.MIN_VALUE;
        }

        @Override
        public void run() {
            for (int num : row) {
                if (num > maxInRow) {
                    maxInRow = num;
                }
            }
        }

        public int getMaxInRow() {

            return maxInRow;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 18, 5, 12},
                {45, 2, 67, 21},
                {14, 7, 33, 60}
        };

        int rowCount = matrix.length;
        // Создаем массив объектов потоков, по одному на каждую строку
        RowMaxWorker[] workers = new RowMaxWorker[rowCount];
        // Инициализируем объекты потоков, передавая каждой строке свой поток
        for (int i = 0; i < rowCount; i++) {
            workers[i] = new RowMaxWorker(matrix[i]);
        }

        for (int i = 0; i < rowCount; i++) {
            workers[i].start();
        }

        try {
            for (int i = 0; i < rowCount; i++) {
                workers[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        int absoluteMax = Integer.MIN_VALUE;

        for (int i = 0; i < rowCount; i++) {
            int localMax = workers[i].getMaxInRow();
            if (localMax > absoluteMax) {
                absoluteMax = localMax;
            }
        }
        System.out.println("\nНаибольший элемент во всей матрице: " + absoluteMax);
    }
}