package datastructure.algorithmruntimeanalysisandbigonotation;

public class StringConcatenationPerformance {

    public static void main(String[] args) {

        int n = 100000;

        long start, end;

        // String
        start = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++)
            s += "hello";
        end = System.nanoTime();
        System.out.println("String Time: " + (end - start));

        // StringBuilder
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start));

        // StringBuffer
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++)
            sbf.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start));
    }
}
