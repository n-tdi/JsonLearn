package world.ntdi.jsonlearn.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.UtilityClass;
import world.ntdi.jsonlearn.objects.Parent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public final class JsonHelper {
    private static File jsonFile = new File("data/saves.json");
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void writeToFile(ArrayList<Parent> parents) throws IOException {
        String json = mapper.writeValueAsString(parents);

        FileOutputStream fooStream = new FileOutputStream(jsonFile, false); // true to append, false to overwrite.
        byte[] bytes = json.getBytes();
        fooStream.write(bytes);
        fooStream.close();
    }

    public static ArrayList<Parent> readFile() throws IOException {
        String text = Files.readString(jsonFile.toPath());
        return mapper.readValue(text, ArrayList.class);
    }

    static {
        jsonFile.mkdirs();
        if (!jsonFile.exists()) {
            try {
                jsonFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
