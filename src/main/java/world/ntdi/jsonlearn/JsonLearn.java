package world.ntdi.jsonlearn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import world.ntdi.jsonlearn.json.JsonHelper;
import world.ntdi.jsonlearn.objects.Child;
import world.ntdi.jsonlearn.objects.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonLearn {
    public static void main(String[] args) throws IOException {
        ArrayList<Parent> parents = new ArrayList<>();
        parents.add(new Parent("I love America",
                "It's my favorite country, It was founded in the 1700s and really smells good.",
                List.of(
                        new Child("Money", "America is Capitalistic"),
                        new Child("Government", "America is a Democracy")
                )
        ));

        JsonHelper.writeToFile(parents);

        ArrayList<Parent> taken = JsonHelper.readFile();
        System.out.println(taken);
    }
}
