package ioprogramming.annotationsandreflection.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User Deleted");
    }
}

public class RoleBasedAccessExample {

    static String currentUserRole = "USER";

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Method method = AdminService.class.getMethod("deleteUser");

        RoleAllowed role = method.getAnnotation(RoleAllowed.class);

        if (role.value().equals(currentUserRole)) {
            method.invoke(service);
        } else {
            System.out.println("Access Denied!");
        }
    }
}