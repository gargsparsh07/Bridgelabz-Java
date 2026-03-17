package ioprogramming.designpatterns;

class User {

    private String name;
    private int age;

    private User(Builder b) {
        this.name = b.name;
        this.age = b.age;
    }

    static class Builder {
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String toString() {
        return name + " " + age;
    }
}

public class BuilderExample {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("Sparsh")
                .setAge(22)
                .build();

        System.out.println(user);
    }
}