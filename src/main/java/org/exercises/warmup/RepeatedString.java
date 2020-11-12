package org.exercises.warmup;

import java.util.Scanner;

import static org.exercises.ToolsClass.SCANNER_SKIP_PATTERN;
import static org.exercises.ToolsClass.getFile;

public class RepeatedString {

    private final Scanner scanner = new Scanner(getFile(RepeatedString.class));

    public long execute() {
        String s = scanner.nextLine();
        long n = scanner.nextLong();
        scanner.skip(SCANNER_SKIP_PATTERN);

        return repeatedString(s, n);
    }

    private long repeatedString(String s, long n) {
        long numberOfRepeat = n / s.length();
        int rest = Long.valueOf(n - (s.length() * numberOfRepeat)).intValue();
        long numberOfAInS = s.chars().filter(value -> value == 'a').count();

        return numberOfAInS * numberOfRepeat + s.substring(0, rest).chars().filter(value -> value == 'a').count();
    }
}
