package org.exercises.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.exercises.ToolsClass.SCANNER_SKIP_PATTERN;
import static org.exercises.ToolsClass.getFile;

public class NewYearChaos {

    private final Scanner scanner = new Scanner(getFile(NewYearChaos.class));

    public String execute() {
        int t = scanner.nextInt();
        scanner.skip(SCANNER_SKIP_PATTERN);

        StringJoiner result = new StringJoiner("_");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip(SCANNER_SKIP_PATTERN);

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip(SCANNER_SKIP_PATTERN);

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }
            result.add(minimumBribes(q));
        }
        scanner.close();

        return result.toString();
    }

    private String minimumBribes(int[] reference) {
        List<Integer> swapList = IntStream.range(1, reference.length + 1).boxed().collect(Collectors.toList());
        int totalSwapCount = 0;
        for (int index = reference.length - 1; index >= 1; index--) {
            if (!swapList.get(index).equals(reference[index])) {
                totalSwapCount += swapTwoTimesOrLess(index, reference, swapList);
                if (!swapList.get(index).equals(reference[index])) {
                    return "Too chaotic";
                }
            }
        }
        return String.valueOf(totalSwapCount);
    }

    private int swapTwoTimesOrLess(int index, int[] reference, List<Integer> swapList) {
        int swapCount = 0;
        while (!swapList.get(index).equals(reference[index]) && swapCount < 2) {
            Collections.swap(swapList, index, index - 1 + swapCount);
            swapCount++;
        }
        return swapCount;
    }

}
