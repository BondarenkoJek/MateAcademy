package ua.bondarenkojek.homework.patterns.adapter;

public class TextData implements Data {
    private Text text;

    public TextData(Text text) {
        this.text = text;
    }

    @Override
    public void create() {
        text.create();
    }

    @Override
    public void read() {
        text.read();
    }

    @Override
    public void update() {
        text.update();
    }

    @Override
    public void delete() {
        text.delete();
    }
}
