package ioprogramming.annotationsandreflection.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class JsonUser {

    @JsonField(name="user_name")
    String username = "Sparsh";

    @JsonField(name="user_age")
    int age = 22;
}

public class JsonFieldExample {

    public static void main(String[] args) throws Exception {

        JsonUser user = new JsonUser();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = JsonUser.class.getDeclaredFields();

        boolean first = true;

        for(Field field : fields) {

            field.setAccessible(true);
            JsonField jf = field.getAnnotation(JsonField.class);

            if(jf != null) {

                if(!first) {
                    json.append(",");
                }

                json.append("\"")
                        .append(jf.name())
                        .append("\":\"")
                        .append(field.get(user))
                        .append("\"");

                first = false;
            }
        }

        json.append("}");
        System.out.println(json);
    }
}