package ua.bondarenkojek.lessons.collections.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setName("Vasya");
        user1.setLastVisit(new Date());
        user1.setBooks(new HashSet<>(Arrays.asList("First book", "kobzar")));
        user1.setAge(15);
        Address address1 = new Address();
        address1.setCity("Kyiv");
        user1.setAddress(address1);

        User user2 = new User();
        user2.setName("Kolya");
        user2.setLastVisit(new Date());
        user2.setBooks(new HashSet<>(Arrays.asList("Random book", "Just book")));
        user2.setAge(17);
        Address address2 = new Address();
        address2.setCity("London");
        user2.setAddress(address2);

        User user3 = new User();
        user3.setName("Tolya");
        user3.setLastVisit(new Date());
        user3.setBooks(new HashSet<>(Arrays.asList("Book", "My book")));
        user3.setAge(20);
        Address address3 = new Address();
        address3.setCity("Paris");
        user3.setAddress(address3);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<String> addressList = users.stream()
                .map(user -> user.getAddress().getCity())
                .collect(Collectors.toList());

        addressList.forEach(System.out::println);
    }
}
