package org.exercises.arrays;

import java.util.HashMap;
import java.util.Map;
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

    private String minimumBribes(int[] reference) {
        //For each person we need to calculate the difference between is place and is theoretical place
        //People with positive difference bribed other people and go forward
        //People with negative difference been bribed and push backward by other people

        //Initialize people map
        Map<Integer, Integer> peoplePlaceDifference = new HashMap<>();
        IntStream.range(1, reference.length + 1).forEach(operand -> peoplePlaceDifference.put(operand, 0));

        //Calculate Difference
        IntStream.range(1, reference.length + 1).forEach(operand -> peoplePlaceDifference.replace(reference[operand - 1], reference[operand - 1] - operand));

        //Among the people who bribed : Is there someone who bribed more than twice ?
        //Among the people who been bribed : How many people with a greater number are before them ?
        int bribeCount = 0;
        for (int i = 1; i < reference.length + 1; i++) {
            if (peoplePlaceDifference.get(i) > 2) {
                return "Too chaotic";
            } else if (peoplePlaceDifference.get(i) < 0) {
                int finalI = i;
                bribeCount += IntStream.range(0, lookingForIndex(i, reference)).map(operand -> reference[operand] > finalI ? 1 : 0).sum();
            }
        }
        return String.valueOf(bribeCount);
    }

    private int lookingForIndex(int wanted, int[] reference) {
        return IntStream.range(0, reference.length).filter(i -> reference[i] == wanted).findFirst().getAsInt();
    }

    //Better optimization
/*    private String minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2) {
                return "Too chaotic";
            }
            for (int j = 0; j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }
        return String.valueOf(bribes);
    }
    */

}
