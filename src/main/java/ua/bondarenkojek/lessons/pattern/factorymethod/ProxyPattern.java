package ua.bondarenkojek.lessons.pattern.factorymethod;

public class ProxyPattern implements Pattern, User {
    private User user = new UserImpl();

    @Override
    public String getPatterName() {
        return "Proxy";
    }

    @Override
    public String getClassName() {
        System.out.println("Proxy");
        return user.getClassName();
    }
}
