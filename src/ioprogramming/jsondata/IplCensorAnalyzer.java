package ioprogramming.jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class IplCensorAnalyzer {

    static class Match {
        public int match_id;
        public String team1;
        public String team2;
        public int score_team1;
        public int score_team2;
        public String winner;
        public String player_of_match;
    }

    static String maskTeam(String team) {

        int index = team.indexOf(" ");

        if (index != -1) {
            return team.substring(0, index) + " ***";
        }

        return "***";
    }

    static String redactPlayer() {
        return "REDACTED";
    }

    public static void processJson() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Match[] matches = mapper.readValue(new File("ipl.json"), Match[].class);

        for (Match m : matches) {

            m.team1 = maskTeam(m.team1);
            m.team2 = maskTeam(m.team2);
            m.player_of_match = redactPlayer();
        }

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("censored_ipl.json"), matches);
    }

    public static void processCsv() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("ipl.csv"));

        PrintWriter pw = new PrintWriter("censored_ipl.csv");

        String line = br.readLine();
        pw.println(line);

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            data[1] = maskTeam(data[1]);
            data[2] = maskTeam(data[2]);
            data[6] = redactPlayer();

            pw.println(String.join(",", data));
        }

        br.close();
        pw.close();
    }

    public static void main(String[] args) throws Exception {

        processJson();
        processCsv();

        System.out.println("Censored files generated.");
    }
}