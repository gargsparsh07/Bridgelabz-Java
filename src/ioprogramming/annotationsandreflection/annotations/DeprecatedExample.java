package ioprogramming.annotationsandreflection.annotations;

class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("Old Feature - Do not use");
    }

    void newFeature() {
        System.out.println("New Feature - Recommended");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();   // shows warning
        api.newFeature();
    }
}