package ua.bondarenkojek.lessons.pattern.factorymethod;

public class BuilderPattern implements Pattern {
    private String name;
    private String someField;

    @Override
    public String getPatterName() {
        return "BuilderPattern";
    }

    public class Builder {
        private Builder() {
        }

        public BuilderPattern getName(String name) {
            BuilderPattern.this.name = name;
            return BuilderPattern.this;
        }

        public BuilderPattern getSomeField(String someField) {
            BuilderPattern.this.someField = someField;
            return BuilderPattern.this;
        }

        public BuilderPattern build() {
            return BuilderPattern.this;
        }
    }


}
