package org.exercises.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.exercises.ToolsClass.SCANNER_SKIP_PATTERN;
import static org.exercises.ToolsClass.getFile;

public class SalesByMatch {

    private final Scanner scanner = new Scanner(getFile(SalesByMatch.class));

    public long execute() {
        int n = scanner.nextInt();
        scanner.skip(SCANNER_SKIP_PATTERN);
        int[] ar = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip(SCANNER_SKIP_PATTERN);

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        scanner.close();

        return sockMerchant(n, ar);
    }


    private int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        List<int[]> pairs = new ArrayList<>();
        int firstSockIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && ar[firstSockIndex] != ar[i]) {
                pairs.add(Arrays.copyOfRange(ar, firstSockIndex, i));
                firstSockIndex = i;
            } else if (i == ar.length - 1) {
                pairs.add(Arrays.copyOfRange(ar, firstSockIndex, ar.length));
            }
        }
        int numberOfPairs = 0;
        for (int[] same : pairs) {
            numberOfPairs = numberOfPairs + same.length / 2;
        }

        return numberOfPairs;
    }


}
