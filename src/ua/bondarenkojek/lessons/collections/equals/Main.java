package ua.bondarenkojek.lessons.collections.equals;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Jek", 26, "Bulgakova");
        User user2 = new User("Jek", 26, "Bulgakova");

        System.out.println(user1.equals(user2));
        System.out.println(user2.equals(user1));
        System.out.println(user1.equals(user1));
        System.out.println();

        user1.setName("Vasya");
        System.out.println(user1.equals(user2));
        System.out.println(user2.equals(user1));
        System.out.println(user1.equals(user1));
        System.out.println();

        user1.setName(null);
        user2.setName(null);
        System.out.println(user1.equals(user2));
        System.out.println(user2.equals(user1));
        System.out.println(user1.equals(user1));
    }
}
