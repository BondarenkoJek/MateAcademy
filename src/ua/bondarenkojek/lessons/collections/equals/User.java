package ua.bondarenkojek.lessons.collections.equals;

public class User {
    private String name;
    private int age;
    private String street;

    public User(String name, int age, String street) {
        this.name = name;
        this.age = age;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        if (this.age != user.age) {
            return false;
        }

        if (this.name != null ? !this.name.equals(user.name) : user.name != null) {
            return false;
        }

        if (this.street != null ? !this.street.equals(user.street) : user.street != null) {
            return false;
        }

        return true;
    }
}
