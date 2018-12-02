package ua.bondarenkojek.lessons.classes;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        Outer.Inner inner = new Outer().new Inner();
//        inner.setNumber(5);
//        System.out.println(inner.getNumber());
//
//        Outer.StaticInner inner2 = new Outer.StaticInner();

        Outer outer = new Outer();

        Local local = outer.getLocalClass();
        local.setNumber(5);

        System.out.println(local.getNumber());

        Anonymous anonymous = outer.getAnonymous();
    }
}
