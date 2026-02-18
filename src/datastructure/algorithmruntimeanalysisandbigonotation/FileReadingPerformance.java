package datastructure.algorithmruntimeanalysisandbigonotation;

import java.io.*;

public class FileReadingPerformance {

    public static void main(String[] args) throws Exception {

        long start, end;

        // FileReader
        start = System.nanoTime();
        BufferedReader br1 = new BufferedReader(new FileReader("sample.txt"));
        while (br1.readLine() != null) {}
        br1.close();
        end = System.nanoTime();
        System.out.println("FileReader Time: " + (end - start));

        // InputStreamReader
        start = System.nanoTime();
        BufferedReader br2 = new BufferedReader(
                new InputStreamReader(new FileInputStream("sample.txt")));
        while (br2.readLine() != null) {}
        br2.close();
        end = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (end - start));
    }
}
