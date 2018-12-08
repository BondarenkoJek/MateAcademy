package ua.bondarenkojek.lessons.reflection;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

            ReflectionTest reflectionTest = new ReflectionTest();

            Field field = reflectionTest.getClass().getDeclaredField("number");
            field.setAccessible(true);
            System.out.println(field.get(reflectionTest));

            field.set(reflectionTest, 15);
            System.out.println(field.get(reflectionTest));

        System.out.println(field.getType());

    }
}
