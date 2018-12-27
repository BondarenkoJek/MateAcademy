package ua.bondarenkojek.lessons.pattern.factorymethod;

public class BuilderPattern implements Pattern {
    private String name;
    private String someField;

    public BuilderPattern(String name, String someField) {
        this.name = name;
        this.someField = someField;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getPatterName() {
        return "BuilderPattern";
    }

    public static class Builder {
        private String name;
        private String someField;

        private Builder() {
        }

        public Builder getName(String name) {
            this.name = name;
            return this;
        }

        public Builder getSomeField(String someField) {
            this.someField = someField;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(name, someField);
        }
    }


}
