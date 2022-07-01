package mailmerge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Object> text;
    private static String data;
    private static String template;
    private static String toReplace;
    private static ArrayList<String> wordsToReplace = new ArrayList<String>();
    static String[] dataText;
    private static List dataList = new ArrayList();


    // java your.java.main <csv file> <template file>
    public static void main(String[] args) throws IOException {

        data = args[0];      //CSV file
        template = args[1];

        Filler fileFiller = new Filler();

        List<Object> tempText = fileFiller.read(template);
        List<Object> dataLines = fileFiller.read(data);
        // System.out.println(temptxt);
        // System.out.println(datatxt);


        
        String[] content;
        for (Object s : tempText) {
            content = ((String) s).split(" ");
            //System.out.println(Arrays.toString(content));

            for (String c : content) {
                if (c.contains("__")) {
                    toReplace = c.replaceAll(",", "").replace("__", " ").trim();
                    wordsToReplace.add(toReplace);
                    // System.out.println(toReplace);

                }
            }
        }
        for (int i = 0; i < dataLines.size(); i++) {

            dataText = ((String) dataLines.get(i)).split(",");     // separate individual fields
            //System.out.println(Arrays.toString(dataText));

            Collections.addAll(dataList, dataText);
        }
        System.out.println(dataList);

        // System.out.println(wordsToReplace);
        // for (String w : wordsToReplace) {
        //    for (int i = 0; i < dataText.length; i++) {

        //         dataText = ((String) dataLines.get(i)).split(",");     // separate individual fields
        //         // System.out.println(Arrays.toString(dataText));
        //         //System.out.println(dataText[i]);
        //         if (dataText[i].equals(w)) {
        //             int index = i;
        //             System.out.println(index);
        //         }
                
        //         // fileFiller.Replace(s);
        //     } 
        // }

        for (String w : wordsToReplace) {
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).equals(w)) {
                    System.out.printf("%s at index %d\n", w, i);
                }
            }
        }
        
        for (String d )

    }



    // public static void read(String f) throws IOException {
    //     FileReader fr = new FileReader(f);
    //     BufferedReader br = new BufferedReader(fr);

    //     text = br.lines().collect(Collectors.toList());
    //     //System.out.println(text);

    //     br.close();
    // }
}
