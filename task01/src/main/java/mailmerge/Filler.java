package mailmerge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Filler {

    private static List<Object> text;
    private static String data;


    public List<Object> read(String f) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        text = br.lines().collect(Collectors.toList());
        // System.out.println(dataText);

        br.close();
        return text;
    }

    public void Replace(String word) throws IOException {
        
        // for (int i = 0; i < text.size(); i++) {
        //     if (.equals(toReplace)) {
        //         String index = getIn
        //     }
        //     System.out.println(dataText.get(i));
        // }
    }
}
