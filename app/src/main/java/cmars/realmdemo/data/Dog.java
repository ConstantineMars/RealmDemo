package cmars.realmdemo.data;

import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cmars on 9/22/17.
 */

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Dog extends RealmObject {
    private String name;
    private int age;
}
