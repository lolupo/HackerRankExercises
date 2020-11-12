package org.exercises.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static org.exercises.ToolsClass.SCANNER_SKIP_PATTERN;
import static org.exercises.ToolsClass.getFile;

public class TwoDimensionsArray {

    private static final String[] hourGlassesCenterCoordinates = {"1_1", "1_2", "1_3", "1_4",
            "2_1", "2_2", "2_3", "2_4",
            "3_1", "3_2", "3_3", "3_4",
            "4_1", "4_2", "4_3", "4_4"};

    private final Scanner scanner = new Scanner(getFile(TwoDimensionsArray.class));

    public int execute() {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip(SCANNER_SKIP_PATTERN);

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();
        return hourglassSum(arr);
    }

    private int hourglassSum(int[][] arr) {
        List<Integer> sums = new ArrayList<>();
        Arrays.stream(hourGlassesCenterCoordinates).forEachOrdered(s -> calculateHourglassSum(s, sums, arr));
        sums.sort(Integer::compareTo);
        return sums.get(sums.size() - 1);
    }

    private void calculateHourglassSum(String coordinate, List<Integer> sums, int[][] arr) {
        int row = Integer.parseInt(coordinate.split("_")[0]);
        int column = Integer.parseInt(coordinate.split("_")[1]);

        sums.add(IntStream.range(0, 3).map(operand -> arr[row - 1][column - 1 + operand]).sum() +
                arr[row][column] +
                IntStream.range(0, 3).map(operand -> arr[row + 1][column - 1 + operand]).sum());
    }

}
