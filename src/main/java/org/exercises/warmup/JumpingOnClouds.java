package org.exercises.warmup;

import java.util.Scanner;

import static org.exercises.ToolsClass.SCANNER_SKIP_PATTERN;
import static org.exercises.ToolsClass.getFile;

public class JumpingOnClouds {

    private final Scanner scanner = new Scanner(getFile(JumpingOnClouds.class));

    public long execute() {
        int n = scanner.nextInt();
        scanner.skip(SCANNER_SKIP_PATTERN);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip(SCANNER_SKIP_PATTERN);

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }
        return jumpingOnClouds(c);
    }

    private int jumpingOnClouds(int[] clouds) {
        int path = 0;
        int jumps = 0;
        while (path < clouds.length - 1) {
            if (path + 2 < clouds.length && clouds[path + 2] == 0) {
                path = path + 2;
            } else if (path + 1 < clouds.length) {
                path = path + 1;
            }
            jumps++;
        }
        return jumps;
    }


}
