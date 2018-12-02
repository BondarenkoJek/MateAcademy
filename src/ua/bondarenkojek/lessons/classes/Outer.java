package ua.bondarenkojek.lessons.classes;

public class Outer {
    private int number;
    private static int staticNumber;

    public Anonymous getAnonymous() {
        return new Anonymous() {
        };
    }

    public Local getLocalClass() {

        class LocalClass implements Local {

            @Override
            public int getNumber() {
                return number;
            }

            @Override
            public void setNumber (int number) {
                Outer.this.number = number;
            }
        }
        return new LocalClass();
    }

    public class Inner {
        public int getNumber() {
            return number;
        }

        public void setNumber (int number) {
            Outer.this.number = number;
        }
    }

    public static class StaticInner {
        public int getNumber() {

            return staticNumber;
        }

        public void setNumber (int staticNumber) {
            Outer.staticNumber = staticNumber;
        }
    }
}
