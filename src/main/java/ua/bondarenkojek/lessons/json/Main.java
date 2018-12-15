package ua.bondarenkojek.lessons.json;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/java/ua/bondarenkojek/lessons/json/userInfo.json";

        User user = new User();
        user.setAge(26);
        user.setName("Jek");

        JsonUtility.writeUserToFile(user, path);
        JsonUtility.readUserFromFile(path);
    }
}
