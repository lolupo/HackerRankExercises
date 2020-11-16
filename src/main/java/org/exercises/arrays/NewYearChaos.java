package org.exercises.arrays;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import static org.exercises.ToolsClass.SCANNER_SKIP_PATTERN;
import static org.exercises.ToolsClass.getFile;

public class NewYearChaos {

    private final Scanner scanner = new Scanner(getFile(NewYearChaos.class));

    public String execute() {
        int t = scanner.nextInt();
        scanner.skip(SCANNER_SKIP_PATTERN);

        StringJoiner result = new StringJoiner(System.lineSeparator());

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

    private String minimumBribes(int[] queue) {
        //For each person we need to calculate the difference between is place and is theoretical place
        //People with positive difference bribed other people and go forward
        //People with negative difference been bribed and push backward by other people
        //Because a person can only bribe two times he can only go two places forward
        //So for a person that have been bribed the number of people that bribe him is equal to the number of people with a greater number in the two places above him
        //Sum this number give us the total number of bribes
        int bribes = 0;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] - (i + 1) > 2) {
                return "Too chaotic";
            }
            final int finalI = i;
            bribes += IntStream.range(Math.max(0, queue[finalI] - 2), finalI).map(operand -> queue[operand] > queue[finalI] ? 1 : 0).sum();
        }
        return String.valueOf(bribes);
    }
}
