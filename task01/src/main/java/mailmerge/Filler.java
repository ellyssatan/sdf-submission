package mailmerge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Filler {

    private static LinkedList<String> data = new LinkedList<String>();
    private static LinkedList<String> text= new LinkedList<String>();



    public LinkedList<String> readCSV(String f) throws IOException {
        FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		while (line != null) {
			
			data.add(line);
			//System.out.println(line);
			line = br.readLine();
		}
		br.close();
        return data;
    }

    public LinkedList<String> readTemp(String f) throws IOException {
        FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		while (line != null) {
			
			text.add(line);
			//System.out.println(line);
			line = br.readLine();
		}
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
