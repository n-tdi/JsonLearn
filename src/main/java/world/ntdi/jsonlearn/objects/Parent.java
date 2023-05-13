package world.ntdi.jsonlearn.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Parent {
    private final String title;
    private final String description;
    private final List<Child> children;
}
