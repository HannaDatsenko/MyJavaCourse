package ua.levelup.Homework11;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.*;
import java.io.FileNotFoundException;

public class ReadToMap {
    public static final String FILE_READ = "Map.txt";
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        try(FileReader reader = new FileReader(FILE_READ))
        {
            BufferedReader readerBuf = new BufferedReader(reader);
            String line = "";

            while (line != null) {
                line = readerBuf.readLine();
                if (line != null){
                    map.put(new Integer(line.substring(0,1)), line.substring(3));}
                }
            System.out.println(map);
            } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    }






