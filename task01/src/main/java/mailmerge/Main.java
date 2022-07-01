package mailmerge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static String data;
    private static String template;
    private static String toReplace;
    private static ArrayList<String> wordsToReplace = new ArrayList<String>();
    static String[] dataText;
    private static List dataList = new ArrayList();
    private static String[] content;
    private static ArrayList<String[]> contentList = new ArrayList<String[]>();
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();


    // java your.java.main <csv file> <template file>
    public static void main(String[] args) throws IOException {

        data = args[0];      //CSV file
        template = args[1];

        Filler fileFiller = new Filler();

        LinkedList<String> tempText = fileFiller.readTemp(template);
        LinkedList<String> dataLines = fileFiller.readCSV(data);
        // System.out.println(tempText);
        // System.out.println(dataLines);

        
        for (String s : tempText) {
            content = s.split(" ");
            //System.out.println(Arrays.toString(content));
            contentList.add(content);
            System.out.println(((Object) contentList).toString());

            for (String c : content) {
                // System.out.println(c);
                if (c.contains("__")) {
                    toReplace = c.replaceAll(",", "").replace("__", " ").trim();
                    wordsToReplace.add(toReplace);
                    // System.out.println(toReplace);
                    if (c.equals(map.get(toReplace))) {

                    }
                }
                 
            }
        }
        // System.out.println(contentList);

        for (int i = 0; i < dataLines.size(); i++) {

            dataText = ((String) dataLines.get(i)).split(",");     // separate individual fields
            // System.out.println(Arrays.toString(dataText));
            for (String w : wordsToReplace) {                       // loop through fields that need to replace
                for (int k = 0; k < dataText.length; k++) {         // loop through CSV data
                    if (dataText[k].equals(w)) {
                        // System.out.printf("%s at index %d\n", w, k);
                        map.put(w, k);                        
                    }
                }
            }

            // Collections.addAll(dataList, dataText);
        }
        // System.out.println(map);

        // loop through CSV data
        for (int k = 0; k < dataText.length; k++) {
            // loop through template
            for (String s : tempText) {
                content = s.split(" ");                  // split into sentences
                // System.out.println(Arrays.toString(content));
                for (String c : content) {               // split into words
                    // System.out.println(c);
                    for (String w : wordsToReplace) {
                        if (c.contains(w)) {
                            c.replace(w, dataText[map.get(toReplace)]);
                            
                        }
                    }
                }
            }
            System.out.println(tempText);
        }
        // loop through template
        // for ()
        for (String w : wordsToReplace) {
            
        }




        for (String w : wordsToReplace) {
            for (int i = 0; i < dataText.length; i++) {
                if (dataText[i].equals(w)) {
                    System.out.printf("%s at index %d\n", w, i);
                }
            }
        }
        
        for (Object d : dataText) {
            for (String s : wordsToReplace) {
                switch (s) {


                }
            }
            
        }

    }



    // public static void read(String f) throws IOException {
    //     FileReader fr = new FileReader(f);
    //     BufferedReader br = new BufferedReader(fr);

    //     text = br.lines().collect(Collectors.toList());
    //     //System.out.println(text);

    //     br.close();
    // }
}
