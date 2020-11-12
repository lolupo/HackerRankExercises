/*-
 * =====LICENSE-START=====
 * Java 11 Application
 * ------
 * Copyright (C) 2020 Organization Name
 * ------
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * =====LICENSE-END=====
 */
package org.exercises.arrays;

import org.exercises.ToolsClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TwoDimensionsArray {

    private static final String[] hourGlassesCenterCoordinates = {"1_1", "1_2", "1_3", "1_4",
            "2_1", "2_2", "2_3", "2_4",
            "3_1", "3_2", "3_3", "3_4",
            "4_1", "4_2", "4_3", "4_4"};

    private final Scanner scanner = new Scanner(ToolsClass.getFile(TwoDimensionsArray.class));

    public int execute() {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

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
