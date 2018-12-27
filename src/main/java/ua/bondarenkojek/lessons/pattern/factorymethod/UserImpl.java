package ua.bondarenkojek.lessons.pattern.factorymethod;

public class UserImpl implements User {
    @Override
    public String getClassName() {
        return this.getClass().getSimpleName();
    }
}
