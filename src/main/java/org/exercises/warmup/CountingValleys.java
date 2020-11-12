package org.exercises.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.exercises.ToolsClass.getFile;

public class CountingValleys {

    private int seaMeter;
    private int numberOfValleys;

    public long execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getFile(CountingValleys.class)));
        bufferedReader.readLine();
        String path = bufferedReader.readLine();
        bufferedReader.close();

        return countingValleys(path);
    }

    private int countingValleys(String path) {
        path.chars().forEach(value -> countValleys(seaMeter, updateSeaMeter(value)));
        return numberOfValleys;
    }

    private int updateSeaMeter(int step) {
        //"85 = U"
        //"68 = D"
        switch (step) {
            case 85:
                seaMeter++;
                break;
            case 68:
                seaMeter--;
                break;
        }
        return seaMeter;
    }

    private void countValleys(int previousSeaMeter, int updatedSeaMeter) {
        if (previousSeaMeter < 0 && updatedSeaMeter == 0) {
            numberOfValleys++;
        }
    }



}
