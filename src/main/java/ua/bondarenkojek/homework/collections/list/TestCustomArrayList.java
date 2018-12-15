package ua.bondarenkojek.homework.collections.list;

import ua.bondarenkojek.homework.collections.list.customArrayList.CustomArrayList;

import java.util.List;

public class TestCustomArrayList {
    public static void main(String[] args) {
        List<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //1  2  3
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        list.add(1, 1);

        //1  1  2  3
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        list.add(4, 4);

        //1  1  2  3  4
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        //1  2  3  4
        System.out.println();
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }

        //true
        System.out.println();
        System.out.println(list.contains(4));

        //false
        System.out.println(list.contains(5));
    }
}
