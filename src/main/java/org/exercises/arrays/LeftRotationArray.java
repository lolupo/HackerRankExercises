package org.exercises.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.exercises.ToolsClass.SCANNER_SKIP_PATTERN;
import static org.exercises.ToolsClass.getFile;

public class LeftRotationArray {

    private final Scanner scanner = new Scanner(getFile(LeftRotationArray.class));

    public String execute() {
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip(SCANNER_SKIP_PATTERN);
        scanner.close();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        return Arrays.stream(rotLeft(a, d)).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static int[] rotLeft(int[] a, int d) {
        Deque<Integer> arrayDeque = Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        IntStream.range(0, d).forEachOrdered(value -> arrayDeque.add(arrayDeque.pollFirst()));

        return arrayDeque.stream().mapToInt(Integer::valueOf).toArray();
    }


}
