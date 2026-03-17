package ioprogramming.csvdatahandling;
import java.io.*;
import org.json.*;

public class Problem14_JSONCSV {
    public static void main(String[] args) throws Exception {

        // JSON → CSV
        JSONArray arr=new JSONArray(new FileReader("students.json"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("students_from_json.csv"));
        bw.write("ID,Name,Age,Marks\n");

        for(int i=0;i<arr.length();i++){
            JSONObject o=arr.getJSONObject(i);
            bw.write(o.getInt("id")+","+o.getString("name")+","+o.getInt("age")+","+o.getInt("marks")+"\n");
        }
        bw.close();

        // CSV → JSON
        BufferedReader br=new BufferedReader(new FileReader("students_from_json.csv"));
        br.readLine();
        JSONArray out=new JSONArray();
        String line;

        while((line=br.readLine())!=null){
            String[] d=line.split(",");
            JSONObject obj=new JSONObject();
            obj.put("id",Integer.parseInt(d[0]));
            obj.put("name",d[1]);
            obj.put("age",Integer.parseInt(d[2]));
            obj.put("marks",Integer.parseInt(d[3]));
            out.put(obj);
        }
        br.close();

        BufferedWriter json=new BufferedWriter(new FileWriter("students_back.json"));
        json.write(out.toString(2));
        json.close();
    }
}
