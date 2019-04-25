package view;

public interface Viewer<T> {
    void printString(String string);
    void requestResponse(T[] items);
}
