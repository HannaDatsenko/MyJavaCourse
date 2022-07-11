package ua.levelup;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PetsReader {
    private JSONArray arrayPets;
    public JSONArray readPets(String fileName) {
        File file = new File(fileName);
        try (FileReader reader = new FileReader(file)) {
            int fileLen = (int) file.length();
            char[] chars = new char[fileLen];
            reader.read(chars);
            String s = String.valueOf(chars);
            //System.out.println(s + "\n");
            JSONObject jsonObject = new JSONObject(s);

            JSONArray arrayPets = jsonObject.getJSONArray("pets");
            return arrayPets;
        } catch (Exception ignored) {

        }
        return arrayPets;
    }
}
